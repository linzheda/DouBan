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
<title>编辑界面</title>
</head>
<body>
	<div id="global">
		<form id="books" action="admin/edit_book.action" enctype="multipart/form-data" method="post">
			<fieldset>
				<legend>修改一本书</legend>
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
						type="text" value=${book.b_name}> <input id="b_id"
						name="b_id" type="hidden" value=${book.b_id}>
				</p>
				<p>
					<label for="author">作者: </label> <input id="b_author"
						name="b_author" type="text" value=${book.b_author}>
				</p>
				<p>
					<label for="isbn">ISBN: </label> <input id="b_isbn" name="b_isbn"
						type="text" value=${book.b_isbn}>
				</p>
				<p>
					<label for="price">价格: </label> $<input id="b_price" name="b_price"
						type="text" value=${book.b_price}>
				</p>
				<p>
					<label for="b_description">详情 </label> <input id="b_description" name="b_description"
						type="text">
				</p>
				
				<p>
					<label for="pdfs">已上传的电子书: </label><br>
					<ul>
						<c:forEach items="${book.pdfsStringList} " var="pdfUrl">
							<li><a href="${pdfUrl}">下载</a></li>
						</c:forEach>
					</ul>
					<div id="uploadFiles">
						重新上传电子书:<input type="file" name="pdfsUrl"/>
					</div>
					
				</p>

				<p id="buttons">
					<input id="reset" tabindex="4" type="reset"> <input
						id="submit" tabindex="5" value="修改书籍" type="submit">
				</p>
			</fieldset>
		</form>
	</div>

</body>
</html>