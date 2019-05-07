<template>
  <div id="app">

     <router-view v-if="isRouterAlive"/>

  </div>
</template>

<script>
export default {

  provide(){
    return{
      reload: this.reload
    }
  },

  data(){
    return{
      isRouterAlive: true
    }
  },

  methods:{

    reload(){
      this.isRouterAlive = false
      this.$nextTick(() => {
        this.isRouterAlive = true
      })
    }
    
  }

}
</script>

<style>
#app {
  color: #2c3e50;
  margin-top: 50px;
  width: 100%;
  height: 100%;
}
/* #left{
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
/* } */ 
a{
    text-decoration: none;
    color: rgb(255, 255, 255);
    font-size: 14px !important;
}
</style>
