# 기능정의

## 로그인(id, password)/(동은)/(예은) 1 
 1. ID(email 로그인 가능)
 2. password
 3. 로그인 버튼, 회원가입 버튼
 4. 구글 로그인 api 적용 

## 회원가입/(예은) 1
 1. (id, password, email, nickname) 구성 
 2. id: 중복확인
 3. nicname: 중복확인
 3. password 특수문자 포함 여부 확인 및 동일성 체크
 4. email 이메일 중복확인
 5. 가입하기 버튼

## MainPage

### Editor 1
 1. Socket 통신을 이용하여 실시간으로 동시 편집 기능 구현 (Sync맞추기)
  
### Chat 3
 1. Socket 통신을 이용하여 1:n 채팅 구현
 
### POST Board
 1. Editor를 이용하여 저장되어진 데이터를 포스트 게시판 형태로 나타낸다
 
### Storege
 1. 디렉토리 형태로 메모를 불러와 분류 할수있게 한다.
 
## Header
 ### 알람
 ### 사용자
  1. 사용자 이미지ssss
  	1-1. 클릭시 메뉴가 생성됨
  	1-2. 내정보
  	1-3. 로그아웃 	 
 ## Navigation
 

1. 공유에디터 저장시 md형식으로 저장(Editor 준용)
2. 에디터 실시간 공유(준용)
3. 포스트(Like Facebook List)페이지 제작 (상훈)
4. 파일IO(사진저장), OCR기능으로 사진 Text를 표현 (css 상훈)
5. 보관처리 - 계정별 디렉토리 단위로 저장 (준용)
6. 사용자 표시 - 에디터나 파일 등 변경사항 알림기능(상훈)
7. SNS와 같이 팔로우 and 초대기능(이메일링크) 구현 - 암호화(*)


## logback 설정 변경
 - 0513 로그백 설정 변경