import Vue from 'vue'
import Router from 'vue-router'


const Home = () => import('@/components/Home')
const Search = () => import('@/components/Search')
const Cart = () => import('@/components/Cart')


const Order = () => import('@/components/Order')
const Address = () => import('@/components/Address')

//

const Settlement=()=>import('@/components/settlement')

const Regist = () => import('@/components/Regist')
const Goods = () => import('@/components/Goods')


//

const Login = () => import('@/components/Login')

/*
*/

Vue.use(Router)

const router = new Router({
  mode: 'history',

  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/search',
      component: Search
    },
    //
    {
      path: '/login',
      component: Login
    },
    {
      path: '/home/:id',
      component: Goods,
    },
    {
      path: '/cart',
      component: Cart
    },
    {
      path: '/settlement',
      component: Settlement
    },

    {
      path: '/regist',
      component: Regist
    },
    {
      path: '/order',
      component: Order,
    },
    {
      path: '/address',
      component: Address,
    }
  ]
})

router.beforeEach((to, from, next) => {
  if(to.meta.requiresAuth){

    if(localStorage.getItem("count") == null){

      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })

    }else{
      next()
    }
  }else {
      next()
  }
})

export default router
