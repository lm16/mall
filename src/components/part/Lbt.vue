<template>
    <div class="container1">
        <el-carousel :interval="4000" type="card" height="200px">
            <el-carousel-item v-for="item in imgList" :key="item.id">
                <el-row>
                    <el-col :span="24"><img ref="imgHeight" :src="item.idView" class="banner_img"/></el-col>
                </el-row>
            </el-carousel-item>
        </el-carousel>
  </div>
</template>

<script>
export default {
    name: 'lbt',
    data() {
    return{
        // 图片需要引入, 否则无法显示
        imgList: [
          {id: 0, idView: require('@/assets/img/2001.jpg')},
          {id: 1, name: '详情', idView: require('@/assets/img/2002.jpg')},
          {id: 2, name: '推荐', idView: require('@/assets/img/2003.jpg')}
        ]
     }
    }
}
</script>


<style scoped>
    .container1 {
        max-width: 1080px;
        margin: 0 auto;
        /* border: 1px solid black; */
    }
    .banner_img{
        height: 166px;
    }

    .el-col-24 {
        text-align: center;
    }
    .el-carousel--horizontal{
        max-width: 1080px;
        margin: 0 auto;
        /* right: 100px; */
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 200px;
        margin: 0;
    }

    /* .el-carousel__item:nth-child(2n) {
        background-image: url(../assets/img/2001.jpg)
        background-color: #475669;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    } */
</style>
