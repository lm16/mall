<template>
    <div class="wrap">
    <div class="container">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <h1><span class="login-title">账户注册</span></h1>
        <div class="regist-item">
            <el-form-item prop="name" label-width="0px">
                <el-input type="text" v-model="ruleForm.name" placeholder="用户名"></el-input>
            </el-form-item>
        </div>
        <div class="regist-item">
            <el-form-item prop="nick" label-width="0px">
                <el-input type="text" v-model="ruleForm.nick" placeholder="昵称"></el-input>
            </el-form-item>
        </div>
        <div class="regist-item">
            <el-form-item prop="email" label-width="0px">
                <el-input type="text" v-model="ruleForm.email" placeholder="邮箱"></el-input>
            </el-form-item>
        </div>
        <div class="regist-item">
            <el-form-item prop="passwd" label-width="0px">
                <el-input type="password" v-model="ruleForm.passwd" auto-complete="off" placeholder="密码"></el-input>
            </el-form-item>
        </div>
        <div class="regist-item">
            <el-form-item prop="checkPass" label-width="0px">
                <el-input type="password" v-model="ruleForm.checkPass" auto-complete="off" placeholder="确认密码"></el-input>
            </el-form-item>
        </div>
        <div class="regist-item">
            <el-form-item label-width="0px">
                <el-button type="primary" @click="regist()">注册</el-button>
            </el-form-item>
        </div>
        <p class="change_link" align="center">
        <span class="text">已有账号 ?</span>
        <a href="/Login" class="toLogin">前往登录</a>
        </p>   
    </el-form>
    </div>
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
</template>

<script>
  export default {
    data() {
        var checkName = (rule, value, callback) => {
          const NameReg = /^[A-Za-z]+$/
            if (!value) {
            return callback(new Error('请输入用户名'));
            }
            setTimeout(() => {
            if (NameReg.test(value)) {
                callback()
            } else {
                callback(new Error('用户名只能为纯英文'))
            }
            }, 100)
        };
        var checkNick = (rule, value, callback) => {
            if (!value) {
            return callback(new Error('请输入昵称'));
            }
            callback();
        };
        var checkEmail = (rule, value, callback) => {
            const mailReg = /^[0-9A-Za-z][\.-_0-9A-Za-z]*@[0-9A-Za-z]+(\.[0-9A-Za-z]+)+$/
            if (!value) {
            return callback(new Error('邮箱不能为空'))
            }
            setTimeout(() => {
            if (mailReg.test(value)) {
                callback()
            } else {
                callback(new Error('请输入正确的邮箱格式'))
            }
            }, 100)
        }
        var validatePass = (rule, value, callback) => {
            if (value === '') {
            callback(new Error('请输入密码'));
            } else {
            if (this.ruleForm.checkPass !== '') {
                this.$refs.ruleForm.validateField('checkPass');
            }
            callback();
            }
        };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.passwd) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
        return {
          test: '',
            ruleForm: {
            name: '',
            email: '',
            passwd: '',
            checkPass: '',
            nick: '',
            },
            rules: {
            name: [
                { validator: checkName, trigger: 'blur' }
            ],
            nick: [
                { validator: checkNick, trigger: 'blur' }
            ],
            email: [
                { validator: checkEmail, trigger: 'blur' }
            ],
            passwd: [
                { validator: validatePass, trigger: 'blur' }
            ],
            checkPass: [
                { validator: validatePass2, trigger: 'blur' }
            ],
            }
        }
    },
    methods:{
        regist(){
            this.axios.post("/user",{
                name: this.ruleForm.name,
                nick: this.ruleForm.nick,
                email: this.ruleForm.email,
                passwd: this.ruleForm.passwd

            }).then((response) => {
              localStorage.setItem("count",this.ruleForm.name)
              this.$router.push({ path:'/home'  })
            })
            .catch(function (error) {
              alert("注册失败");
            });
        },
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
            if (valid) {
                alert('submit!');
            } else {
                console.log('error submit!!');
                return false;
            }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
  }
</script>

