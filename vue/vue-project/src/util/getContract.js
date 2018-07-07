// eslint-disable
import Web3 from 'web3'
import {address, ABI} from './constants/casinoContract'

let getContract = new Promise(function (resolve, reject) {
	let web3 = new Web3(window.web3.currentProvider)
	let casinoContract = new web3.eth.Contract(ABI,address)

	console.log(casinoContract)
	resolve(casinoContract)
})

export default getContract