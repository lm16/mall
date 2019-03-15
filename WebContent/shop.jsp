<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>云瑞欣迷你商铺</title>

    <link rel="stylesheet" href="https://cdn.bootcss.com/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/slick-carousel/1.8.1/slick.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/slick-carousel/1.8.1/slick-theme.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/food.css">
	<link rel="stylesheet" href="css/food-index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
	<script>
		function init(){
			setInterval("changeImg()",3000);
		}
		var i=0;
		function changeImg(){
			i++;
			if(i==5){
				i=1;
			}
			document.getElementById("img").src="lunbotu/100"+i+".jpg"
			document.getElementById("img1").src="lunbotu/200"+i+".jpg"
			document.getElementById("img2").src="lunbotu/300"+i+".jpg"
		}
	</script>
</head>
<body onload="init()">
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
                <img class="logoclass" src="img/log.jpg" height=55px/>
            </div>
            <div class="search-bar col-5">
                <form action="searchServlet" method="post">
                	<input type="text" name="goodssName" class="col-8" style="height:45px;">
                	<button class="col-2" style="width: "><input type="submit" name="submit" value="搜索"/></button>
                </form>

            </div>
            <div class="cart col-3">
                <div class="trigger" style="background-color: #dd182b;  height: 50px;" >
                  <a href="showOrderServlet" style="color:white; font-size:17px;">我的购物车</a>
                </div>
            </div>
        </div>
    </div>
	
	<!-- 定位 -->
	<div class="toolbar-tabs">
		<div class="toolbar_cart ">
			<a class="toolbar_goods" href="#toolbar_ls" rel="nofollow">零食</a>
		</div>
		<div class="toolbar_cart">
			<a class="toolbar_goods" href="#toolbar_yx" rel="nofollow">游戏</a>
		</div>
		<div class="toolbar_cart">
			<a class="toolbar_goods" href="#toolbar_sj" rel="nofollow">书籍</a>
		</div>
		<div class="toolbar_cart carts"><a href="showOrderServlet">购物车</a></div>
		<!-- <div><img src="img/gwc.jpg"></div> -->
		<div class="toolbar_cart kefus"><a href="#">客服</a></div>
		<div id="top" class="">
			<a href="#" style="color: #424242;">返回顶部</a>
		</div>
	</div>

	<!--轮播图-->
	<div class="lbt">
        <div class="container">
        	<div class="lbt-box" >
			    <img src="lunbotu/1001.jpg" height="319px"  id="img"/>
            </div>
            <div class="lbt-box" >
            	<img src="lunbotu/2001.jpg" height="319px"  id="img1"/>
            </div>
            <div class="lbt-box" >
            	<img src="lunbotu/3001.jpg" height="319px"  id="img2"/>
            </div>
        </div>
    </div>

	<div class="container">
		<div class="promote-title" id="toolbar_ls">零食</div>
		<div class="food-wrapper">
			<div class="good-list">
				<ul class="good-list">
					<li class="fl">
						<div>
							<a href="details/food_1.html" target="_blank">
								<img src="img/food/1001.jpg" height="156px"
									alt="俏香阁 坚果炒货 休闲零食 果仁 烘焙紫皮腰果158g/袋" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/food_1.html" target="_blank" class="food-sbox">
									俏香阁 坚果炒货 休闲零食 果仁 烘焙紫皮腰果158g/袋
								</a>
							</div>
							<div>
								<a href="details/food_1.html" class="fcr">抢购价 :<span class="sfzb">￥42.80</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=1001">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=1001">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/food_2.html" target="_blank">
								<img src="img/food/1002.jpg" height="156px"
									alt="三只松鼠坚果炒货零食特产每日坚果开心果100g/袋" width="168">
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/food_2.html" target="_blank" class="food-sbox">
									三只松鼠坚果炒货零食特产每日坚果开心果100g/袋
								</a>
							</div>
							<div>
								<a href="details/food_2.html" class="fcr">抢购价 :<span class="sfzb">￥39.90</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=1002">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=1002">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href=details/food_3.html target="_blank">
								<img src="img/food/1003.jpg" height="156px"
									alt="良品铺子酥脆薄饼薄脆海苔咸饼干 盒装咸味零食小吃早餐休闲食品300g" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/food_3.html" target="_blank" class="food-sbox">
									良品铺子酥脆薄饼薄脆海苔咸饼干 盒装咸味零食小吃早餐休闲食品300g
								</a>
							</div>
							<div>
								<a href="details/food_3.html" class="fcr">抢购价 :<span class="sfzb">￥14.90</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=1003">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=1003">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/food_4.html" target="_blank">
								<img src="img/food/1004.jpg" height="156px"
									alt="俏香阁 蜜饯果干 零食小吃 休闲零食 芒果干108g/袋" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/food_4.html" target="_blank" class="food-sbox">
									俏香阁 蜜饯果干 零食小吃 休闲零食 芒果干108g/袋
								</a>
							</div>
							<div>
								<a href="details/food_4.html" class="fcr">抢购价 :<span class="sfzb">￥16.90</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=1004">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=1004">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/food_5.html" target="_blank">
								<img src="img/food/1005.jpg" height="156px"
									alt="三只松鼠肉干肉脯零食特产小吃麻辣卤味牛肉熟食孜香牛肚120g/袋" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/food_5.html" target="_blank" class="food-sbox">
									三只松鼠肉干肉脯零食特产小吃麻辣卤味牛肉熟食孜香牛肚120g/袋
								</a>
							</div>
							<div>
								<a href="details/food_5.html" class="fcr">抢购价 :<span class="sfzb">￥36.90</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=1005">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=1005">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/food_6.html" target="_blank">
								<img src="img/food/1006.jpg" height="156px"
									alt="好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/food_6.html" target="_blank" class="food-sbox">
									好时之吻Kisses炫彩多口味巧克力 糖果零食婚庆婚庆喜糖散装500g
								</a>
							</div>
							<div>
								<a href="details/food_6.html" class="fcr">抢购价 :<span class="sfzb">￥49.80</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=1006">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=1006">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/food_7.html" target="_blank">
								<img src="img/food/1007.jpg" height="156px"
									alt=" 德芙 Dove精心之选多种口味巧克力礼盒 糖果巧克力 礼品 圣诞节生日礼物280g" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/food_7.html" target="_blank" class="food-sbox">
									 德芙 Dove精心之选多种口味巧克力礼盒 糖果巧克力 礼品 圣诞节生日礼物280g
								</a>
							</div>
							<div>
								<a href="details/food_7.html" class="fcr">抢购价 :<span class="sfzb">￥121.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=1007">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=1007">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/food_8.html" target="_blank">
								<img src="img/food/1008.jpg" height="156px"
									alt=" 益达（Extra）尊享护齿 新年年货年糖 56g*3瓶定制装" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/food_8.html" target="_blank" class="food-sbox">
									 益达（Extra）尊享护齿 新年年货年糖 56g*3瓶定制装
								</a>
							</div>
							<div>
								<a href="details/food_8.html" class="fcr">抢购价 :<span class="sfzb">￥25.50</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=1008">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=1008">立即购买</a></div>
							</div>
						</div>
					</li>
					<div class="promote-title">书籍</div>
					<div class="hide" id="toolbar_sj"></div>
					<li class="fl">
          <div>
            <a href="details/book_1.html" target="_blank">
              <img src="img/book/2001.jpg"
                alt="这是一本好书" width="168"
              >
            </a>
          </div>
          <div>
            <div class="food-box">
              <a href="details/book_1.html" target="_blank" class="food-sbox">
                		<br /> 《老人与海》
              </a>
            </div>
            <div>
              <a href="details/book_1.html" class="fcr">抢购价 :<span class="sfzb">￥18.50</span></a>
            </div>
            <div class="jr-box">
                <div class="jrgwc font-c"><a href="addOrderServlet?goodsID=2001">加入购物车</a></div>
                <div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=2001">立即购买</a></div>
              </div>
          </div>
        </li>
        <li class="fl">
          <div>
            <a href="details/book_2.html" target="_blank">
              <img src="img/book/2002.jpg"
                alt="这是一本好书" width="168"
              >
            </a>
          </div>
          <div>
            <div class="food-box">
              <a href="details/book_2.html" target="_blank" class="food-sbox">
                		<br /> 《我的天才女友》
              </a>
            </div>
            <div>
              <a href="details/book_2.html" class="fcr">抢购价 :<span class="sfzb">￥33.20</span></a>
            </div>
            <div class="jr-box">
                <div class="jrgwc font-c"><a href="addOrderServlet?goodsID=2002">加入购物车</a></div>
                <div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=2002">立即购买</a></div>
              </div>
          </div>
        </li>
        <li class="fl">
          <div>
            <a href="details/book_3.html" target="_blank">
              <img src="img/book/2003.jpg"
                alt="这是一本好书" width="168"
              >
            </a>
          </div>
          <div>
            <div class="food-box">
              <a href="details/book_3.html" target="_blank" class="food-sbox">
                		<br /> 《亦恕与珂雪》
              </a>
            </div>
            <div>
              <a href="details/book_3.html" class="fcr">抢购价 :<span class="sfzb">￥21.40</span></a>
            </div>
            <div class="jr-box">
                <div class="jrgwc font-c"><a href="addOrderServlet?goodsID=2003">加入购物车</a></div>
                <div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=2003">立即购买</a></div>
              </div>
          </div>
        </li>
        <li class="fl">
          <div>
            <a href="details/book_4.html" target="_blank">
              <img src="img/book/2004.jpg"
                alt="这是一本好书" width="168"
              >
            </a>
          </div>
          <div>
            <div class="food-box">
              <a href="details/book_4.html" target="_blank" class="food-sbox">
                		<br /> 《平凡的世界》
              </a>
            </div>
            <div>
              <a href="details/book_4.html" class="fcr">抢购价 :<span class="sfzb">￥39.80</span></a>
            </div>
            <div class="jr-box">
                <div class="jrgwc font-c"><a href="addOrderServlet?goodsID=2004">加入购物车</a></div>
                <div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=2004">立即购买</a></div>
              </div>
          </div>
        </li>
        <li class="fl">
          <div>
            <a href="details/book_5.html" target="_blank">
              <img src="img/book/2005.jpg"
                alt="这是一本好书" width="168"
              >
            </a>
          </div>
          <div>
            <div class="food-box">
              <a href="details/book_5.html" target="_blank" class="food-sbox">
                		<br /> 《人性的弱点》
              </a>
            </div>
            <div>
              <a href="details/book_5.html" class="fcr">抢购价 :<span class="sfzb">￥19.70</span></a>
            </div>
            <div class="jr-box">
                <div class="jrgwc font-c"><a href="addOrderServlet?goodsID=2005">加入购物车</a></div>
                <div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=2005">立即购买</a></div>
              </div>
          </div>
        </li>
        <li class="fl">
          <div>
            <a href="details/book_6.html" target="_blank">
              <img src="img/book/2006.jpg"
                alt="这是一本好书" width="168"
              >
            </a>
          </div>
          <div>
            <div class="food-box">
              <a href="details/book_6.html" target="_blank" class="food-sbox">
                		<br /> 《告白》
              </a>
            </div>
            <div>
              <a href="details/book_6.html" class="fcr">抢购价 :<span class="sfzb">￥25.40</span></a>
            </div>
            <div class="jr-box">
                <div class="jrgwc font-c"><a href="addOrderServlet?goodsID=2006">加入购物车</a></div>
                <div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=2006">立即购买</a></div>
              </div>
          </div>
        </li>
        <li class="fl">
          <div>
            <a href="details/book_7.html" target="_blank">
              <img src="img/book/2007.jpg"
                alt="这是一本好书" width="168"
              >
            </a>
          </div>
          <div>
            <div class="food-box">
              <a href="details/book_7.html" target="_blank" class="food-sbox">
                			<br /> 《经济学原理》
              </a>
            </div>
            <div>
              <a href="details/book_7.html" class="fcr">抢购价 :<span class="sfzb">￥54.00</span></a>
            </div>
            <div class="jr-box">
                <div class="jrgwc font-c"><a href="addOrderServlet?goodsID=2007">加入购物车</a></div>
                <div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=2007">立即购买</a></div>
              </div>
          </div>
        </li>
        <li class="fl">
          <div>
            <a href="details/book_8.html" target="_blank">
              <img src="img/book/2008.jpg"
                alt="这是一本好书" width="168"
              >
            </a>
          </div>
          <div>
            <div class="food-box">
              <a href="details/book_8.html" target="_blank" class="food-sbox">
               	<br /> 《蔡康永的情商课》
              </a>
            </div>
            <div>
              <a href="details/book_8.html" class="fcr">抢购价 :<span class="sfzb">￥31.50</span></a>
            </div>
            <div class="jr-box">
                <div class="jrgwc font-c"><a href="addOrderServlet?goodsID=2008">加入购物车</a></div>
                <div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=2008">立即购买</a></div>
              </div>
          </div>
        </li>
				<div class="promote-title">游戏</div>
					<div class="hide" id="toolbar_yx"></div>
					<li class="fl">
						<div>
							<a href="details/ahxt2.html" target="_blank">
								<img src="img/game/3001.jpg" height="156px"
									alt="《暗黑血统2》" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/ahxt2.html" target="_blank" class="food-sbox">
									《暗黑血统2》
								</a>
							</div>
							<div>
								<a href="details/ahxt2.html" class="fcr">抢购价 :<span class="sfzb">￥188.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=3001">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=3001">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/shwj.html" target="_blank">
								<img src="img/game/3002.jpg" height="156px"
									alt="《生化危机7》" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/shwj.html" target="_blank" class="food-sbox">
									《生化危机7》
								</a>
							</div>
							<div>
								<a href="details/shwj.html" class="fcr">抢购价 :<span class="sfzb">￥188.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=3002">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=3002">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/sgjz5.html" target="_blank">
								<img src="img/game/3003.jpg" height="156px"
									alt="《上古卷轴5》" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/sgjz5.html" target="_blank" class="food-sbox">
									《上古卷轴5》
								</a>
							</div>
							<div>
								<a href="details/sgjz5.html" class="fcr">抢购价 :<span class="sfzb">￥188.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=3003">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=3003">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/ckxt.html" target="_blank">
								<img src="img/game/3004.jpg" height="156px"
									alt="《刺客信条：奥德赛》" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/ckxt.html" target="_blank" class="food-sbox">
									《刺客信条：奥德赛》
								</a>
							</div>
							<div>
								<a href="details/ckxt.html" class="fcr">抢购价 :<span class="sfzb">￥188.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=3004">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=3004">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/gmly.html" target="_blank">
								<img src="img/game/3005.jpg" height="156px"
									alt="《古墓丽影》" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/gmly.html" target="_blank" class="food-sbox">
									《古墓丽影》
								</a>
							</div>
							<div>
								<a href="details/gmly.html" class="fcr">抢购价 :<span class="sfzb">￥188.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=3005">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=3005">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/kill.html" target="_blank">
								<img src="img/game/3006.jpg" height="156px"
									alt="《绝地求生：大逃杀》" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/kill.html" target="_blank" class="food-sbox">
									《绝地求生：大逃杀》
								</a>
							</div>
							<div>
								<a href="details/kill.html" class="fcr">抢购价 :<span class="sfzb">￥188.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=3006">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=3006">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/qszl.html" target="_blank">
								<img src="img/game/3007.jpg" height="156px"
									alt="《求生之路1》" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/qszl.html" target="_blank" class="food-sbox">
									《求生之路1》
								</a>
							</div>
							<div>
								<a href="details/qszl.html" class="fcr">抢购价 :<span class="sfzb">￥188.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=3007">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=3007">立即购买</a></div>
							</div>
						</div>
					</li>
					<li class="fl">
						<div>
							<a href="details/ne.html" target="_blank">
								<img src="img/game/3008.jpg" height="156px"
									alt="《尼尔：机械纪元》" width="168"
								>
							</a>
						</div>
						<div>
							<div class="food-box">
								<br />
								<a href="details/ne.html" target="_blank" class="food-sbox">
									《尼尔：机械纪元》
								</a>
							</div>
							<div>
								<a href="details/ne.html" class="fcr">抢购价 :<span class="sfzb">￥188.00</span></a>
							</div>
							<div class="jr-box">
								<div class="jrgwc font-c"><a href="addOrderServlet?goodsID=3008">加入购物车</a></div>
								<div class="gm font-c bgcr"><a href="buyOrderServlet?goodsID=3008">立即购买</a></div>
							</div>
						</div>
					</li>
				</ul>
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

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/slick-carousel/1.8.1/slick.min.js"></script>
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