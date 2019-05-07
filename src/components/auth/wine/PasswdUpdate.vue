<template>
    <div id="forget">

        密码出来挨打
        <!-- <el-container>
                <el-header>注册账号</el-header>
                <el-main>
                    <el-form  :model="ruleForm" label-width="100px" :rules="rules" ref="ruleForm" class="demo-ruleForm">
                        <el-form-item label="新密码" prop="password" >
                            <el-col :span="16">
                               <el-input v-model="ruleForm.password" clearable></el-input>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="再次确认密码" prop="re_password">
                            <el-col :span="16">
                                <el-input v-model="ruleForm.re_password" clearable></el-input>
                            </el-col>
                        </el-form-item>
                        
                    </el-form>
                        <el-footer>
                            <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
                             <el-button type="danger" @click="Back('ruleForm')">返回</el-button>
                        </el-footer>
                </el-main>
        </el-container> -->
    </div>
</template>



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
</style>
