<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>云瑞欣书行</title>

    <link rel="stylesheet" href="https://cdn.bootcss.com/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/slick-carousel/1.8.1/slick.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/slick-carousel/1.8.1/slick-theme.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/food.css">
	<link rel="stylesheet" href="css/food-index.css">
	<link rel="stylesheet" href="css/shopCart.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
	<script type="text/javascript" src="js/shopCart.js"></script>
</head>
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
    <div class="header clearf">
        <div class="container">
            <div class="logo col-2">
                <!-- <img src="image/logo.png"/> -->
            </div>
            <div class="search-bar col-5">
                <input type="text" class="col-8">
                <button class="col-2">搜索</button>
            </div>
            <div class="cart col-3">
                <div class="trigger">
                    我的购物车
                </div>
            </div>
        </div>
    </div>


	<!-- 定位 -->
	<br/><br/>

	<div class="main-promote clearf">
        <div class="container">
           <!-- 页面轮播图 -->
        </div>
    </div>
			<!-- 购物车 -->
	<div class="container">
		<div class="cart-wrapper">
			<p class="p_cart">使用新地址</p>
			<div class="cart-box">
				<form action="addressServlet" method="post">
					<table class="cart-table">
						<tr>
							<td class="tr">*收货人姓名:&nbsp;&nbsp;</td>
							<td><input type="text" placeholder="长度不超过20个字符" onblur="return checkForm()" id="c_name" name="username"></td>
							<td><span id="tips_name"></span></td>
						</tr>
						<tr>
							<td class="tr">地址信息:&nbsp;&nbsp;</td>
							<td>
								<!--2.确定事件，通过函数传参的方式拿到改变后的城市-->
								<select id="province" name="province">
									<option>--请选择--</option>
									<option value="0">北京</option>
									<option value="1">湖北</option>
									<option value="2">湖南</option>
									<option value="3">河北</option>
									<option value="4">河南</option>
									<option value="5">上海</option>
									<option value="6">广东</option>
									<option value="7">浙江</option>
									<option value="8">天津</option>
									<option value="9">重庆</option>
								</select>
								<select id="city" name="city">

								</select>
							</td>
						</tr>
						<tr>
							<td class="tr">*详细地址:&nbsp;&nbsp;</td>
							<td><textarea name="address" rows="3" cols="53" placeholder="请输入详细地址信息,如道路、门牌号、小区、楼栋号、单元等信息"></textarea></td>
						</tr>
						<tr>
							<td class="tr">邮政编码:&nbsp;&nbsp;</td>
							<td><input type="text" placeholder="请填写邮编" name="postcode"></td>
						</tr>
							<td class="tr">*手机号码:&nbsp;&nbsp;</td>
							<td><input type="text" placeholder="长度不超过11个字符" id="c_phone" onblur="return checkForm()" name="tel"></td>
							<td><span id="tips_phone"></span></td>
						</tr>
					</table>
					<br>
						<input class="cart-input" type="submit" value="使用">
				</form>
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