<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>云瑞欣书行</title>

    <link rel="stylesheet" href="https://cdn.bootcss.com/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/slick-carousel/1.8.1/slick.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/slick-carousel/1.8.1/slick-theme.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/food.css">
	<link rel="stylesheet" href="css/food-index.css">
	<link rel="stylesheet" href="css/cart.css">
</head>
<%
	int goodsCount = (int)request.getSession().getAttribute("gcount");
	float priceCount = (float)request.getSession().getAttribute("pcount");
%>
<body>
	<div class="top-nav">
        <div class="container">
            <div class="fl_nav">
                <a href="shop.jsp" class="item">首页</a>
            </div>
            <div class="fr">
                <!-- <a href="/order-show.do" class="item">我的订单</a> -->
				<span class="item yi">欢迎您: ${sessionScope.customerName}</span>
				<a href="logout.do" class="item yi">退出</a>
                <a href="login.html" class="item wei">登录</a>
                <a href="register.html" class="item wei">注册</a>
                <a href="#" class="item">客户服务</a>
            </div>
        </div>
    </div>

	<!-- 定位 -->
	<br/><br/>

	<div class="container">
		<div class="shopcart-wrapper">
			<span class="cart-title">购物车</span>
			<div>共<%=goodsCount %>件商品</div>
			<br>
			<div class="shopcart-box">
				<form action="shopCart.jsp" method="post">
				<table>
					<thead>
					<tr>
						<th  class="shopcart-main-left"><input type="checkbox" width="60px"/>全选</th>
						<th class="shopcart-main">商品图片</th>
						<th class="shopcart-main">商品名称</th>
						<!-- <th class="shopcart-main">商品描述</th> -->
						<th class="shopcart-main">商品单价</th>
						<th class="shopcart-main">数量</th>
						<th class="shopcart-main">操作</th>
					</tr>
					</thead>
					<tbody class="tbody">
						<!-- <tr>
							<td><input type="checkbox" class="qx"/></td>
							<td class="shopcart-img-list">
								<div class="shopcart-img">
									<img src="img/food/1001.jpg">
								</div>
							</td>
							<td></td>
							<td>￥</td>
							<td><input type="text" name="number" class="number" value="1"></td>
							<td><a href="delectOrderServlet?goodsID=1001">删除</a></td>
						</tr>
						-->
						<%
							request.setCharacterEncoding("utf-8");
							StringBuffer sb = (StringBuffer)request.getServletContext().getAttribute("sb");
							//System.out.println(sb.toString());
						   	out.print(sb.toString());
					    %>
					</tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<div class="shopcart-count">
								<span>合计: ￥<%=priceCount %></span>
								<!-- <span>合计: ￥9999999.99</span> -->
								<!-- <a href="#" method="get">结算</a> -->
							</div>
						</td>
					</tr>
				</table>
					<input class="shopcart-count jiesuan" type="submit" name="" value="结算">
				</form>
			<!-- 分割线 -->
			<script>
		        //查找thead下第一个th下的input
		        var chbAll=document.querySelector(
		            "thead th:first-child>input"
		        );
		        //查找tbody中所有第一个td下的input
		        var chbs=document.querySelectorAll(
		            "tbody td:first-child>input"
		        );
		        //为chbAll绑定单击事件
		        chbAll.onclick=function(){
		            //遍历chbs中每个chb
		            for(var i=0;i<chbs.length;i++){
		                //设置当前chb的checked等于this的checked
		                chbs[i].checked=this.checked;
		            }
		        }
		        //为chbs中每chb都绑定单击事件
		        for(var i=0;i<chbs.length;i++){
		            chbs[i].onclick=function(){
		                if(!this.checked)
		                    chbAll.checked=false;
		                else{
		                    //选择tbody下第一个td中的未选中的input
		                    var unchecked=
		                        document.querySelector(
		                            "tbody td:first-child>input:not(:checked)"
		                        );
		                    if(unchecked===null)
		                        chbAll.checked=true;
		                }
		            }
		        }
		 	</script>
		 	<!-- 分割线 -->
				
			</div>
		</div>
	</div>
	
	<div class="footer">
        <div class="container">
            <a href="#">联系我们</a>
            <a href="#">招聘信息</a>
            <a href="#">商家入驻</a>
            <a href="#">商家后台</a>
            <div>
                营业执照注册号：330106000004 | 网络文化经营许可证：浙网文（2016）0349-21号 | 增值电信业务经营许可证：B2-2011049 | 安全责任书 | 浙公网安备
                33010602009号
            </div>
        </div>
    </div>
	<script src="js/jquery.min.js"></script>
    <script>
        var check = "${!empty sessionScope.customerName}";
    	$(function(){
    		console.log(check);
    	    if(check=="false"){
    	        $('.yi').hide();
    	        alert("请先登录");
    		}else{
    	        $('.wei').hide();
    		}
    	});
    </script>
</body>
</html>