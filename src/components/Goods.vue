<template>
    <div class="container">
        <!-- <dh></dh> -->
        <div class="div">
            <div  id="pictur">
                <el-carousel height="200px" trigger="click">
                    <el-carousel-item v-for="item in goods.img" :key="item">
                        <img img :src="doImg(item)"  style="width:200px;height:200px;">
                    </el-carousel-item>
                </el-carousel>
            </div>
        </div>


        <div class="div"  id="message">
            <h2>{{goods.name}}</h2>
            <div id="intro">
                <el-form label-width="80px" label-position="left">
                    <el-form-item label="价格:">
                        <span>￥{{goods.price}}</span>
                    </el-form-item>
                    <el-form-item label="运费:">
                        <span>包邮</span>
                    </el-form-item>
                     <el-form-item label="销量:">
                        <span>{{goods.sold}}件</span>
                    </el-form-item>
                    <el-form-item label="库存:">
                        <span>{{goods.stock}}件</span>
                    </el-form-item>
                    <el-form-item label="温馨提示:">
                        <span style="color:#AAAAAA;font-size: 14px;">
                                <li>此商品不支持7天无理由退货</li>
                                <li>此商品由 海囤全球 发货并提供售后服务</li>
                                <li>此商品不提供国内购物发票</li>
                                <li>此商品支持白条30天免息或分期支付，不可使用京豆、京东卡、京东E卡、余额支付，不支持货到付款</li>
                                <li>根据中国海关总署要求，您所购买的商品清关入境需要提供身份证信息进行入境申报，请您配合。我们不会向第三方泄露您的资料，请您放心</li>
                        </span>
                    </el-form-item>

                </el-form>
            </div>
            <p>
                <el-input style="width:150px" v-model="goods.count">
                    <el-button slot="prepend" icon="el-icon-minus" @click="sub"></el-button>
                     <el-button slot="append" icon="el-icon-plus" @click="add"></el-button>
                </el-input>
                <el-button type="danger" @click="addTocart">加入购物车</el-button>
                <el-button type="danger" @click="Buy">立即购买</el-button>
            </p>

        </div>
        <!-- 详情介绍 -->

        <div id="detail" class="div">
             <el-menu :default-active="1" class="menu" mode="horizontal">
                <el-menu-item index="1" @click="toDetails">详情介绍</el-menu-item>
                <el-menu-item index="2" @click="toComments">商品评价</el-menu-item>
            </el-menu>
        </div>
        <div class="div" style="margin-bottom:50px;width:100%">
            <component :is="doTagView"></component>
        </div>
    </div>
</template>

<script>
import Comments from '@/components/Goods/Comments'
import Details from '@/components/Goods/Details'

export default {
    components:{
      Comments,
      Details,
    },

    props: ['id'],

    data(){
      return{
          goods: {},
          num:1,
          activeName:'second',
          length:'',
          total_price:0,
          tagView: 'Details'
      }
    },

    computed:{
        doImg(){
           return param=>{
               console.log(param)
              return 'http://172.18.44.25:8888'+param;
           }
        },

        doTagView(){
           return this.tagView;
        }
    },

    watch:{
        "goods.count":function(val,OldVal){
             this.total_price=this.goods.price*this.goods.count
        }
    },

    /*
    */

    // beforeRoteUpdate (to, from, next) {

    // },

    methods:{
        sub(){
            if(this.num>0){
                this.goods.count--;
            }
        },
        add(){
            this.goods.count++
        },
        //点击购买跳至结算页
        Buy(){
            var Datas=[]
            Datas.push(this.goods)
            console.log("goods")
            console.log(Datas)
            localStorage.setItem("selection",JSON.stringify(Datas))
            localStorage.setItem("total_price",this.total_price.toString())
            this.$router.push({name:'settlement'})
        },
        //加入购物车
        addTocart(){

        },

        toDetails(){
          this.tagView = 'Details';
        },

        toComments(){
          this.tagView = 'Comments';
        }
    },

    created(){
        this.axios.get('/goods/'+this.$route.params.id)
            .then(res=> {
                this.goods = res.data.list
                this.$set(this.goods,"gid", this.id)
                this.$set(this.goods,"count", 1)
                this.total_price=this.goods.price
            })
    },

}
</script>

<style scoped>
 .container {
        max-width: 1080px;
        margin: 0 auto;
    }
.el-carousel__item{
    transform: translateX(0) scale(1) !important;
}
.div{
    float: left;
}
#pictur{
    width:200px;
    border: 1px solid #DDDDDD;
    margin-top:30px
}
#message{
   margin-left: 50px;
   width:800px;
}
#intro{
   background-color: rgba(0, 0, 0, 0.05);
   padding-left: 30px;
}
span,label{
    color: #AAAAAA;
    font-weight: bolder;
    font-size: 14px;
}
span{
    color: red
}
.el-form-item {
    margin-bottom: 0px;
}
.main{
    margin-left: 100px;
}
.el-button--default{
    width: 30px;
    padding-left: 8px;

}
.el-button--danger{
    position:relative;
}
#detail{
    width:100%;
    margin-top: 50px;
    margin-bottom: 20px;
}
.menu{
    background-color: rgba(0, 0, 0, 0.1);
    font-weight: bolder;
    border-bottom:1px solid red;

}
a{
    text-decoration: none
}
.el-menu-item.is-active{
    background-color: rgba(255, 0, 0, 0.685);
    color: white
}
</style>

