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
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>添加书籍</title>

</head>
<body>

	<div id="global">
		<form id="book" action="admin/add_book.action" enctype="multipart/form-data" method="post">
			<fieldset>
				<legend>添加一本书</legend>
				<p>
					<label for="category">类别: </label> <select id="b_c_id"
						name="b_c_id">
						
						<c:if test="${categoryList.size()>0 }">
							<c:forEach items="${categoryList}" var="category">
								<option value="${category.c_id}">${category.c_name}</option>

							</c:forEach>
						</c:if>
						
						
					</select>
				</p>
				<p>
					<label for="title">书名: </label> <input id="b_name" name="b_name"
						type="text">
				</p>
				<p>
					<label for="author">作者: </label> <input id="b_author" name="b_author"
						type="text">
				</p>
				<p>
					<label for="isbn">ISBN: </label> <input id="b_isbn" name="b_isbn"
						type="text">
				</p>
				<p>
					<label for="price">价格: </label> $<input id="b_price" name="b_price"
						type="text">
				</p>
				<p>
					<label for="b_description">详情 </label> <input id="b_description" name="b_description"
						type="text">
				</p>
				<p>
					<label for="pdfs">电子书: </label> 
					<div id="">
						<input type="file" name="pdfsUrl">
					</div>
				</p>
				<p id="buttons">
					<input id="reset" tabindex="4" type="reset"> <input
						id="submit" tabindex="5" value="添加书籍" type="submit">
				</p>
			</fieldset>
		</form>
	</div>

</body>
</html>