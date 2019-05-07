<template>
<div>
    <div id="order_operate">
        <el-select v-model="val3" placeholder="请选择搜索条件" >
            <el-option v-for="item in options" :label="item.value" :value="item.key" :key="item.key"></el-option>
        </el-select>
        <el-input
        placeholder="请输入关键字"
        v-model="input"
        clearable>
        </el-input>
        <el-button type="primary" icon="el-icon-search">查询</el-button>
        <el-button type="danger" icon="el-icon-delete" style="margin-left:10%" @click="deleteSelection">删除</el-button>
    </div >
    <el-table
      :data="tableData"
      :row-class-name="tableRowClassName"
      @selection-change="handleSelectionChange"
      stripe
      style="width:100%,fit:true"
      border
      >
      <el-table-column
      type="selection"
      width="50">
    </el-table-column>
    <el-table-column
      prop="id"
      label="订单号"
      width="80" >
    </el-table-column>
    <el-table-column
      prop="user_id"
      label="用户id"
      width="100" >
    </el-table-column>
    <el-table-column
      prop="goods_id"
      label="商品id"
      width="200" >
    </el-table-column>
    <el-table-column
      prop="order_date"
      label="交易时间"
      width="200">
    </el-table-column>
    <el-table-column
      prop="order_state"
      label="订单状态"
      width="100"
      >
    </el-table-column>
     
    <el-table-column
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button  type="text" size="small">编辑</el-button>
        <el-button type="text" size="small" @click.native.prevent="deleteOrder(scope.$index, tableData)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</div>
</template>
<script>
  export default {
    data() {
      return {
      tableData: [],
     options: [
     {key: "选项一", value: "订单号"},
     {key: "选项二", value: "商品id"},
     {key: "选项三", value: "已付款"},
     {key: "选项四", value: "未付款"},
    ],
      val3: [],
      name: '',
      price: '',
      input:'',
      multipleSelection: [],
      baseUrl:'http://localhost:3000'
    }
    },
    created() {
      let _this = this;
      _this.axios.get(this.baseUrl+"/order")
      .then(res => {
          _this.tableData = res.data;
          console.log(res.log)
      })
    },
    methods: {
      //删除订单
     deleteOrder(index, rows){
        let _this = this;
        _this.axios.delete(this.baseUrl+"/order/"+rows[index].id)
    .then(res => {
        _this.tableData.splice(index,1)
        console.log(res.data)
    })
    .catch(function (error) {
        console.log(error);
    });
   },
   //批量删除
    deleteSelection(){
        let l=this.multipleSelection.length
        let _this=this
        console.log(l)
          for(var i=0;i<l;i++){
            let index=_this.multipleSelection[i].index
              //  console.log("id="+_this.multipleSelection[i].id)
            _this.axios.delete(this.baseUrl+"/order/"+_this.multipleSelection[i].id)
            .then(res=>{
                 _this.tableData.splice(index,l)
                console.log(res.data)
            })
          }
     },
   //存储行索引
   tableRowClassName({row,rowIndex}){
     row.index=rowIndex
   },
   //存储已选择项
    handleSelectionChange(val){
      this.multipleSelection=val
    },
    
  },
}
</script>
<style scope>
.el-table{
  position: unset;
  font-size: 14px;
}

.el-button--mini, .el-button--small{
  font-size: 14px;
  font-weight: bold
}
#order_operate{
    width:900px;
    padding-bottom: 20px;
}

.el-input{
  width: 150px !important;
  margin-left: 50px;
}

.el-button--primary{
  margin-left: 10px;
}
</style>