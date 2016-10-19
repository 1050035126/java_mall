<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#b").click(function() {
				$.ajax({
					type : "POST", //提交方式  
					url : "UploadAction",//路径  
					data : {
						"name" : "张鹏鹏"
					},//数据，这里使用的是Json格式进行传输  
					dataType : "json",
					success : function(result) {//返回数据根据结果进行相应的处理  
						$("#s").val("213");
						alert(result.name);
					},
					error : function(result) {//返回数据根据结果进行相应的处理  

						alert('1');
					}
				});
			});
		})
	</script>
	<button id="b">qwe</button>
	<input id="s">

</body>
</html>