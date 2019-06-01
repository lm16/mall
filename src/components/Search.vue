<template>
  <div class="body-bg">
    <div class="head">
      <dh></dh>
      <div style="height:50px;"></div>
      <div class="container">
        <div class="fl">
          条件
          <el-select v-model="selected">
            <el-option v-for="item in option" :value="item.value" :key="item.value" :label="item.text"></el-option>
          </el-select>
          <div class="search">
          <el-input v-model="like" placeholder="请输入内容" id="search"></el-input></div>
          <div class="ss"><el-button icon="el-icon-search" @click="doLike"><router-link to="./Search">搜索</router-link> </el-button></div>
        </div>
        <br>
          <ul class="ul">
          <template v-for="object in list">
            <li :key="object.id">
              <div class="img"><router-link :to="{path: `/home/${object.id}`}"><img :src="doImg(object.img)" class="img"></router-link></div>
              <div class="good_desc"><router-link :to="{path: `/home/${object.id}`}" class="link" :title="object.name">{{object.name}}</router-link></div>
              <p class="intro">
                <span class="qgj">抢购价：</span><span class="price">{{object.price|price}}</span>
                <span class="sold">{{object.sold|sold}}</span>
              </p>
              <div class="jr_box">
                <div class="jrgwc"><a href="">加入购物车</a></div>
                <div class="ljgm"><a href="">立即购买</a></div>
              </div>
            </li>
          </template>
          </ul>
      </div>
    </div>
  </div>
</template>

<script>

export default {

  data(){
    return{
      like: '',

      selected: 0,
      option:[
        {text: '全部', value: 0},
        {text: '零食' , value: 1},
        {text: '书籍' , value: 2},
        {text: '游戏', value: 3},
      ],

      /*
      */

      list: []
    }
  },

  computed:{
    doImg(){
      return param => {
        return 'http://172.18.44.25:8888'+param;
      }
    }
  },

  filters:{
    price(param){
      return '￥'+param
    },
    sold(param){
      return '月销'+param+'笔'
    }
  },

  /*
  */

  methods:{
    doLike(){
      if(this.like==''){
        if(this.selected === 0){
          this.axios.get('/goods')
          .then(res => {
            this.list = res.data.list
          })
        }else{
          this.axios.get('/goods?type='+this.selected)
          .then(res => {
            this.list = res.data.list
          })
        }
      }else{
        if(this.selected === 0){
          this.axios.get('/goods?like='+this.like)
          .then(res => {
            this.list = res.data.list
          })
        }else{
          this.axios.get('/goods?type='+this.selected+'&like='+this.like)
          .then(res => {
            this.list = res.data.list
          })
        }
      }
    }
  },

  /*
  */

  created(){
    this.axios.get('/goods')
    .then(res => {
      this.list = res.data.list
    })
  }
}
</script>

<style scoped>
  body {
    overflow-y: scroll;
  }

  *{
    list-style: none;
    text-decoration: none;
    color: #424242;
  }
  .search-center{
    text-align: center;
    margin: 0 auto;
    height: 45px;
    width: 420px;
  }
  .fl{
    float: left;
    width: 1080px;
  }
    .el-select{
    width: 80px;
  }
  .search{
    width: 300px;
    display: inline-block;
    margin: 0px;
    padding: 0px;
  }
  .ss {
    width: 100px;
    margin:0px;
    padding:0px;
    display: inline-block;
  }
  .body-bg {
      position: absolute;
      width: 100%;
      height: 100%;
      top: 0;
      left: 0;
      overflow-y: auto;
      background-color: #f5f5f5;
  }
  .container {
      max-width: 1080px;
      margin: 0 auto;
  }
  .head {
        height: 157.5px;
        width: 100%;
    }

  .img {
      height: 156px;
      width: 168px;
      margin: 0 auto;

  }
  .ul li {
    display: block;
    width: 230px;
    float: left;
    margin: 20px;

  }
  .ul {
    padding: 0px;
  }
  .good_desc {
    text-overflow: -o-ellipsis-lastline;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
  }
  .price {
    font-size: 16px;
    font-weight: bold;
    color: #dd182b;
  }
  .sold {
    font-size: 14px;
    color: #dd182b;
  }
  .jr_box {
    height: 43px;
    width: 230px;
  }
  .jrgwc {
    width: 115px;
    height: 43px;
    background-color: #DDD;
    float: left;
  }
  .ljgm {
    width: 115px;
    height: 43px;
    background-color: #409EFF;
    float: left;
  }
  .jr_box a {
    display: inline-block;
    width: 115px;
    height: 43px;
    text-align: center;
    line-height: 43px;
  }
  .jrgwc a:hover {
    background-color: #aaa;
    color: #DDD;
  }
  .ljgm a:hover {
    background-color: #188aff;
    color: #DDD;
  }
  .qgj {
    font-size: 14px;
    color: #dd182b;
  }

</style>
