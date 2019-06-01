<template>
<el-form-item label="收货地址">
     <el-select v-model="provice" placeholder="请选择">
            <el-option
              v-for="item in Provice"
              :key="item.proviceId"
              :label="item.proviceName"
              :value="item.proviceId"> 
              
            </el-option>
    </el-select>
    <el-select v-model="city" placeholder="请选择">
            <el-option
              v-for="item in City"
              :key="item.cityName"
              :label="item.cityName"
              :value="item.cityId"> 
              
            </el-option>
    </el-select>
    <el-select v-model="county" placeholder="请选择">
            <el-option
              v-for="item in County"
              :key="item.countyName"
              :label="item.countyName"
              :value="item.countyId"> 
              
            </el-option>
    </el-select>
    <el-select v-model="town" placeholder="请选择">
            <el-option
              v-for="item in Town"
              :key="item.townName"
              :label="item.townName"
              :value="item.townId"> 
            </el-option>
    </el-select>
    <el-select v-model="village" placeholder="请选择">
            <el-option
              v-for="item in Village"
              :key="item.villageName"
              :label="item.villageName"
              :value="item.villageId"> 
            </el-option>
    </el-select>
</el-form-item>
</template>
<script>

export default {
    data() {
        return {
            Provice:[],
            City:[],
            County:[],
            Town:[],
            Village:[],
            provice:"",
            city:"",
            county:"",
            town:"",
            village:"",
            Address:""
        }
    },
    created(){
      // this.axios.get("http://localhost:3000/position")
        this.axios.get("/authPosition")
      .then(res => {
        this.Provice = res.data.list
      })

    },
    watch: {
        "provice":function(val,Old){
            this.Provice.find(item=>{
                if(item.proviceId===val){
                  this.provice=item.proviceName
                }
              })
             this.axios.get("/authPosition?provice="+val)
             .then(res=>{
                 this.City=res.data.list
                 this.Address=this.provice+this.city+this.county+this.town+this.village
                 this.$emit("addressByChild",this.Address)

             })
             .catch(err=>{
               
             })
        },
        "city":function(val,OldVal){
          this.City.find(item=>{
                if(item.cityId===val){
                   this.city=item.cityName
                }
              })
          this.axios.get("/authPosition?city="+val)
             .then(res=>{
                 this.County=res.data.list
                 this.Address=this.provice+this.city+this.county+this.town+this.village
                 this.$emit("addressByChild",this.Address)
             })
             .catch(err=>{
               
             })
        },
        "county":function(val,OldVal){
          this.County.find(item=>{
                if(item.countyId===val){
                   this.county=item.countyName
                }
              })
          this.axios.get("/authPosition?county="+val)
             .then(res=>{
                 this.Town=res.data.list
                 this.Address=this.provice+this.city+this.county+this.town+this.village
                 this.$emit("addressByChild",this.Address)
             })
             .catch(err=>{
               
             })
        },
        "town":function(val,OldVal){
           this.Town.find(item=>{
                if(item.townId===val){
                   this.town=item.townName
                }
              })
          this.axios.get("/authPosition?town="+val)
             .then(res=>{
                 this.Village=res.data.list
                 this.Address=this.provice+this.city+this.county+this.town+this.village
                 this.$emit("addressByChild",this.Address)
             })
             .catch(err=>{
               
             })
        },
        "village":function(val,OldVal){
           this.Village.find(item=>{
                if(item.villageId===val){
                   this.village=item.villageName
                }
              })
          this.Address=this.provice+this.city+this.county+this.town+this.village
          this.$emit("addressByChild",this.Address)
        }
  },
  methods: {
   

  },
}
</script>
<style scoped>
.el-select{
    width: 120px !important;
}
</style>
