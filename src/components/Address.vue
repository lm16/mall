<template>
  <el-scrollbar>
  <dh></dh>
  <div class="container">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>我的收货地址</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="add">添加新地址</el-button>
        </div>
        <div v-for="(item,index) in address" :key="index" class="text item" @click="getAdress(item)">
            <span>{{item.receiveName}}</span>
            <span>{{item.receivePhone}}</span>
            <!-- <span style="float:right;margin-left:20px"><el-link icon="el-icon-delete" @click.native.prevent="cancel(index)"></el-link></span> -->
            <span style="float:right;margin-left:20px"><el-link icon="el-icon-edit" @click.native.prevent="edit(index)"></el-link></span>
        <div>
            <el-tag type="danger">默认</el-tag>
            {{item.name}}
          </div>

        </div>
      </el-card>
      <el-dialog title="收货地址" :visible.sync="dialogFormVisible">
        <el-form :model="form" :rules="rules" status-icon >
          <el-form-item label="收货人" prop="receiveName">
            <el-input v-model="form.receiveName"  autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="手机号码" prop="receivePhone">
            <el-input v-model="form.receivePhone" autocomplete="off"></el-input>
          </el-form-item>
              <addressOptions v-on:addressByChild="addressByChild"></addressOptions>
          <el-switch
            v-model="Default"
            inactive-text="设为默认地址">
          </el-switch>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="add_submit">确 定</el-button>
        </div>
    </el-dialog>
  </div>
  </el-scrollbar>
</template>
<script>

export default {

  data() {
    var checkName = (rule, value, callback) => {
      const NameReg = /^[\u4e00-\u9fa5]{2,3}$/
        if (!value) {
        return callback(new Error('请输入收货人姓名'));
        }
        setTimeout(() => {
        if (NameReg.test(value)) {
            callback()
        } else {
            callback(new Error('用户名只能为2-3位汉字'))
        }
        }, 100)
    };

    var checkPhone = (rule, value, callback) => {
      const PhoneReg = /^1[34578]\d{9}$/
        if (!value) {
        return callback(new Error('手机号码不能为空'));
        }
        setTimeout(() => {
        if (PhoneReg.test(value)) {
            callback()
        } else {
            callback(new Error('手机号码格式错误'))
        }
        }, 100)
    };

    return {
      dialogFormVisible: false,
      Default:false,
      form:{
        receiveName:"",
        receivePhone:"",
        address:"",
      },
      rules: {
          receiveName: [
              { validator: checkName, trigger: 'blur' }
          ],
          receivePhone: [
              { validator: checkPhone, trigger: 'blur' }
          ],
        },
        address:[],
        operation:"",
        index:0,
        value:"",
        a: []
      }
    },

  /*
  */

  methods: {
    //
    edit(i){
      // alert(i)
      this.form=this.address[i]
      this.dialogFormVisible=true,
      this.operation="edit",
      this.index=i
    },

    //
    add(){
      this.dialogFormVisible=true
      this.form={
          receiveName:"",
          receivePhone:"",
          address:"",
       }
       this.operation="add"
    },

    //
    add_submit(){
      if(this.operation==="add"){
           this.axios.post("/authAddress",
            {
                "name":this.form.address,
                "receiveName":this.form.receiveName,
                "receivePhone":this.form.receivePhone,
            }
            )
            .then(res=>{
              this.$message({
                message: '添加成功',
                type: 'success'
              });
              //实时在页面中更新
              this.address.push(res.data)
              this.dialogFormVisible=false
            })
            .catch(err=>{
              this.$message.error('添加失败，请重试！');
            })
      }else if(this.operation==="edit"){//修改地址
        this.axios.put("/authAddress",
        {
            "address":this.form.address,
            "receiveName":this.form.receiveName,
            "receivePhone":this.form.receivePhone,
            "uid":this.address[this.index].uid,
            "postcode": this.address[this.index].postcode,
            "aid":this.address[this.index].aid,
            "id":5
        }
        )
        .then(res=>{
          this.$message({
            message: '修改成功',
            type: 'success'
          });
          this.$router.go(0)
          this.dialogFormVisible=false
        })
        .catch(err=>{
          this.$message.error('修改失败，请重试！');
        })
      }
    },

    //
    addressByChild(childValue){
       this.form.address=childValue
    },

    //在结算时选择地址传给结算页面
    getAdress(address){
      if(this.$route.query.select){
          localStorage.setItem("address", JSON.stringify(address))
          this.$router.push({name:'settlement'})
      }
    }
  },

  created(){
    this.axios.get("/authAddress")
    .then(res=>{
      this.address=res.data.list
    })
  }

}
</script>

<style scoped>
  .container {
    max-width: 1080px;
    margin: 0 auto;
    /* border: 1px solid black; */
  }
  .box-card{
    width: 100%;
  }
  .text {
    font-size: 14px;
    cursor: pointer;
  }

  .item {
    margin-bottom: 18px;
    cursor: pointer;
  }
</style>

