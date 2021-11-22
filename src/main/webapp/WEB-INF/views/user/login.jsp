<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html>
<head>
<title>virus19 | login</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script type="text/javascript" src="./assets/jquery/jquery-3.4.1.js"></script>
<script src="./assets/js/app.js"></script>
</head>
<body>
	<div id="container">
		<div id="content">
			<div id="user">
				<h1>login</h1>
				<form id="login-form" name="loginform" method="post" action="">
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					<label class="block-label" >패스워드</label>
					<input name="password" type="password" value="">
					<input type="submit" value="로그인">
				</form>
				<button>회원가입</button>
				
			</div>
		</div>
	</div>
</body>
</html>