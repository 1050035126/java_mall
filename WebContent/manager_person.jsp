<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			<td><a href="deleteUserAction?id=${list.id}"><button>封禁</button></a></td>
			<c:if test="${list.authority=='user'}">
				<td><a href="changeAuthorityAction?id=${list.id}&authority=${list.authority}"><button>设置管理员</button></a></td>
			</c:if>
			<c:if test="${list.authority=='admin'}">
				<td><a href="changeAuthorityAction?id=${list.id}&authority=${list.authority}"><button>取消管理员权限</button></a></td>
			</c:if>
			
		</tr>
		</c:forEach>
	</table>

</body>
</html>