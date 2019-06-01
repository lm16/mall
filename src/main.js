import Vue from 'vue'
import router from './router'
import VueAxios from 'vue-axios'
import axios from 'axios'
import store from './store'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import App from './App'

import dh from './components/part/Head'
import lbt from './components/part/Lbt'
import searchTool from './components/part/SearchTool'


Vue.config.productionTip = false
Vue.use(VueAxios, axios)
axios.defaults.withCredentials=true
axios.defaults.baseURL="http://172.18.44.25:8888"

Vue.use(ElementUI)

Vue.component('dh', dh)
Vue.component('lbt', lbt)
Vue.component('searchTool', searchTool)


new Vue({
  router,
  store,

  components: { App },
}).$mount('#app');
