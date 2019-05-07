<template>
    <div id="register">
        <el-container>
                <el-header>注册账号</el-header>
                <el-main>
                    <el-form  :model="ruleForm" label-width="100px" :rules="rules" ref="ruleForm" class="demo-ruleForm">
                        <el-form-item label="用户名" prop="name" >
                            <el-col :span="16">
                               <el-input v-model="ruleForm.name" clearable></el-input>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="手机号码" prop="phone">
                            <el-col :span="16">
                                <el-input v-model="ruleForm.phone" clearable></el-input>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="邮箱" prop="email">
                            <el-col :span="16">
                                <el-input type="email" v-model="ruleForm.email" clearable></el-input>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="密码" prop="password">
                            <el-col :span="16">
                                <el-input type="password" v-model="ruleForm.u_pwd" clearable></el-input>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="确认密码" prop="re_password">
                            <el-col :span="16">
                                <el-input type="password" v-model="ruleForm.re_password" clearable></el-input>
                            </el-col>
                        </el-form-item>
                    </el-form>
                        <el-footer>
                            <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
                             <el-button type="danger" @click="Back('ruleForm')">返回</el-button>
                        </el-footer>
                </el-main>
            </el-container>


    </div>
</template>
<script>
export default {
    data() {
        var validatePWD = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
        return {
            ruleForm:{
                name:"",
                phone:"",
                email:"",
                password:"",
                re_password:""
            },
            //表单验证
            rules:{
                name:[
                    {required:true,message:"请输入用户名",trigger: 'blur'},
                    {min: 4,  message: '用户名不少于3位字符', trigger: 'blur'}
                ],
                phone:[
                    {required:true,message:"请输入手机号",trigger: 'blur'},
                    {min: 11,max:11,  message: '请正确输入手机号', trigger: 'blur'}
                ],
                email:[
                    {required:true,message:"请输入邮箱",trigger: 'blur'},
                    {type:'email', message: '请输入正确的邮箱', trigger: 'blur'}
                ],
                password:[
                    {required:true,message:"请输入邮箱",trigger: 'blur'},
                    {min:6,max:18, message: '密码位6~8位', trigger: 'blur'}
                ],
                re_password:[
                    {validator:validatePWD,trigger: 'blur'}
                ]
            }   
        }
    },
    methods:{
        submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$message({
                message: '注册成功！',
                type: 'success'
            });
            this.$router.replace('/login')
          } else {
            this.$message.error('注册失败！');
            return false;
          }
        });
      },
    }
}
</script>

<style scope>
.el-container{
    padding-right: 2%;
}
.el-header{
    background-color: Transparent;
    color: black;
    text-align: center;
    line-height: 60px;
    font-weight: bolder;
    font-size: 25px;
}
.el-footer{
    text-align: center;
}
.el-main {
    background-color:Transparent;
    /* background-color: #E9EEF3; */
    color: #333;
    opacity: 0.7;
    text-align: center;
    line-height: 50px;
    padding-left: 10%;
}
#register{
    width: 50%;
    margin: 0 auto;
    
}
.el-form-item__label{
    font-size: 16px ;
    font-weight: bolder ;
}
.el-input{
}
</style>