<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
	<link rel="stylesheet" type="text/css" href="/memberMGR/css/main/loginForm.css">
  <script src="script/member.js"></script>
</head>
<body>
  <div class="container">
    <h1>로그인</h1>
    <form action="member.do" method="post" name="frm">
      <input type="hidden" name="command" value="login">
      <div class="form-group">
        <label for="userid">아이디</label>
        <input type="text" name="userid" id="userid" required>
      </div>
      <div class="form-group">
        <label for="pwd">비밀번호</label>
        <input type="password" name="pwd" id="pwd" required>
      </div>
      <div class="form-group">
        <input type="submit" value="로그인" onClick="return loginCheck()">
        <input type="reset" value="취소">
        <input type="button" value="회원가입" onClick="location.href='member.do?command=joinForm'">
      </div>
      <div class="message">${message}</div>
    </form>
 </div>
 </body>
 </html>   
  
 
