$(function(){
	//2.创建二维数组用于存储省份和城市
	var cities = new Array(3);
	cities[0] = new Array("东城区","西城区","崇文区","宣武区",
		"朝阳区","丰台区","石景山区","海淀区","门头沟区",
		"房山区","通州区","顺义区","昌平区","大兴区","怀柔区",
		"平谷区","密云县","延庆县");
	cities[1] = new Array("武汉市","黄冈市","襄阳市","荆州市");
	cities[2] = new Array("长沙市","郴州市","株洲市","岳阳市");
	cities[3] = new Array("石家庄市","邯郸市","廊坊市","保定市");
	cities[4] = new Array("郑州市","洛阳市","开封市","安阳市");
	cities[5] = new Array("黄浦区","卢湾区","徐汇区","长宁区",
		"静安区","普陀区","闸北区","虹口区","杨浦区","闵行区",
		"宝山区","嘉定区","浦东新区","金山区","松江区","青浦区",
		"南汇区","奉贤区","崇明县");
	cities[6] = new Array("广州市","韶关市","深圳市","珠海市",
		"汕头市","佛山市","江门市","湛江市","茂名市","肇庆市",
		"惠州市","梅州市","汕尾市","河源市","阳江市","清远市",
		"东莞市","中山市","潮州市","揭阳市","云浮市");
	cities[7] = new Array("杭州市","宁波市","温州市","嘉兴市",
		"湖州市","绍兴市","金华市","衢州市","舟山市","台州市",
		"丽水市");	
	cities[8] = new Array("和平区","河东区","河西区","南开区",
		"河北区","红桥区","塘沽区","汉沽区","大港区","东丽区",
		"西青区","津南区","北辰区","武清区","宝坻区","宁河县",
		"静海县","蓟县");
	cities[9] = new Array("万州区","涪陵区","渝中区","大渡口",
		"区江北区","沙坪坝区","九龙坡区","南岸区","北碚区",
		"万盛区","双桥区","渝北区","巴南区","黔江区","长寿区",
		"江津区","合川区","永川区","南川区","綦江县","潼南县",
		"铜梁县","大足县","荣昌县","璧山县","梁平县","城口县",
		"丰都县","垫江县","武隆县","忠县","开县","云阳县","奉节县",
		"巫山县","巫溪县","石柱土家族自治县","秀山土家族苗族自治县",
		"酉阳土家族苗族自治县","彭水苗族土家族自治县");
	// cities[10] = new Arra
	$("#province").change(function(){
		//10.清除第二个下拉列表的内容
		$("#city").empty();
		
		//1.获取用户选择的省份
		var val = this.value;
		//alert(val);
		//3.遍历二维数组中的省份
		$.each(cities,function(i,n){
			//alert(i+":"+n);
			//4.判断用户选择的省份和遍历的省份
			if(val==i){
				//5.遍历该省份下的所有城市
				$.each(cities[i], function(j,m) {
					//alert(m);
					//6.创建城市文本节点
					var textNode = document.createTextNode(m);
					//7.创建option元素节点
					var opEle = document.createElement("option");
					//8.将城市文本节点添加到option元素节点中去
					$(opEle).append(textNode);
					//9.将option元素节点追加到第二个下拉列表中去
					$(opEle).appendTo($("#city"));
				});
			}
		});
			
	});
});

function checkForm() {
	/*
	检验手机号码长度是否合法
	 */
	if( document.getElementById("c_phone").value.length>11) {
		document.getElementById("tips_phone").innerHTML = "<em style='color:#FF0000'>手机号码不能超过11位字符</em>";
		document.getElementById("c_phone").focus();
		return false;
	} else {
		document.getElementById("tips_phone").innerHTML = "√";
	}
	if( document.getElementById("c_name").value.length>11) {
		document.getElementById("tips_name").innerHTML = "<em style='color:#FF0000'>收货人姓名不能超过20位字符</em>";
		document.getElementById("c_name").focus();
		return false;
	} else {
		document.getElementById("tips_name").innerHTML = "√";
	}
}