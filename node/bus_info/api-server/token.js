var mysql_dbc = require('./db_con')();
var connection = mysql_dbc.init();
mysql_dbc.test_open(connection);

class IsValidToken {

        query(sql, args) {
                return new Promise((resolve, reject) => {
                        connection.query(sql, args, (err, rows) => {
                                if(err) {
                                        return reject(err);
                                }
                                resolve(rows);
                        });
                });
        }
        close() {
                return new Promise((resolve, reject) => {
                        connection.end(err => {
                                if(err) return reject(err);
                                resolve();
                        });
                });
        }
}

module.exports = IsValidToken;