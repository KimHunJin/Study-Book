const Token= require('./token');

var isValidToken = function(token) {
	var isValid = new Token();	

	var query = 'select count(*) as count from token_key where ?? = ?';

	var arg = ['key', token];

	isValid.query(query, arg).then(result => {
	        if(result[0].count > 0) {
	                console.log(true);
	        } else {
	                console.log(false);
	        }
	});	
}
