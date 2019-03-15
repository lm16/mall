
$(function(){

	
	

	//注册区
	
	var $username = $('#username');
	var $tel = $('#tel');
	var $password = $('#password');
	var $email = $('#email');
	
	var $ispassword = $('#ispwd');

	var bstop = [false,false,false,false,false];//定义开关数组
	var $oinput = $('.isV');


	//定义正则数组
	var regs = [/^[a-z0-9\_-]{5,10}$/,/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,/^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$/,/^[a-z0-9_-]{6,18}$/];
	
	//输入框获取焦点时显示提示
	$oinput.on('focus',function(){
		$(this).next('span').css('display','block');
	});
	$oinput.on('blur',function(){
		$(this).next('span').css('display','none');
		
	});
	$username.on('focus',function(){
		$('#error1').css('display', 'none');
	});
	$username.on('blur',function(){
		if($username.val()==null || $username.val()=='')
			$('#error1').css('display', 'block');
	})
	$password.on('focus', function(){
		$('#error4').css('display', 'none');
	});
	$password.on('blur', function(){
		if($password.val()==null || $password.val()=='')
			$('#error4').css('display', 'block');
	});
	$ispassword.on('focus', function(){
		$('#error5').css('display', 'none');
	});
	$ispassword.on('blur', function(){
		if($ispassword.val()!=$password.val())
			$('#error5').css('display', 'block');
	});
	$tel.on('focus', function(){
		$('#error3').css('display', 'none');
	});
	$tel.on('blur', function(){
		if($tel.val().length!=11)
			$('#error3').css('display', 'block');
	});
	$email.on('focus', function(){
		$('#error2').css('display', 'none');
	});
	$email.on('blur', function(){
		 if ($email.val() == '' || (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test($email.val()) == false)){
			 $('#error2').css('display', 'block');
         }
	});


	//提交表单时
	var $sub = $('#mysubmit');
	$sub.on('click', function(){

        $.ajax({
            url: "register.do",
            type: "POST",

            data: JSON.stringify({"customerName":$username.val(), "customerPass":$password.val(), "customerPhone": $tel.val(), "customerEmail":$email.val()}),
            contentType : "application/json;charset=UTF-8",

            success: function(data) {
                if (data == "success") {
                    alert("注册成功");
                    window.location.href = 'shop.jsp';
                } else {
                    alert('注册失败，账号重复');
                }
            }
        });

	});
});
    
