<template>
  <div id="index">

    <div id="left">
      <el-col :span="12">
        <el-menu default-active="1" class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
          <!--  -->
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>商品</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1"><router-link to="/goods">查</router-link></el-menu-item>
                <el-menu-item index="2-2"><router-link to="/goods/add">加</router-link></el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <!-- 

             -->
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>用户</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-1"><router-link to="/user">查</router-link></el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <!-- 

             -->
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-document"></i>
                <span>订单</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="3-1"><router-link to="/order">查</router-link></el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <!-- 

             -->
            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-document"></i>
                <span>评论</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="4-1"><router-link to="/comment">查</router-link></el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <!-- 

             -->
            <el-submenu index="5">
              <template slot="title">
                <i class="el-icon-setting"></i>
                <span>账号</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="5-1"><router-link to="/passwd/update">修改密码</router-link></el-menu-item>
                <el-menu-item index="5-2">退出登录</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <!--  -->
        </el-menu>
      </el-col>
    </div>

    <div id="center">
      <router-view />
    </div>
    
  </div>
</template>

<style>
 #index {
   font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale; 
  color: #2c3e50;
  margin-top: 50px;
  width: 100%;
  height: 100%;
} 
#left{
  width: 250px;
  float: left;
  height: 800px; 
  background-color:#545c64
}
#center{
  float: left;
  margin-left: 5%;
  width: auto;
}
.el-col-12 {
    width: 100%;
    height: 100%;
    /* height: 800px; */
}
a{
    text-decoration: none;
    color: rgb(255, 255, 255);
    font-size: 14px !important;
}
</style>
