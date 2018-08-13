// eslint-disable
import Vue from 'vue'
import Router from 'vue-router'
import CasinoDapp from '@/components/casino-dapp'

Vue.use(Router)

export default new Router({
	routes: [{
		path: '/',
		name: 'HelloWorld',
		component: CasinoDapp
	},
	{
		path: '/test',
		name: 'HelloWorld',
		component: CasinoDapp
	}
	]
})
