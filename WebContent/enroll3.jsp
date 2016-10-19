<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>

<link rel="stylesheet" href="css/enroll/style.css">

<script type="text/javascript" src="js/enroll/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/enroll/easyform.js"></script>


</head>
<body>
	<br>
	<!-- 代码 开始 -->
	<div class="form-div">
		<form id="reg-form" action="EnrollAction.action" method="post">

			<table>
				<tr>
					<td>昵称</td>
					<td><input name="user.nickname" type="text" id="nickname"
						easyform="length:2-16;char-chinese;" message="昵称必须为2—16位的中文"
						easytip="disappear:lost-focus;theme:blue;"></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input name="user.username" type="text" id="uid"
						easyform="length:4-16;char-normal;real-time;"
						message="用户名必须为4—16位的英文字母或数字"
						easytip="disappear:lost-focus;theme:blue;" ajax-message="用户名已存在!">
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input name="user.password" type="password" id="psw1"
						easyform="length:6-16;" message="密码必须为6—16位"
						easytip="disappear:lost-focus;theme:blue;"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input  type="password" id="psw2"
						easyform="length:6-16;equal:#psw1;" message="两次密码输入要一致"
						easytip="disappear:lost-focus;theme:blue;"></td>
				</tr>
				<tr>
					<td>QQ</td>
					<td><input name="user.QQ" id="qq" type="text"
						easyform="length:6-16;" message="qq必须为6—10位"
						easytip="disappear:lost-focus;theme:blue;"></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input name="user.phoneNumber" type="text" id="phonenumber"
						easyform="length:11;" message="手机号码必须为11位"
						easytip="disappear:lost-focus;theme:blue;"></td>
				</tr>

			</table>

			<div class="buttons">
				<input value="注 册" type="submit" onclick="validate();"
					style="margin-right: 20px; margin-top: 20px;"> 
					<a href="login.jsp">
					<input
					value="我有账号，我要登录" type="button"
					style="margin-right: 45px; margin-top: 20px;">
					</a>
			</div>

			<br class="clear">
		</form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#reg-form').easyform();
		});
	</script>
	<!-- 代码 结束 -->

	

</body>
</html>
