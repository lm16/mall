<template>
    <div id="login">
        <span id="title">
            <i>WELCOME!</i>
        </span>
        <div id="container">
            <el-container>
                <el-header>网上商城系统</el-header>
                <!-- 

                 -->
                <el-main>
                        <el-input placeholder="请输入账号名" type="text" v-model.trim="username"></el-input>
                        <el-input placeholder="请输入密码" type="password" v-model.trim="passwd"></el-input>
                        <el-button type="danger" @click="login" style="font-weight:bolder;font-size:20px">登录</el-button>
                        <el-footer>
                            <router-link to="/register">注册</router-link>|
                             <router-link to="/??">忘记密码</router-link>
                        </el-footer>
                </el-main>
            </el-container>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            username:"22",
            passwd:"33",

            baseUrl: 'http://172.18.44.25:8888'
        }
    },
    methods:{

        login(){
            this.axios.post(this.baseUrl+'/user/root/login', {
                username: this.username,
                passwd: this.passwd
            }).then(res => {
                alert(res.data)
            })
        }

        /*
        v1
        */
        // login(){
        //     this.$router.replace('/home')
        // },

        /*
        v2
        */
    //     handleLogin() {
    //         this.$refs.AccountFrom.validate((valid) => {
    //         if(valid) {
    //             this.logining = true;
    // //其中 'm/login' 为调用的接口，this.account为参数
    //             this.$post('m/login',this.account).then(res => {
    //             this.logining = false;
    //             if(res.errCode !== 200) {
    //                 this.$message({
    //                 message: res.errMsg,
    //                 type:'error'
    //                 });
    //             } else {
    //                 let expireDays = 1000 * 60 * 60 ;
    //                 this.setCookie('session',res.errData.token,expireDays); //设置Session
    //                 this.setCookie('u_uuid',res.errData.u_uuid,expireDays); //设置用户编号
    //                 if(this.$route.query.redirect) {
    //                 this.$router.push(this.$route.query.redirect);
    //                 } else {
    //                 this.$router.push('/home'); //跳转用户中心页
    //                 }
    //             }
    //             });
    //         } else {
    //             console.log('error submit');
    //             return false;
    //         }
    //     });
    //   }
    }
}
</script>

<style scoped>
.el-header{
    background-color: #B3C0D1;
    color: white;
    text-align: center;
    line-height: 60px;
    font-weight: bolder;
    font-size: 20px;
}
.el-footer{
    text-align: right;
}
.el-main {
    background-color:#B3C0D1;
    /* background-color: #E9EEF3; */
    color: #333;
    opacity: 0.5;
    text-align: center;
    line-height: 160px;
}
#login{
    width: 100%;
    background-color: #E9EEF3;
}
#img{
    float: left;
    margin-top: 10%;
    margin-left: 10%
}
#container{
    width: 30%;
    margin-left: 60%;
    float: left;
}
#title{
    margin-left: 10%;
    text-align: center;
    color: white;
    font-weight: bolder;
    font-size: 100px;
    text-shadow: 5px 5px 5px grey;
}
.el-main{
    line-height: 80px;
}
.el-button{
    width: 100%
}
a{
    color: blue;
    font-weight: bolder;
}
</style>
