<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./assets/jquery/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>chat page</title>
<style>
		*{
			margin:0; 
			padding:0;
		}
		.container{
			width: 500px;
			margin: 0 auto;
			padding: 25px
		}
		.container h1{
			text-align: left;
			padding: 5px 5px 5px 15px;
			color: #FFBB00;
			border-left: 3px solid #FFBB00;
			margin-bottom: 20px;
		}
		.chating{
			background-color: #fff;
			width: 500px;
			height: 500px;
			overflow: auto;
		}
		.chating .mychat{
			background-color: #FF4268;
			margin: 5px 1px 0 36%;
			width: 55%;
			color: #000;
			text-align: right;
			border-radius: 25px;
			padding: 3%;
		}
		.chating .otherschat{
			background-color: #A3FFEF;
			margin: 5px 36% 0 1px;
			width: 55%;
			width: 60%;
			color: #000;
			text-align: left;
			border-radius: 25px;
			padding: 3%;
		}
		input{
			width: 330px;
			height: 25px;
		}
		#yourMsg{
			display: none;
		}
	</style>
</head>
<script type="text/javascript">
	var ws;
	var username = null;

	function Open(){
		console.log('localhost');
		ws = new WebSocket('ws://'+  location.host  +'/codingvirus19/chatting');
		Event();
	}
		
	function Event() {
		ws.onopen = function(data){
			//소켓이 열리면 초기화 세팅하기
		}
		
		ws.onmessage = function(data) {
			// 메시지 받으면 동작
			var msg = data.data;
			if(msg != null && msg.trim() != ''){
				var jmsg = JSON.parse(msg);
				
				// 데이터를 JSON형태로 전달 받아서 받은 데이터를 JSON.parse메소드를 활용 하여서 파싱함
				// 또한, 이 파싱한 객체(jmsg)값이 "getId"값이면 초기 설정된 값이므로 채팅창에 추가한 태그 sessionId에 값을 세팅함.
				if(jmsg.type == "getId"){
					var sId;
					if(jmsg.peopleId != null && jmsg.peopleId != ''){
						sId = jmsg.peopleId;
					}
					if(sId != ''){
						$('#peopleid').val(sId);
					}
				}else if(jmsg.type == "message"){
					
					if(jmsg.pepleId == $('#peopleid').val()){
						$("#chating").append("<p class='mychat'>나 : " + jmsg.msg + "</p>");
						
					}else{
						$("#chating").append("<p class='otherschat'>" + jmsg.username + " : " + jmsg.msg + "</p>");
					}
					$("#chating").scrollTop($("#chating")[0].scrollHeight);
				}else{
					console.log("채팅 동작 오류");
				}
			}
		}

		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ //enter press
				send();
			}
		});
	}

	function chatName(){
		username = $("#userName").val();
		if(username == null || username.trim() == ""){
			alert("사용자 이름을 입력해주세요.");
			$("#userName").focus();
		}else{
			Open();
			$("#yourName").hide();
			$("#yourMsg").show();
		}
	}

	// 메시지를 보낼 때 type값을 message로 구분하여 발송
	function send() {
		var option ={
				type: "message",
				pepleId : $("#peopleid").val(),
				username : $("#userName").val(),
				msg : $("#chatting").val()
			}
			ws.send(JSON.stringify(option))
			$('#chatting').val("");
	}
</script>
<body>
	<div id="container" class="container">
		<h1>소켓 채팅 테스트</h1>
		<input type="hidden" id="peopleid" value=""/>
		
		<div id="chating" class="chating">
		</div>
		
		<div id="yourName">
			<table class="inputTable">
				<tr>
					<th>사용자명</th>
					<th><input type="text" name="userName" id="userName"></th>
					<th><button onclick="chatName()" id="startBtn">이름 등록</button></th>
				</tr>
			</table>
		</div>
		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>메시지</th>
					<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
					<th><button onclick="send()" id="sendBtn">보내기</button></th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>