<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/main.css"
	tppabs="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>
<body>
	<div id="global">
		<h1>书籍列表</h1>
		<a href="admin/ToAdd.action">添加书</a>
		<table>
			<tbody>
				<tr>
					<th>类别</th>
					<th>书名</th>
					<th>ISBN</th>
					<th>作者</th>
					<th>价格</th>
					<th>&nbsp;</th>
				</tr>
				<c:if test="${list.size()>0 }">
					<c:forEach items="${list}" var="book">
						<tr>
							<td>${book.b_c_name }</td>
							<td>${book.b_name }</td>
							<td>${book.b_isbn }</td>
							<td>${book.b_author }</td>
							<td>${book.b_price }</td>
							<td><a href="admin/ToEdit.action/${book.b_id}">编辑</a></td>
							<td><a href="admin/score.action/${book.b_id}">评分</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>