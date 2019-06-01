<template>
    <div class="dh">
        <div class="container">
        <div class="fl">
            <el-menu :default-active="activeIndex"
             class="el-menu-demo"
             mode="horizontal"
             @select="handleSelect"
             background-color="#eee">
                <el-menu-item index="1"><router-link to="/Home">首页</router-link></el-menu-item>
            </el-menu>
        </div>
        <div class="fr">
            <el-menu :default-active="activeIndex"
             class="el-menu-demo"
             mode="horizontal"
             @select="handleSelect"
             background-color="#eee">
                <el-menu-item index="2">
                      <span v-if="count===null">
                        <router-link to="/Login">登录</router-link>
                    </span>
                    <span v-else>
                        {{count}}
                    </span>
                </el-menu-item>
                <el-menu-item index="3">
                    <span v-if="count===null">
                        <router-link to="/Regist">注册</router-link>
                    </span>
                    <span @click="exit" v-else >
                        退出
                    </span>
                </el-menu-item>
                <el-submenu index="5">
                    <template slot="title"> <i class="el-icon-menu"></i> </template>
                    <el-menu-item index="5-1"><span @click="checkLogin('goodsDes')">购物车</span></el-menu-item>
                    <el-menu-item index="5-2"><span @click="checkLogin('address')">地址</span></el-menu-item>
                    <el-menu-item index="5-3"><span @click="checkLogin('order')">订单</span></el-menu-item>
                </el-submenu>
            </el-menu>
        </div>
        </div>
    </div>
</template>

<script>
export default {

    data() {
      return {
        activeIndex: '1',
        count:""
      };
    },
    methods:{
        handleSelect(key, keyPath) {

        },
        exit(){

            this.axios.get("/authLogout")
            .then(res=>{
                localStorage.removeItem("count")
                localStorage.removeItem("selection")
                localStorage.removeItem("total_price")
                localStorage.removeItem("address")
                localStorage.removeItem("reload")
                 this.$router.push({name:'login'})
            })
            .catch(err=>{
                console.log(err)
            })
        },
        checkLogin(type){
            if(this.count===null){
                this.$router.push({name:'login'})
            }else{
                if(type==="goodsDes"){
                   this.$router.replace({name:'goodsDes'})
                }else if(type==="address"){
                   this.$router.replace({name:'address'})
                }else if(type==="order"){
                  this.$router.replace({name:'order'})
                }
            }
        }
    },
    created(){
        this.count=localStorage.getItem("count")
        console.log(this.count)
    },

}
</script>

<style scoped>
    *{
        list-style: none;
        text-decoration: none;
        color: #424242;
    }
    .container {
        max-width: 1080px;
        margin: 0 auto;
        /* border: 1px solid black; */
    }
    .dh {
        background-color: #eee;
        width: 100%;
        height: 60px;
    }

    .dh .item {
        display: inline-block;
        padding:5px 10px;
        /* border-radius: 10px; */
        /* background-color: #999; */
    }
    .dh .item:hover {
        color: #dd182b;
    }

    .el-menu--horizontal .el-menu .el-menu-item{
        color: #424242;
    }
    .el-submenu__title i{
        color: #424242;
    }
    .fl {
        float: left;
    }

    .fr {
        float: right;
    }
</style>
