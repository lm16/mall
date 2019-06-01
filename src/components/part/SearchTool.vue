<template>
    <div class="container" style="height:97.5px">
                <img src="@/assets/img/logo.jpg" alt="" class="logo">
                <div class="search-center">
                    <div class="search">
                        <el-input v-model="input" placeholder="请输入内容" id="search"></el-input>
                    </div>
                    <div class="ss">
                        <el-button style="" icon="el-icon-search"><router-link to="./Search">搜索</router-link></el-button>
                    </div>
                </div>
    </div>
</template>

<script>
export default {
    name: 'searchTool',
    data(){
        return{
            input: '',
        }
    }
}
</script>

<style scoped>
    *{
        list-style: none;
        text-decoration: none;
        color: #424242;
    }
    .search-center{
        text-align: center;
        margin: 0 auto;
        height: 45px;
        width: 100%;
        position: absolute;
        margin-left: 350px;
        margin-top: 28.75px;
    }
    .search{
        width: 500px;
        height: 38px;
        position: relative;
        float: left;
        margin: 0px;
    }
    .ss {
        width: 100px;
        margin:0px;
        position: relative;
        float: left;
    }
    .logo{
        height: 45px;
        float: left;
        margin-top: 25.25px;
    }
</style>
