import Vue from 'vue';
import Vuex from 'vuex';

import createPersistedState from "vuex-persistedstate"


Vue.use(Vuex)

var state={

}

var mutations={

}

export default new Vuex.Store({
	state,
  mutations,

	plugins: [createPersistedState({
		storage: window.sessionStorage
	})]
})
