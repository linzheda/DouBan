<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>评分</title>
</head>
<body>
	<form action="../score_book.action" style="margin-left:500px;margin-top:100px;">
		书籍的ID：<input type="text" readonly="true"  onfocus="this.blur();" name="b_id" value="${book.b_id }" ><br><br>
		书籍名称：<input type="text" readonly="true"  onfocus="this.blur();" name="b_name" value="${book.b_name }" ><br><br>
		书籍类别：<input type="text" readonly="true"  onfocus="this.blur();" name="b_c_name" value="${book.b_c_name}" ><br><br>
		输入评分：<input type="text" ><br><br>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="提交">
	</form>



</body>
</html>