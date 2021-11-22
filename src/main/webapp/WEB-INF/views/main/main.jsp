<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html>
<head>
<title>virus19 | main</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/jquery/jquery-3.4.1.js"></script>
<script src="./assets/js/app.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>virus</h1>
			<ul>
					<li><a href="${pageContext.request.contextPath }/user/login">로그인</a></li>
					<li><a href="${pageContext.request.contextPath }/user/join">회원가입</a></li>
					<li><a href="${pageContext.request.contextPath }/user/update">회원정보수정</a></li>
					<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
			</ul>
		</div>
			<div id='search'>
				<form id='search-form' action=''>
					<input type='text' name='input-search' id='input-search' placeholder='검색어를 입력하세요'/>
					<input type='submit' value='검색'/>
				</form>
			</div>
			
			<div id='right-header'>
				<div id='header-addmemo'>
					<a href='#'>addmemo</a>
				</div>
				<div id='header-profile'>
					<a href='#'>profile</a>
				
				</div>
				<div id='header-bell'>
					<a href='#'>bell</a>
				
				</div>
			</div>
		</div>
		
		<div id='contents'>
			<div id='contents-header'>
				<div id='contents-header-title'><h3><개인1></h3></div>
				<div id='contents-header-showinglist'><a href='#'>showinglist</a></div>
				<div id='contents-header-addgroup'><a href='#'>addgroup</a></div>
				<div id='contents-header-invite'><a href='#'>invite</a></div>
			</div>
			<div id='contents-memo'></div>
			
		</div>
		
		<div id='navigation'>
		
		</div>
		
		<div id="content">

			<div id="user">
				<h1>main</h1>
				<form class=''></form>
			</div>
		</div>
	<div id="footer">
		<p>(c)opyright 2015, 2016, 2017, 2018, 2019, 2020</p>
	</div>
</body>
</html>