import Web3 from 'web3'

let getWeb3 = new Promise(function (resolve, reject) {

	if(typeof web3 !== 'undefined') {
		console.log('web3 injected brwoser: ok.')
		window.web3 = new Web3(window.web3.currentProvider)
		console.log('get web3 log', window.web3)

		resolve({
			injectedWeb3: web3.eth.net.isListening(),
			web3() {
				return window.web3
			}
		})

	} else {
		console.log('web3 injected browser: fail. you sould consider trying metamask.')
		reject(new Error('unable to connect to metamask'))
	}
}).then(result => {
	return new Promise(function (resolve, reject) {
		result.web3().eth.net.getId((err, networkId) => {
			if(err) {
				reject(new Error('unalbe network'))
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