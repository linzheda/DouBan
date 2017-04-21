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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑界面</title>
</head>
<body>
	<div id="global">
		<form id="books" action="admin/edit_book.action" method="post">
			<fieldset>
				<legend>书籍详情</legend>
				<p>
					<label for="cname">类别: </label> <input id="b_c_name"
						name="b_c_name" type="text" value=${book.b_c_name
						}
						readonly="true">
				</p>
				<p>
					<label for="title">书名: </label> <input id="b_name" name="b_name"
						type="text" value=${book.b_name } readonly="true"> <input
						id="b_id" name="b_id" type="hidden" value=${book.b_id} >
				</p>
				<p>
					<label for="author">作者: </label> <input id="b_author"
						name="b_author" type="text" value=${book.b_author
						}
						readonly="true">
				</p>
				<p>
					<label for="isbn">ISBN: </label> <input id="b_isbn" name="b_isbn"
						type="text" value=${book.b_isbn } readonly="true">
				</p>
				<p>
					<label for="price">价格: </label> $<input id="b_price" name="b_price"
						type="text" value=${book.b_price } readonly="true">
				</p>
				<p>
					<label for="pdfs">已上传的电子书: </label><br>
				<ul>
					<c:forEach items="${book.pdfsStringList} " var="pdfUrl">
						<li><a href="${pdfUrl}"  target="_blank">下载</a></li>
					</c:forEach>
				</ul>
				</p>



				<a href="javascript:history.go(-1)">返回上一级</a>
			</fieldset>
		</form>
	</div>

</body>
</html>