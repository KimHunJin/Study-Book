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
}

module.exports =  CheckToken;