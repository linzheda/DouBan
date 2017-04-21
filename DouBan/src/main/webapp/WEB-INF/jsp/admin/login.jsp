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
<meta charset="utf-8">
<title>登入界面</title>
<meta name="author" content="DeathGhost">
<link rel="stylesheet" type="text/css" href="css/style.css"
	tppabs="css/style.css">
<style>
body {
	height: 100%;
	background: #16a085;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js"
	tppabs="js/verificationNumbers.js"></script>
<script src="js/Particleground.js" tppabs="js/Particleground.js"></script>
<script>
	$(document)
			.ready(
					function() {
						//粒子背景特效
						$('body').particleground({
							dotColor : '#5cbdaa',
							lineColor : '#5cbdaa'
						});
						//验证码
						createCode();
						//测试提交，对接程序删除即可
						$(".submit_btn")
								.click(
										function() {
											var a = validate();
											if (a == false) {
												alert("验证码错误");
												return;
											}
											window.location.href = "admin/adminLogin.action?uname="
													+ $("#uname").val()
													+ "&password="
													+ $("#password").val();
										});
					});
</script>
</head>
<body>
	<c:if test="${errmsg eq ''}">
		<script>
			alert("${errmsg}");
		</script>
	</c:if>

	<dl class="admin_login">
		<dt>
			<strong>站点后台管理系统</strong> <em>Management System</em>
		</dt>

		
			<dd class="user_icon">
				<input type="text" placeholder="账号" name="uname" id="uname"
					class="login_txtbx">
			</dd>
			<dd class="pwd_icon">
				<input type="password" placeholder="密码" name="password"
					id="password" class="login_txtbx">
			</dd>
			<dd class="val_icon">
				<div class="checkcode">
					<input type="text" id="J_codetext" placeholder="验证码" maxlength="4"
						class="login_txtbx">
					<canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
				</div>
				<input type="button" value="验证码核验" class="ver_btn"
					onclick="validate();">
			</dd>
			<dd>
				<input type="button" value="立即登陆" class="submit_btn">
			</dd>
		
		<dd>
			<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗.
				不支持IE8及以下浏览器。</p>
			<p>
				来源：<a title="html5实例,css3实例,jquery实例" href="#" target="_blank">html5实例,css3实例,jquery实例</a>
			</p>
		</dd>
	</dl>
</body>
</html>
