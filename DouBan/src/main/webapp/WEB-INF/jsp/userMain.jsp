<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/main.css"
	tppabs="css/main.css">
<script src="js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>
<body>
	<div id="global">
		<h2>豆瓣书屋</h2>
		<h1>书籍列表</h1>
		<select id="category">
			<option value="-1" onclick="byType(this)">所有类别</option>
			<c:if test="${categoryList.size()>0 }">
				<c:forEach items="${categoryList}" var="category">
					<option value="${category.c_id}" onclick="byType(this)">${category.c_name}</option>
				</c:forEach>
			</c:if>
		</select>

		<table>
			
				<tr>
					<th>类别</th>
					<th>书名</th>
					<th>ISBN</th>
					<th>作者</th>
					<th>价格</th>
					<th>&nbsp;</th>
				</tr>
				<tbody id='bookList'>
				<c:if test="${list.size()>0 }">
					<c:forEach items="${list}" var="book">
						<tr>
							<td>${book.b_c_name }</td>
							<td>${book.b_name }</td>
							<td>${book.b_isbn }</td>
							<td>${book.b_author }</td>
							<td>${book.b_price }</td>
							<td><a href="toDetailBook.action/${book.b_id }">查看详情</a></td>
							<td><a href="">评分</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<script>
		function byType(cid) {
			$.ajax({
				url : "findBookByType.action",
				data : "cid=" + cid.value,
				type : "POST",
				dataType : "JSON",
				success : function(data) {
					$("#bookList").html("");
					for(var i=0;i<data.length;i++){
						$("#bookList").append("<tr><td>"+data[i].b_c_name+"</td>"
								+"<td>"+data[i].b_name+"</td>"
								+"<td>"+data[i].b_isbn+"</td>"
								+"<td>"+data[i].b_author+"</td>"
								+"<td>"+data[i].b_price+"</td>"
								+"<td><a href='toDetailBook.action/"+data[i].b_id+"'>查看详情</a></td>"
								+"<td><a href='#'>评分</a></td></tr>");
					}
					
				}
			});

		}
	</script>
</body>

</html>