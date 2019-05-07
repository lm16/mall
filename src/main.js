import Vue from 'vue'

import VueAxios from 'vue-axios'
import axios from 'axios'

import elementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import router from './util/router'
// import store from './util/store'

import App from './App'


Vue.config.productionTip = false

Vue.use(VueAxios, axios)
Vue.use(elementUI)

new Vue({
  router,
  // store,

  components: { App },
}).$mount('#app')