<template>
	<div class='metamask-info'>
   <p v-if="isInjected" id="has-metamask"><i aria-hidden="true" class="fa fa-check"></i> Metamask installed</p>
   <p v-else id="no-metamask"><i aria-hidden="true" class="fa fa-times"></i> Metamask not found</p>
   <p>Network: {{ network }}</p>
   <p>Account: {{ coinbase }}</p>
   <p>Balance: {{ balance }} Wei // {{ ethBalance }} Eth</p>
 </div>
</template>

<script>
  import {NETWORKS} from '../util/constants/networks'
  import {mapState} from 'vuex'
  export default {
    name: 'hello-metamask',
    computed: mapState({
      isInjected: state => state.web3.isInjected,
      network: state => NETWORKS[state.web3.networkId],
      coinbase: state => state.web3.coinbase,
      balance: state => state.web3.balance,
      ethBalance: state => {
        if (state.web3.web3Instance !== null) return state.web3.web3Instance().fromWei(state.web3.balance, 'ether')
      }
  })
  }
</script>

<style scoped>
.metamask-info {
  text-align:center;
}
#has-metamask {
  color: green;
}
#no-metamask {
  color:red;
}
</style>