<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- jstl-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jquery -->
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/message/write.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<!--整体的div  -->
	<div id="mostDiv"
		style="height: 1000px; width: 1000px; border-color: red;">
		<div style="margin-left: 500px;">
			<!-- 登录 -->
			<c:if test="${nickname==null}">
				<div style="margin-left: 90%;">
					<button id="loginButton">登录</button>
					<a href="enroll3.jsp"><button id="enrollButton">注册</button> </a>
				</div>
			</c:if>
			<c:if test="${nickname!=null}">
				<b>欢迎你 .${nickname}</b>
				<a href="CancelAction"><button>退出登录</button></a>
				<c:if test="${authority=='admin'}">
					<a href="ManagerAction"><button>后台管理</button></a>
				</c:if>
			</c:if>
		</div>



		<!-- 网站名称 -->
		<div style="margin-left: 40%;">
			<h1>名称</h1>
		</div>

		<!-- 导航条 -->
		<div style="border: 1px solid; width: 100%; height: 50px;">
			<div style="float: left; border: 1px solid;">导航1</div>
			<div style="float: left;">导航2</div>
			<div style="float: left;">导航3</div>
			<div style="float: left;">导航4</div>
			<div style="float: left;">
				<input />
				<button>搜索</button>
			</div>
		</div>

		<!--  内容 -->
		<div style="clear: both; height: 700px; border: 1px solid;">
			<!--内容 左  -->
			<div style="float: left; border: 1px solid; width: 80%; height: 70%;">
				<c:forEach var="list" items="${messagelist}">
					<div style="clear: both;">
						<div style="float: left;">
							<div>${list.id}</div>
						</div>
						<div style="float: left;">



							<div>
								<a href="#">${list.title} </a> <br> ${list.content}<br>
								<c:if test="${list.image!=null}">
									<img alt="" src="image/content/${list.id}.jpg"
										style="height: 50px; width: 50px;">
								</c:if>
							</div>
						</div>
						<div style="float: left;">
							<div>${list.username}</div>
						</div>
						<div style="">
							<div>${list.time}</div>
						</div>
						<!--删除  -->
						<c:if test="${nickname!=null}">
							<c:if test="${nickname==list.username}">
								<button>楼主删除</button>
							</c:if>
						</c:if>
						<!-- 管理员删除 -->
						<c:if test="${authority=='admin'}">
							<button>管理员删除</button>
						</c:if>
					</div>
				</c:forEach>

				<script type="text/javascript">
					$(document).ready(function() {

						$("#loginDiv").hide();
						$("#loginButton").click(function() {
							$("#loginDiv").fadeIn();
							$("#yinying").fadeIn();
							showUnitInfo();
						});

						$("#login").click(function() {
							var username = $("#loginUsername").val();
							var password = $("#loginPassword").val();
							if (username == null || password == null) {
								alert("请输入用户名或密码！");
							} else {
								$("#loginForm").submit();
							}
						});

					});
				</script>
				<div id="loginDiv"
					style="position: absolute; background-color: red; margin-left: 200px;">
					<form id="loginForm" action="LoginAction" method="post">
						用户名: <input id="loginUsername" name="username" /> <br /> 密码: <input
							id="loginPassword" name="password" /> <br />
						<button id="login" type="button">登录</button>
					</form>

					<a href="enroll3.jsp"><button>注册</button></a>
				</div>

			</div>
			<!--内容 右  -->
			<div style="">
				2
				<script type="text/javascript">
					$(document).ready(function() {
						$("#upload").click(function() {
							alert($("#inputFile").val());

						});

					});
				</script>

			</div>
		</div>
		<div>
			<c:if test="${1==1}">
				<div class="clear" style="padding-left: 490px;">
					<a href="Page_messageAction?currentPage=1"><button
							type="button" class="btn btn-success">首页</button> </a> <a
						href="Page_messageAction?currentPage=${page.currentPage-1}"><button
							type="button" class="btn btn-success">上一页</button> </a> <a
						href="Page_messageAction?currentPage=${page.currentPage+1}"><button
							type="button" class="btn btn-success">下一页</button> </a> <a
						href="Page_messageAction?currentPage=${page.pageCount}"><button
							type="button" class="btn btn-success">尾页</button> </a>
					<button type="button" class="btn " disabled="disabled">
						第${page.currentPage}页/共${page.pageCount}页</button>
				</div>
			</c:if>
		</div>

		<!-- 新的话题 -->
		<div>
			<div>发表新话题</div>

			<form id="WriteForm" action="WriteAction" method="post"
				enctype="multipart/form-data">
				<p>
					<input id="inputTitle" name="title" placeholder="话题" /> <span
						class="state1">请输入标题</span>
				</p>
				<p>
					<input id="inputContent" name="content" placeholder="内容" />
				</p>
				<p>
					<input name="nickname" value="${nickname}" type="hidden" />
				</p>
				<p>
					<input name="image" type="file" />
				</p>
				<p>
					<!-- 下面的button的submit用class是因为js -->
					<button class="submit">发表</button>
					<a href="http://www.baidu.com" target="_blank">百度一下(新建窗口)</a>
				</p>
			</form>
		</div>


	</div>

</body>
</html>