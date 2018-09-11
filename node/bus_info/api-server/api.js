var express = require('express');
var router = express.Router();
var check = require('../db/check_token');
var https = require('https');
var http = require('http');
var xml2js = require('xml2js');
var parser = new xml2js.Parser();
var request = require('request-promise');

router.post('/addBus', function(req, res, next) {
        var url = '';
        var token = req.headers['token'];
        var serviceKey = req.body['key'];
        var busNumber = req.body['number'];

        url = url + 'serviceKey=' + serviceKey;
        url = url + '&strSrch='+busNumber;

        var c = new check();
        c.isCheck(token).then(value => {
                if(value == true) {
                        return url;
                } else {
                        res.send('unvalid token');
                        res.end();
                }
        }).then(url => {
                return request(url);
        }).then(xml => {
                return new Promise(function(resolve, reject) {
                        parser.parseString(xml, function(err, result) {
                                if(err) {
                                        reject(err);
                                } else {
                                        resolve(result.ServiceResult.msgBody[0].itemList);
                                }
                        });
                });
        }).then(result => {
                result.forEach(function(element) {
                        var busNumber = element.busRouteNm;
                        var busStartTime = element.firstBusTm;
                        var busEndTime = element.lastBusTm;
                        var term = 10;
                        var routeId = element.busRouteId;

                        console.log(busNumber + " " + routeId);
                });
        });
        res.end();
});

router.post('/addBusInfo', function(req, res, next) {
        var token = req.headers['token'];
        var url = '';
        var serviceKey = req.body['key'];
        var busRouteId = req.body['route'];

        url = url + 'serviceKey=' + serviceKey;
        url = url + '&busRouteId='+busRouteId;

        var c = new check();
        c.isCheck(token).then(value => {
                if(value == true) {
                        return url;
                } else {
                        res.send('unvalid token');
                        res.end();
                }
        }).then(url => {
                return new Promise(function(resolve, reject) {
                        c.isCheckBus(busRouteId).then(value => {
                                resolve(value);
                        });
                });
        }).then(url => {
                if(value == true) {
                        // get mysql
                } else {
                        return request(url);                        
                }
        }).then(xml => {
                return new Promise(function(resolve, reject) {
                        parser.parseString(xml, function(err, result) {
                                if(err) {
                                        reject(err);
                                } else {
                                        resolve(result.ServiceResult.msgBody[0].itemList);
                                }
                        });
                });
        }).then(result => {
                result.forEach(function(element) {
                        var stationNo = element.stationNo;
                        var stationName = element.stationNm;
                        var routeId = element.busRouteId;
                        var seq = element.seq;
                        // todo ; insert query in mariadb
                });
        });
});