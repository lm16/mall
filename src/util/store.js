import Vue from 'vue'
import Vuex from 'vuex'
import Cookie from 'vue-cookies'

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        token: Cookie.get('token')
    },

    mutations:{
        saveToken(state, token){
            state.token = token
            Cookie.set('token', token, '20min')
        },
        clearToken(state){
            Cookie.remove('token')
            state.token = null
        }
    }
})