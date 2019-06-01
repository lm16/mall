<template>
    <div class="wrap">
        <div class="container">
            <div class="login-box">
                <el-form :model="form" ref="form" status-icon :rules="rules2" label-width="100px" class="demo-ruleForm">
                <div class="login-item"> <span class="login-title">账户登录</span> </div>
                <div class="login-item">
                    <el-form-item label="账号" label-width="60px" prop="name">
                    <el-input auto-complete="true" v-model="form.name"></el-input>
                    </el-form-item>
                </div>
                <div class="login-item">
                    <el-form-item label="密码" label-width="60px" prop="passwd">
                    <el-input type="password" v-model="form.passwd" auto-complete="off"></el-input>
                    </el-form-item>
                </div>
                <div class="login-item">
                    <el-form-item label-width="0px">
                        <el-button type="primary" @click="login(form)">登录</el-button>
                    </el-form-item>
                </div>
                <div class="register">
                    <span class="text">没有账号 ?</span>
                    <a href="/Regist">立即注册</a>
                </div>
                </el-form>
            </div>
        </div>

    </div>
</template>

<script>
export default {
    data() {
        return {
            form:{
               name:"",
               passwd:"",
            },

            state:"",
            rules2:{
                name:[
                    {required: true, message: '请输入用户名', trigger: 'blur' }
                ],
                passwd:[
                    {required: true, message: '请输入密码', trigger: 'blur'}
                ]
            }
        }
    },

    methods:{
        login(form){
            //  localStorage.removeItem("count")
            this.$refs.form.validate((valid) => {
          if (valid) {
            //   localStorage.setItem("count",this.form.name)
            //     this.$router.push({ path:'/home'  })
                this.axios.put("/beforeAuth",{
                    name: this.form.name,
                    passwd: this.form.passwd
                }).then(res => {
                    // this.state;
                    if(res.data.code == 0) {

                        localStorage.setItem("count",this.form.name)
                        this.$router.push({
                          path:'/home'
                        })

                    }else if(res.data.code == 1){
                        alert("登录失败，用户名或密码错误");
                    }
                })
          } else {
            return false;
          }
        });

        }
    }
}
</script>

<style scoped>
    *{
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
        max-width: 1080px;
        margin: 0 auto;
        /* border: 1px solid black; */
    }
    .login-box{
        position: relative;
        /* top: 130px; */
        background-color: #f5f5f5;
        padding: 40px;
        border: 1px solid #409EFF;
        float: right;
        width: 350px;
        height: 400px;
    }
    .login-item{
        margin: 30px;
        text-align: center;
    }
    .el-form-item__label{
        border: 1px solid #DDD;
        border-right: 0px;
    }
    .el-button{
        width: 100%;
    }
    .register{
        text-align:center
    }
    .register a:hover{
        color:#409EFF;
    }
    .login-title{
        font-weight: 700;
        font-size: 20px;
        font-family: Arial;
    }

    /* 动画 */
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
