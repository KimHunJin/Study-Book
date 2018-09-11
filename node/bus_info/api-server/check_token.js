const Token = require('./token');

class CheckToken {
        isCheck(masterToken) {
                var query = '';
                var isCheckToken;
                var SQL = new Token();
                isCheckToken = SQL.query(query, masterToken).then(result => {
                        if(result[0].count > 0) {
                                isCheckToken = true;
                        } else {
                                isCheckToken = false;
                        }
                        return isCheckToken;
                });
                return isCheckToken;
        }

        isCheckBus(routeId) {
                var query = '';
                var isCheckBus;
                var SQL = new Token();
                isCheckBus = SQL.query(query, routeId).then(result => {
                        if(result[0].count > 0) {
                                isCheckBus = true;
                        } else {
                                isCheckBus = false;
                        }
                        return isCheckToken;
                });
                return isCheckToken;
        }
}

module.exports =  CheckToken;