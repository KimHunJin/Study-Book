import Web3 from 'web3'

let getWeb3 = new Promise(function (resolve, reject) {
	var web3js = window.web3
	if (typeof web3js !== 'undefined') {
		var web3 = new Web3(web3js.currentProvider)
		resolve({
			injectedWeb3: web3.isConnected(),
			web3 () {
				return web3
			}
		})
	} else {
		reject(new Error('unable to connect to metamask'))
	}
}).then(result => {
	return new Promise(function (resolve, reject) {
		result.web3().version.getNetwork((err, networkId) => {
			if (err) {
				reject(new Error('unable to retrieve network id'))
			} else {
				result = Object.assign({}, result, {networkId})
				resolve(result)
			}
		})
	})
}).then(result => {
	return new Promise(function (resolve, reject) {
		result.web3().eth.getCoinbase((err, coinbase) => {
			if (err) {
				reject(new Error('unable to retrieve coinbase'))
			} else {
				result = Object.assign({}, result, {coinbase})
				resolve(result)
			}
		})
	})
}).then(result => {
	return new Promise(function (resolve, reject) {
		result.web3().eth.getBalance(result.coinbase, (err, balance) => {
			if (err) {
				reject(new Error('unable to retrieve balance for address: ' + result.coinbase))
			} else {
				result = Object.assign({}, result, {balance})
				resolve(result)
			}
		})
	})
})

export default getWeb3