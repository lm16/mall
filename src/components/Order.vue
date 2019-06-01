<template>
	<el-scrollbar>
			<dh></dh>
			<div class="container">
			<el-table
				:data="tableData"
				style="width: 100%"
				>
				<el-table-column
					prop="time"
					label="时间"
					width="160">
				</el-table-column>
				<el-table-column
					prop="address.receiveName"
					label="接收人"
					width="120">
				</el-table-column>
				<el-table-column
					prop="address.receivePhone"
					label="接收号码"
					width="120">
				</el-table-column>
				<el-table-column
					prop="pay"
					label="总额"
					width="120">
				</el-table-column>
				<el-table-column
					prop="address.name"
					label="地址"
					width="300">
				</el-table-column>
				<el-table-column
					prop="state"
					label="支付状态"
					width="120">
				</el-table-column>
				<el-table-column
					fixed="left"
					label="操作"
					width="120">
					<template slot-scope="scope">
						<!-- <el-popover
							ref="popover"
							trigger="click">
							<el-table :data="gridData">
								<el-table-column width="150" property="goods" label="商品名"></el-table-column>
								<el-table-column width="100" property="price" label="单价"></el-table-column>
								<el-table-column width="300" property="count" label="数量"></el-table-column>
								<el-table-column width="300" property="subTotal" label="价格小计"></el-table-column>
							</el-table>
						</el-popover>
						<el-button v-popover:popover>订单详情</el-button> -->
							<el-popover ref="popover" placement="left" width="800" trigger="click">
								<el-table :data="tableData[scope.$index].cart">
									<el-table-column width="500" property="goods" label="商品名"></el-table-column>
									<el-table-column width="100" property="price" label="单价"></el-table-column>
									<el-table-column width="100" property="count" label="数量"></el-table-column>
									<el-table-column width="100" property="subTotal" label="价格小计"></el-table-column>
								</el-table>
							</el-popover>
							<el-button v-popover:popover>订单详情</el-button>
					</template>
				</el-table-column>
			</el-table>
		</div>
	</el-scrollbar>
</template>

<script>
import dh from './part/Head'
  export default {
    methods: {
      deleteRow(index, rows) {
        rows.splice(index, 1);
      }
		},
		components: {
			dh
		},
    data() {
      return {
        tableData: [{
					address:{

             time: '2019-05-30 11:31:37',
							name: '内蒙古自治区通辽市开鲁县义和塔拉镇小林场村委会',
							receiveName: '章善瑞',
							receivePhone: '5676578',
							pay: '',
							state: '未支付'
					},
					cart:[
							{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
						{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
						{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
					]
				},
				{
						address:{
              time: '2019-05-29 11:31:37',
							name: '内蒙古自治区通辽市开鲁县义和塔拉镇小林场村委会',
							receiveName: '章善瑞',
							receivePhone: '5676578',
							pay: '',
							state: '未支付'
					},
					cart:[
							{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
						{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
						{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
					]

				},

				{
          address:{
              time: '2019-05-28 11:31:37',
							name: '内蒙古自治区通辽市开鲁县义和塔拉镇小林场村委会',
							receiveName: '章善瑞',
							receivePhone: '5676578',
							pay: '',
							state: '未支付'
					},
					cart:[
						{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
						{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
						{
							goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
							price: '49.8',
							count: '2',
							subTotal: ''
						},
					]

        }
      ],
				// tableData:[],
				gridData:[],
				// gridData: [{
        //   goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
        //   price: '49.8',
        //   count: '2',
        //   subTotal: ''
        // },{
        //   goods: '好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g',
        //   price: '33.8',
        //   count: '1',
        //   subTotal: ''
        // },]
      }
		},
		created(){
			this.axios.get("/authOrder")
			.then(res=>{
				// res.data.list.forEach(element => {
				// 	this.tableData.push(element.address)
				// });
				this.tableData=res.data.list
				this.tableData.forEach(element => {
					this.gridData.push(element.cart)
				});
				console.log(this.gridData)
			})
		}
  }
</script>

<style scoped>
	.container {
        max-width: 1080px;
        margin: 0 auto;
        /* border: 1px solid black; */
	}
</style>
