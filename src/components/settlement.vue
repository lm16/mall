<template>
    <div class="container">
       
        <el-card class="box-card">
             <div slot="header" class="clearfix">
                <span>收货地址</span>
                <el-button style="float: right; padding: 3px 0" type="text" @click="selectAddress">选择地址</el-button>
             </div>
            <div  class="text item">
                <span>{{address.receiveName}}</span>
                <span>{{address.receivePhone}}</span>
                <div>
                    {{address.name}}
                </div>
            </div>
        </el-card>
          <el-card v-for="(item,index) in databs" :key="index" class="box-card" style="margin-top:20px">
             <div  slot="header" class="clearfix">
                <span>{{item.name}}</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text" @click="selectAddress">选择地址</el-button> -->
             </div>
            <div  class="text item">
                <span>{{item.desc}}</span>
                <span>￥{{item.price}}×{{item.count}}</span>
                <div>
                    配送方式：普通配送
                </div>
                <div>
                    运费险：卖家送，确认收获前退货可赔
                </div>
                <div>
                    店铺优惠：
                </div>
                <div>
                    订单备注：的付款就会发光的共和党了广泛化工
                </div>
            </div>
        </el-card>
        <div style="margin-top:50px;margin-bottom:50px;">
            <span v-if="databs.length<=0">共0件，</span>
            <span v-if="databs.length>0&&databs.length!=null">共{{databs.length}}件，</span>
            <span>合计：￥{{total_price}}</span>
            <span>
                <el-button type="danger" style="margin-left:30px" @click="SubmitOrder">提交订单</el-button>
            </span>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            address:{},
            databs:[],
            total_price:0
        }
    },
    created(){
        if(localStorage.getItem("selection")===null){
            this.databs=[]
        }else{
            this.databs=JSON.parse(localStorage.getItem("selection"))
        }
        
        this.total_price=JSON.parse(localStorage.getItem("total_price")) 
        console.log("Data")
        console.log(this.databs)
        if(JSON.parse(localStorage.getItem("address")===null)){
            this.address={
                receiveName:"",
                receivePhone:"",
                name:""
            }
        }else{
            this.address=JSON.parse(localStorage.getItem("address")) 
        }
    },
    methods: {
        //转到地址页面获取地址
        selectAddress(){
            this.$router.push({name:'address',query:{select:true},repalce:true})
        },
        //提交至订单
        SubmitOrder(){
            // let cartList=[],
            // this.databs.forEach(element=>{

            // })
            let list=[]
            console.log("list")
            console.log(list)
            this.databs.forEach(element=>{
                list.push({
                    "gid":element.gid,
                    "count":element.count
                })
            })
            console.log(list)
            this.axios.post("/authOrder",{
                "aid":this.address.id,
                "cartList":list
            })
            .then(res=>{
                 //清空结算
                 localStorage.removeItem("selection")
                 localStorage.removeItem("total_price")
                 localStorage.removeItem("address")
                 this.databs=[]
                 this.address="",
                 this.total_price=0
                 localStorage.setItem("Issettlement","true")
                 //从购物车中删除
                this.$message({
                    message: '提交成功',
                    type: 'success'
              });
            })
            .catch(err=>{
            
               this.$message.error('提交失败，请重试！');
            })
        }
    },
}
</script>
<style scoped>
 .container {
        max-width: 1080px;
        margin: 0 auto;
        /* border: 1px solid black; */
}
</style>

