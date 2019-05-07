import Vue from 'vue'
import Router from 'vue-router'

const Login = ()=>import('@/components/Login')
const Register = ()=>import('@/components/Register')
const Home = ()=>import('@/components/auth//Home')

const Comment = ()=>import('@/components/auth/wine/Comment')
const Goods = ()=>import('@/components/auth/wine/Goods')
const GoodsAdd = ()=>import('@/components/auth/wine/GoodsAdd')
const Order = ()=>import('@/components/auth/wine/Order')
const PasswdUpdate = ()=>import('@/components/auth/wine/PasswdUpdate')
const User = ()=>import('@/components/auth/wine/User')

Vue.use(Router)

const router= new Router({

  mode: 'history',

  routes: [
    {
      path:'/',
      redirect: '/home'
    },
    {
      path:'/login',
      component:Login,
    },
    {
      path:'/register',
      component:Register,
    },
    {
      path:'/home',
      component:Home,
      meta:{
        requireAuth:true,//需要登录
      },
      children:[
        {
          path:'/comment',
          // meta:{
          //   requireAuth:true,//需要登录
          // },
          component:Comment
        },
        {
          path:'/goods',
          // meta:{
          //   requireAuth:true,//需要登录
          // },
           component:Goods
        },
        {
          path:'/goods/add',
          // meta:{
          //   requireAuth:true,//需要登录
          // },
          component:GoodsAdd
        },
        {
          path:'/order',
          // meta:{
          //   requireAuth:true,//需要登录
          // },
          component:Order,
        },
        {
          path:'/passwd/update',
          component:PasswdUpdate,
        },
        {
          path:'/user',
          // meta:{
          //   requireAuth:true,//需要登录
          // },
          component:User
        },
      ]
    },
  ]
})

/*
v1
*/
// router.beforeEach((to, from, next) => {
//   if(to.meta.requireAuth) {
//     fetch('m/is/login').then(res => {
//       if(res.errCode == 200) {
//         next();
//       } else {
//         if(getCookie('session')) {
//           delCookie('session');
//         }
//         if(getCookie('u_uuid')) {
//           delCookie('u_uuid');
//         }
//         next({
//           path: '/'
//         });
//       }
//     });
//   } else {
//     next();
//   }
// })


/*
v2
*/
// router.beforeEach((to, from, next) => {
//   // to and from are both route objects. must call `next`.
//   if (to.meta.requireAuth) {  // 判断该路由是否需要登录权限
//     if (store.state.token) {  // 通过vuex state获取当前的token是否存在
//         next();
//     }
//     else {
//         next({
//             path: '/login',
//             query: {redirect: to.fullPath}  // 将跳转的路由path作为参数，登录成功后跳转到该路由
//         })
//     }
// }
// else {
//     next();
// }
// })

router.beforeEach(function (to, from, next) {
  if(to.meta.requireAuth){
    // if (store.state.token) {
      // next()
    // }
    //  else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    // }
  }else{
    next()
  }
})

export default router