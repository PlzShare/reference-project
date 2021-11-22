<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html>
<head>
<title>virus19 | join</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/jquery/jquery-3.4.1.js"></script>
<script src="./assets/js/app.js"></script>
</head>
<body>
	<div id="container">
		<div id="content">
			<div id="user">
				<h1>join</h1>
				<form id="join-form" name="joinform" method="post" action="">
					<label class="block-label" for="id">ID</label>
					<input id="id" name="id" type="text" value="">
					<label class="block-label" for="password1">비밀번호</label>
					<input id="password1" name="password1" type="password" value="">
					<label class="block-label" for="password2">비밀번호 확인</label>
					<input id="password2" name="password2" type="password" value="">
					<label class="block-label" for="nickname">닉네임</label>
					<input id="nickname" name="nickname" type="text" value="">
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					<input name="send-email" type="submit" value="인증메일발송">
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female"
							checked="checked"> <label>남</label> <input type="radio"
							name="gender" value="male">
					</fieldset>
					<input type="submit" value="가입하기">
				</form>
			</div>
		</div>

	</div>
</body>
</html>