<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function createXmlHttpRequest(){

	
	
	
}


</script>
</head>
<body>
	<select id="s1_text1_bold">
		<option value="1">发表人</option>
		<option value="2" >标题</option>
		<option value="3" selected="selected">内容</option>
		<option value="4">时间</option>
	</select>
	<input type="text" /><button>搜索</button>



	<div id="deleteCheckDiv"></div>
	<a href="GetAction?webAddress=manager_message">获得留言</a>
	<table>
		<tr>
			<td>编号</td>
			<td>标题</td>
			<td>内容</td>
			<td>时间</td>
			<td>发表人</td>
			<td>管理</td>
		</tr>

		<script type="text/javascript">
			$(document).ready(function() {

				$("#deleteCheckDiv").hide();
				$("#delete").click(function() {

					$("#loginDiv").fadeIn();
					$("#yinying").fadeIn();
					showUnitInfo();
				});

			});
		</script>
		<c:forEach var="list" items="${messagelist}">
			<tr>
				<td>${list.id}</td>
				<td>${list.title}</td>
				<td>${list.content}</td>
				<td>${list.time}</td>
				<td>${list.username}</td>
				<td><a href="deleteMessageAction?id=${list.id}"><button
							id="delete">删除</button></a></td>

			</tr>
		</c:forEach>
	</table>
	<div class="clear" style="padding-left: 490px;">
		<a href="Page_messageAction?currentPage=1&webAddress=manager_message"><button
				type="button" class="btn btn-success">首页</button> </a> <a
			href="Page_messageAction?currentPage=${page.currentPage-1}&webAddress=manager_message"><button
				type="button" class="btn btn-success">上一页</button> </a> <a
			href="Page_messageAction?currentPage=${page.currentPage+1}&webAddress=manager_message"><button
				type="button" class="btn btn-success">下一页</button> </a> <a
			href="Page_messageAction?currentPage=${page.pageCount}&webAddress=manager_message"><button
				type="button" class="btn btn-success">尾页</button> </a>
		<button type="button" class="btn " disabled="disabled">
			第${page.currentPage}页/共${page.pageCount}页</button>
	</div>

</body>
</html>