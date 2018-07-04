 <!-- eslint-disable -->
<template>
  <div class="casino container">
    <h1>Welcome to the Casino</h1>
    <h4>Please pick a number between 1 and 10</h4>
    Amount to bet: <input v-model="amount" placeholder="0 Ether">
    <ul>
      <li v-on:click="clickNumber">1</li>
      <li v-on:click="clickNumber">2</li>
      <li v-on:click="clickNumber">3</li>
      <li v-on:click="clickNumber">4</li>
      <li v-on:click="clickNumber">5</li>
      <li v-on:click="clickNumber">6</li>
      <li v-on:click="clickNumber">7</li>
      <li v-on:click="clickNumber">8</li>
      <li v-on:click="clickNumber">9</li>
      <li v-on:click="clickNumber">10</li>
    </ul>
    <img v-if="pending" id="loader" src="https://loading.io/spinners/double-ring/lg.double-ring-spinner.gif">
    <div class="event" v-if="winEvent">
      <p v-if="winEvent._status" id="has-won"><i aria-hidden="true" class="fa fa-check"></i> Congragulations, you have won {{winEvent._amount}} wei</p>
      <p v-else id="has-lost"><i aria-hidden="true" class="fa fa-times"></i> Sorry you lost, try again.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'casino',
  data () {
    return {
      amount: null,
      pending: false,
      winEvent: null
    }
  },
  methods: {
    clickNumber (event) {
      console.log('BETTING ON NUMBER, AMOUNT', event.target.innerHTML, this.amount)
      this.winEvent = null
      this.pending = true
      this.$store.state.contractInstance().bet(event.target.innerHTML, {
        gas: 300000,
        value: this.$store.state.web3.web3Instance().toWei(this.amount, 'ether'),
        from: this.$store.state.web3.coinbase
      }, (err, result) => {
        if (err) {
          console.log(err)
          this.pending = false
        } else {
          let Won = this.$store.state.contractInstance().Won()
          Won.watch((err, result) => {
            if (err) {
              console.log('could not get event Won()')
            } else {
              this.winEvent = result.args
              this.winEvent._amount = parseInt(result.args._amount, 10)
              this.pending = false
            }
          })
        }
      })
    }
  },
  mounted () {
    console.log('dispatching getContractInstance')
    this.$store.dispatch('getContractInstance')
  }
}
</script>

<style scoped>
.casino {
 margin-top: 50px;
 text-align:center;
}
#loader {
  width:150px;
}
ul {
  margin: 25px;
  list-style-type: none;
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-column-gap:25px;
  grid-row-gap:25px;
}
li{
  padding: 20px;
  margin-right: 5px;
  border-radius: 50%;
  cursor: pointer;
  background-color:#fff;
  border: -2px solid #bf0d9b;
  color: #bf0d9b;
  box-shadow:3px 5px #bf0d9b;
}
li:hover{
  background-color:#bf0d9b;
  color:white;
  box-shadow:0px 0px #bf0d9b;
}
li:active{
  opacity: 0.7;
}
*{
 color: #444444;
}
#has-won {
  color: green;
}
#has-lost {
  color:red;
}
</style>