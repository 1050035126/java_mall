<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script language="javascript" src="js/login/code.js"></script>


<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
<style type="text/css">
body {
	background-image: url("image/login/bg.png");
	background-size: cover;
	align: center;
}

.inputText {
	width: 20px;
}
a{font-size:14px;color:gray}
</style>

</head>

<body onload="createCode();">
	<div align=center>
		<div
			style="-webkit-border-radius: 10px; border-radius: 10px; background-color: white; width: 400px; height: 350px; margin-top: 100px; margin-top: 100px; margin-left: 530px;">

			<p style="font-size: 25px; padding-top: 30px;">登录</p>

			<%
			  /*
			  	通过表单传出user对象
			  */
			%>
			<div>
				<form id="loginform" action="LoginAction" method="post" class="input-group">


					<p style="padding-top: 10px;">
						<input
							style="-webkit-border-radius: 10px; border-radius: 5px; width: 250px; height: 40px;"
							name="username" type="text" class="form-control "
							placeholder="用户名" />
					</p>
					<p style="padding-top: 40px;">
						<input
							style="-webkit-border-radius: 10px; border-radius: 5px; width: 250px; height: 40px;"
							class="form-control " type="password" name="password"
							placeholder="密码" />
					</p>
					<p style="padding-top: 40px;">
						<input class="form-control "
							style="-webkit-border-radius: 10px; border-radius: 5px; width: 100px; height: 40px;"
							type="text" id="input1" placeholder="验证码" /> <input type="text"
							id="checkCode" class="form-control"
							style="-webkit-border-radius: 10px; border-radius: 5px; width: 65px; height: 40px; margin-left: 10px; color: red;" />
					<div><a href="#" onclick="createCode()">看不清楚?</a></div>
					
			</div>
			</p>
			<p style="padding-top: 10px;">
				<button type="button" onclick="validate();" name="login"
					class="btn btn-success" style="width: 250px; height: 40px;">登录</button>

			</p>


			</form>
			<p style="color: gray; margin-left: 170px; margin-top: 20px;font-size:10px">
				<br> <a href="enroll.jsp">忘了密码?</a> | <a href="enroll3.jsp">
					注册新账号 </a> | <a href="enroll3.jsp">
					意见反馈 </a>
			</p>
		</div>

	</div>



	</div>
	<div></div>
</body>
</html>