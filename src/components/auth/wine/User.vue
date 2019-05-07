<template>
<div>
    <div id="operate">
        <el-select v-model="val3" placeholder="请选择搜索条件" >
            <el-option v-for="item in options" :label="item.value" :value="item.key" :key="item.key"></el-option>
        </el-select>
        <el-input
        placeholder="请输入关键字"
        v-model="input"
        clearable>
        </el-input>
        <el-button type="primary" icon="el-icon-search">查询</el-button>
        <el-button type="danger" icon="el-icon-delete" style="margin-left:20%" @click="deleteSelection">删除</el-button>
    </div >
    <el-table
      :data="tableData"
      :row-class-name="tableRowClassName"
      stripe
      style="width:100%,fit:true"
      border
      @selection-change="handleSelectionChange"
      >
    <el-table-column
    type="selection"
    width="50">
    </el-table-column>
    <el-table-column
      prop="truename"
      label="姓名"
      width="80" >
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      width="250" >
    </el-table-column>
    <el-table-column
      prop="postcode"
      label="邮政编码"
      width="100">
    </el-table-column>
    <el-table-column
      prop="birthday"
      label="出生日期"
      width="100"
      >
    </el-table-column>
    <el-table-column
      prop="phone"
      label="手机号码"
      width="150" >
    </el-table-column>
    <el-table-column
      prop="email"
      label="邮箱"
      width="200" >
    </el-table-column>
    <el-table-column
    label="操作"
    width="50">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click.native.prevent="deleteUserInfo(scope.$index, tableData)">删除</el-button>
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
     {key: "选项一", value: "姓名"},
     {key: "选项二", value: "地址"},
     {key: "选项三", value: "手机号"},
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
      _this.axios.get(this.baseUrl+"/user_info")
      .then(res => {
          _this.tableData = res.data;
          console.log(res.log)
      })
    },
    methods: {
        //删除用户信息
        deleteUserInfo(index, rows){
          let _this = this;
            _this.axios.delete(this.baseUrl+"/user_info/"+rows[index].id)
        .then(res => {
            _this.tableData.splice(index,1)
            console.log(res.data)
        })
        .catch(function (error) {
            console.log(error);
        });
      },
      //批量删除
      deleteSelection(row){
        let l=this.multipleSelection.length
        let _this=this
          for(var i=0;i<l;i++){
            let index=_this.multipleSelection[i].index
              console.log("id="+_this.multipleSelection[i].id)
            _this.axios.delete(this.baseUrl+"/user_info/"+_this.multipleSelection[i].id)
            .then(res=>{
                 _this.tableData.splice(index,l)
                console.log(res.data)
            })
          }
      },
      //存储已选择所有象
      handleSelectionChange(val){
        this.multipleSelection = val;
      },
      //储存行所所引，供批量删除使用
      tableRowClassName({row,rowIndex}){
           row.index=rowIndex
      }
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
#operate{
  padding-bottom: 20px;
}

.el-input{
  width: 150px !important;
  margin-left: 50px;
}
.add{
  margin-left: 5%;
  text-decoration: none;
  color: blue;
  font-size: 18px !important;
}
.el-button--danger{
     margin-left: 30%;
}
.el-button+.el-button {
    margin-left: px;
}
.el-button--primary{
  margin-left: 10px;
}
</style>