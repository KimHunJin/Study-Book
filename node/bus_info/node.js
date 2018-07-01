const request = require('request');
const cheerio = require('cheerio');
const moment = require('moment');
require('moment-timezone');
moment.tz.setDefault("Asia/Seoul");

var mysql_dbc = require('./db_con')();
var connection = mysql_dbc.init();
mysql_dbc.test_open(connection);

var array = [

'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000389&busRouteId=100100154&seq=1&stationNm=%ED%9D%A5%EC%95%88%EC%9A%B4%EC%88%98%EC%83%81%EA%B3%844%EB%8F%99%EC%A2%85%EC%A0%90&wbustp=N',
'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000125&busRouteId=100100154&seq=2&stationNm=%ED%9D%A5%EC%95%88%EC%9A%B4%EC%88%98%EC%A2%85%EC%A0%90&wbustp=N',
'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000126&busRouteId=100100154&seq=3&stationNm=%EB%B6%88%EC%95%94%ED%98%84%EB%8C%80%EC%95%84%ED%8C%8C%ED%8A%B8&wbustp=N',
'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000127&busRouteId=100100154&seq=4&stationNm=%EB%8F%99%EC%95%84%EB%B6%88%EC%95%94%EC%95%84%ED%8C%8C%ED%8A%B8&wbustp=N',
'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000130&busRouteId=100100154&seq=5&stationNm=%EB%B6%88%EC%95%94%EB%8C%80%EB%A6%BC%EC%95%84%ED%8C%8C%ED%8A%B8&wbustp=N',
'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000140&busRouteId=100100154&seq=6&stationNm=%EC%83%81%EA%B3%84%EB%B2%BD%EC%82%B0%EC%95%84%ED%8C%8C%ED%8A%B8&wbustp=N',
'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000120&busRouteId=100100154&seq=7&stationNm=%EC%83%81%EA%B3%84%EB%8F%99%EC%A3%BC%EC%9C%A0%EC%86%8C&wbustp=N',
'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000118&busRouteId=100100154&seq=8&stationNm=%EC%83%81%EA%B3%84119%EC%95%88%EC%A0%84%EC%84%BC%ED%84%B0&wbustp=N',
'http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000116&busRouteId=100100154&seq=9&stationNm=%EC%83%81%EA%B3%84%EC%A4%91%ED%95%99%EA%B5%90&wbustp=N'
];

var station_number = [
110000389,
110000125,
110000126,
110000127,
110000130,
110000140,
110000120,
110000118,
110000116
];

var infos = [];

var mDate = moment().format('YYYY-MM-DD HH:mm:ss');

async function getInfo(_station_number, _date, _url) {
	var station = _station_number;
	request(_url, (error, response, body) => {
		if(error) throw error;

		var times = [];

		let $ = cheerio.load(body);

		let name = $('ul li.info_busname').text();

		$('ul li.info_bus font').each(function() {
			times.push($(this).text());
		});

		var query = "insert into info values(" + station + ", 'bus', '" + times[0] + "', '" +
		times[1] + "', '" + _date + "')";


		let v = insertDate(query);

		return true;
	});
	return true;
}

async function insertDate(query) {
	connection.query(query, function(err, result) {
		if(err) {
			console.error(err);
			return false;
		} else {
			console.log('success');
			return 1;
		}
	});
}

function get() {
	
}




