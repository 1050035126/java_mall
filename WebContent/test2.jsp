<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<title>jQuery点击弹出确认或取消删除特效 - 站长素材</title>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body, html {
	font-family: "微软雅黑";
}

.demo1 {
	width: 1000px;
	margin: 100px auto 50px;
}

.demo1 ul {
	overflow: hidden;
}

.demo1 ul li {
	float: left;
	padding: 10px 20px;
	font-size: 18px;
	color: #fff;
	background-color: #000;
	border-radius: 3px;
	margin-right: 20px;
	cursor: pointer;
}

.pop {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.8);
}

.pop .popMain {
	width: 600px;
	min-height: 300px;
	background: #fff;
	position: absolute;
	left: 50%;
	top: 30%;
	margin-left: -300px;
}

.popMiddle p {
	text-align: center;
	font-size: 18px;
	color: #666;
	padding: 90px 0;
}

.pop .popBottom {
	position: absolute;
	bottom: 0;
	left: 0;
	display: flex;
	width: 100%;
	height: 80px;
	text-align: center;
	background: #488ACC;
}

.pop .popBottom span {
	flex: 1;
	text-align: center;
	font-size: 24px;
	color: #fff;
	line-height: 80px;
	cursor: pointer;
}

.pop .popBottom span:first-of-type {
	border-right: 1px solid #fff;
}
</style>
</head>
<body>


	<table>
		<tr>
			<td>编号</td>
			<td>用户名</td>
			<td>昵称</td>
			<td>权限</td>
			<td>注册时间</td>
			<td>管理</td>
		</tr>
		<c:forEach var="list" items="${userlist}">
			<tr>
				<td>${list.id}</td>
				<td>${list.username}</td>
				<td>${list.nickname}</td>
				<td>${list.authority}</td>
				<td>${list.time}</td>
				<td><a href="deleteUserAction?id=${list.id}"><button
							id="deleteButton">封禁</button></a></td>
				<c:if test="${list.authority=='user'}">
					<td><a
						href="changeAuthorityAction?id=${list.id}&authority=${list.authority}"><button>设置管理员</button></a></td>
				</c:if>
				<c:if test="${list.authority=='admin'}">
					<td><a
						href="changeAuthorityAction?id=${list.id}&authority=${list.authority}"><button>取消管理员权限</button></a></td>
				</c:if>

			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
	$(document).ready(function() {
			$("#deleteButton").click(function() {
				$(".pop").fadeIn();
			});
	});

	</script>


	<div class="demo1">
		<ul>
			<li>1（点击删除）</li>
			<li>2（点击删除）</li>
			<li>3（点击删除）</li>
			<li>4（点击删除）</li>
			<li>5（点击删除）</li>
		</ul>
	</div>
	<div class="pop">
		<div class="popMain">
			<div class="popTop"></div>
			<div class="popMiddle">
				<p>是否确认删除？</p>
			</div>
			<div class="popBottom">
				<span class="confirm">确认</span> <span class="cancel">取消</span>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			(function() {
				var num;
				$(".demo1").on('click', 'ul li', function(event) {
					event.preventDefault();
					num = $(this).index();
					$(".pop").fadeIn('fast');
				});
				$(".popBottom").on('click', 'span', function(event) {
					event.preventDefault();
					if ($(this).hasClass('confirm')) {
						$(".demo1 ul li").eq(num).remove();
						num = "";
						$(".pop").fadeOut();
					} else {
						$(".pop").fadeOut();
						num = "";
					}
				});
			})();

		});
	</script>

</body>
</html>
