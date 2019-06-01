<template>
	<el-scrollbar>
		<dh></dh>
		<div class="container">
			<h4>购物车<i class="el-icon-goods"></i></h4>
			<el-table
				height="450"
				ref="multipleTable"
				empty-text="暂无商品"
				:data="cart_list"
				@selection-change="handleSelectionChange"
				style="width: 100%">
				<el-table-column
				 type=selection
				>
				</el-table-column>
				<el-table-column
				label="商品名称"
				prop="name">
				</el-table-column>
				<el-table-column
				label="描述"
				prop="desc">
				</el-table-column>
				<el-table-column
				label="价格"
				prop="price">
				</el-table-column>
				<el-table-column
				label="数量">
					<template slot-scope="scope">
						<div class="div_number">
							<el-input-number :min="1" @change="handleChange($event,scope.$index)" size="mini" v-model="scope.row.count">
							</el-input-number>
						</div>
                    </template>
				</el-table-column>
				<el-table-column
					fixed="right"
					label="操作"
					width="120">
					<template slot-scope="scope">
						<el-button
						@click.native.prevent="deleteRow(scope.$index, cart_list)"
						type="text"
						size="small">
						移除
						</el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-row>
				<el-col :span="8">
					<span style="font-size:12px">共 {{cart_list.length}}种商品，已选择 {{selectionNum.length}} 件</span>
				</el-col>
				<el-col :span="16">
					合计： {{total_price}}元
				<el-button type="primary" @click="settle">去结算</el-button>
				</el-col>
			</el-row>
		</div>
	</el-scrollbar>
</template>

<script>
import dh from './part/Head'
export default {
	data() {
      return {
			cart_list:[],
			selectionNum:[],
			}
    },
	components: {
        dh
	},
	created(){
		JSON.parse(localStorage.getItem("cart_list"))
    if(localStorage.getItem("cart_list")===null){
			this.cart_list=[]
		}else{
			this.cart_list=JSON.parse(localStorage.getItem("cart_list"))
		}
		console.log("List")
		console.log(this.cart_list)
	},
	computed: {
		total_price:function(){
			if(this.selectionNum.length<=0){
				return 0
			}else{
				var total=0;
				this.selectionNum.forEach(item=>{
						total=item.count*item.price+total
						console.log("total")
						console.log(total)
				})
				return total
			}
		}
	},
	methods: {
		deleteRow(index, rows) {
		rows.splice(index, 1);
		},
		handleSelectionChange:function (val) {
			this.selectionNum=val
			console.log("Select")
			console.log(this.selectionNum)

		},
		handleChange:function (val,index) {
			console.log("Num")
			console.log(val)
			console.log(this.cart_list[index].price)

		},
		getCartList(){
			this.axios.get('/cart_list')
			.then(res =>{
				this.cart_list = res.data.cart_list
			})
		},
		settle(){
			if(this.total_price<=0){
				 this.$message({
					message: '请选择商品',
					type: 'warning'
				});
			}else{
				localStorage.setItem("selection",JSON.stringify(this.selectionNum))
				localStorage.setItem("total_price", this.total_price.toString())
				this.selectionNum.forEach(item=>{
					this.cart_list.forEach(element=>{
						if(item.gid===element.gid){
							this.cart_list.pop(element)
						}
					})
				})
				this.$router.push({name:"settlement"})

			}
		}
    }
}
</script scoped>

<style scoped>

	.body-bg {
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        overflow-y: auto;
        background-color: #f5f5f5;
    }
    .container {
        max-width: 1080px;
        margin: 0 auto;
	}
	.container h4{
		font-family: Arial, Helvetica, sans-serif;
		font-weight: 700px;
		font-size: 18px;
		margin-top: 30px;
		margin-bottom: 20px;
		color: #424242;
	}
	/* 引入样式 */
	.demo-table-expand {
		font-size: 0;
	}
	.demo-table-expand label {
		width: 90px;
		color: #99a9bf;
	}
	.demo-table-expand .el-form-item {
		margin-right: 0;
		margin-bottom: 0;
		width: 50%;
	}
	a{
		cursor: pointer;
	}
</style>
