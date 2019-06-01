<template>
    <div style="width:100%">
        <el-badge :value="truecomment.length" class="item">
            <el-button size="small"  @click="show('all')">全部</el-button>
        </el-badge>
        <el-badge :value="bad.length" class="item">
            <el-button size="small" @click="show('bad')">差评</el-button>
        </el-badge>
        <el-badge :value="common.length" class="item">
            <el-button size="small"  @click="show('common')">一般</el-button>
        </el-badge>
        <el-badge :value="good.length" class="item" >
            <el-button size="small" @click="show('good')">好评</el-button>
        </el-badge>
        <div >
            <div v-for="(item,index) in comments.slice((currentPage-1)*pagesize,currentPage*pagesize)" :key="index" id="comments">
                    <div >
                        <el-tag type="danger">{{index+1}}</el-tag>
                        <span>{{item.nick}}</span>
                        <el-rate show-text v-model="item.star" disabled="true" style="display:inline;margin-left:20px"></el-rate>
                        <span style="margin-left:20%">
                            {{item.time}}
                        </span>
                    </div>
                    <div style="margin-top:20px">
                       {{item.content}}
                    </div>
            </div>
            <el-pagination
                layout="prev, pager, next"
                @current-change="currentChange"
                :page-size="20"
                :total="total">
            </el-pagination>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            comments:[],
            good:[],
            truecomment:[],
            common:[],
            bad:[],
            currentPage:1,
            total:0,
            pagesize:20
        }
    },
    created(){
        this.axios.get("/comments?gid="+this.$route.params.id)
        .then(res=>{
            // console.log(res.data)
            // console.log(res.data[0].list)
            this.comments=res.data.list
            this.truecomment=res.data.list
            //  this.comments=res.data[0].list
            //  this.truecomment=res.data[0].list
             this.total=this.comments.length
             this.comments.forEach(element=>{
                 if(element.star<=2){
                     this.bad.push(element)
                 }else if(element.star==3){
                     this.common.push(element)
                 }else if(element.star>3){
                     this.good.push(element)
                 }
             })
        })
    },
    methods:{
       currentChange(currentPage){
            this.currentPage=currentPage
       },
       show(type){
        if(type=='all'){
            this.comments=this.truecomment

        }else if(type=='bad'){
            this.comments=this.bad
        }else if(type=='common'){
            this.comments=this.common
            this.total=this.common.length
        }else if(type=='good'){
            this.comments=this.good
            this.total=this.good.length
        }
        this.total=this.comments.length
        console.log(this.total)
       }
    }
}
</script>



<style scoped>
.item {
  margin-top: 10px;
  margin-right: 40px;
}
#comments{
    margin-top:20px;
}
</style>