<style scoped>
    * {
      box-sizing: border-box;
      list-style: none;
      color: #424242;
      font-size: 16px;
    }
    body {
      margin: 0;
      padding: 0;
      font: 16px/20px microsft yahei;
    }
    .wrap {
      width: 100%;
      height: 100%;
      padding: 10% 0;
      position: fixed;
      opacity: 0.8;
      background: linear-gradient(to bottom right,#000000, #409EFF);
      background: -webkit-linear-gradient(to bottom right,#50a3a2,#53e3a6);
    }
    .container {
      width: 60%;
      margin: 0 auto;
    }
    .login-title{
        color: #f5f5f5;
        font-weight: 700;
        font-size: 20px;
        font-family: Arial;
    }
    .regist-item{
        width: 340px;
        display: block;
        height: 36px;
        border: 0;
        outline: 0;
        padding: 6px 10px;
        line-height: 24px;
        margin: 32px auto;
        -webkit-transition: all 0s ease-in 0.1ms;
        transition: all 0s ease-in 0.1ms;
    }
    .el-button{
        width: 100%;
    }
    .container h1 {
      text-align: center;
      color: #FFFFFF;
      font-weight: 500;
    }
    .container input {
      width: 320px;
      display: block;
      height: 36px;
      border: 0;
      outline: 0;
      padding: 6px 10px;
      line-height: 24px;
      margin: 32px auto;
      -webkit-transition: all 0s ease-in 0.1ms;
      -moz-transition: all 0s ease-in 0.1ms;
      transition: all 0s ease-in 0.1ms;
    }
    .container input[type="text"] , .container input[type="password"] {
      background-color: #FFFFFF;
      font-size: 16px;
      color: #50a3a2;
    }
    .container input[type='submit'] {
      font-size: 16px;
      letter-spacing: 2px;
      color: #666666;
      background-color: #FFFFFF;
    }
    .container input:focus {
      width: 400px;
    }
    .container input[type='submit']:hover {
      cursor: pointer;
      width: 400px;
    }
    .toLogin{
        color:#f5f5f5;
    }
    .toLogin:hover{
        color: #409EFF;
    }
    .text{
      color: #e2dfe4;
    }
    .wrap ul {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      z-index: -20;
    }
    .wrap ul li {
      list-style-type: none;
      display: block;
      position: absolute;
      bottom: -120px;
      width: 15px;
      height: 15px;
      z-index: -8;
      border-radius: 50%;
      background-color:rgba(255, 255, 255, 0.15);
      animation: square 25s infinite;
      -webkit-animation: square 25s infinite;
    }
    .wrap ul li:nth-child(1) {
      left: 0;
      animation-duration: 10s;
      -moz-animation-duration: 10s;
      -o-animation-duration: 10s;
      -webkit-animation-duration: 10s;
    }
    .wrap ul li:nth-child(2) {
      width: 40px;
      height: 40px;
      left: 10%;
      animation-duration: 15s;
      -moz-animation-duration: 15s;
      -o-animation-duration: 15s;
      -webkit-animation-duration: 11s;
    }
    .wrap ul li:nth-child(3) {
      left: 20%;
      width: 25px;
      height: 25px;
      animation-duration: 12s;
      -moz-animation-duration: 12s;
      -o-animation-duration: 12s;
      -webkit-animation-duration: 12s;
    }
    .wrap ul li:nth-child(4) {
      width: 50px;
      height: 50px;
      left: 30%;
      -webkit-animation-delay: 3s;
      -moz-animation-delay: 3s;
      -o-animation-delay: 3s;
      animation-delay: 3s;
      animation-duration: 12s;
      -moz-animation-duration: 12s;
      -o-animation-duration: 12s;
      -webkit-animation-duration: 12s;
    }
    .wrap ul li:nth-child(5) {
      width: 60px;
      height: 60px;
      left: 40%;
      animation-duration: 10s;
      -moz-animation-duration: 10s;
      -o-animation-duration: 10s;
      -webkit-animation-duration: 10s;
    }
    .wrap ul li:nth-child(6) {
      width: 75px;
      height: 75px;
      left: 50%;
      -webkit-animation-delay: 7s;
      -moz-animation-delay: 7s;
      -o-animation-delay: 7s;
      animation-delay: 7s;
    }
    .wrap ul li:nth-child(7) {
      left: 60%;
      width: 30px;
      height: 30px;
      animation-duration: 8s;
      -moz-animation-duration: 8s;
      -o-animation-duration: 8s;
      -webkit-animation-duration: 8s;
    }
    .wrap ul li:nth-child(8) {
      width: 90px;
      height: 90px;
      left: 70%;
      -webkit-animation-delay: 4s;
      -moz-animation-delay: 4s;
      -o-animation-delay: 4s;
      animation-delay: 4s;
    }
    .wrap ul li:nth-child(9) {
      width: 50px;
      height: 50px;
      left: 80%;
      animation-duration: 20s;
      -moz-animation-duration: 20s;
      -o-animation-duration: 20s;
      -webkit-animation-duration: 20s;
    }
    .wrap ul li:nth-child(10) {
      width: 75px;
      height: 75px;
      left: 90%;
      -webkit-animation-delay: 6s;
      -moz-animation-delay: 6s;
      -o-animation-delay: 6s;
      animation-delay: 6s;
      animation-duration: 30s;
      -moz-animation-duration: 30s;
      -o-animation-duration: 30s;
      -webkit-animation-duration: 30s;
    }


    @keyframes square {
      0% {
        -webkit-transform: translateY(0);
        transform: translateY(0)
      }
      100% {
        bottom: 400px;
        -webkit-transform: translateY(-500);
        transform: translateY(-500)
      }
    }
    @-webkit-keyframes square {
      0% {
        -webkit-transform: translateY(0);
        transform: translateY(0)
      }
      100% {
        bottom: 400px;
        -webkit-transform: translateY(-500);
        transform: translateY(-500)
      }
    }
</style>
