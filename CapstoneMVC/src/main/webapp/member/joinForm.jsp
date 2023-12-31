<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Join Form</title>

	<link rel="stylesheet" type="text/css" href="/CapstoneMVC/css/main/joinForm.css">

  <script src="script/member.js"></script>
</head>
<body>
  <div class="container">
    <div class="form-container">
      <h2>회원가입</h2>
      <p>'*' 표시 항목은 필수 입력 항목입니다.</p>
      <form action="member.do" method="post" name="frm">
        <input type="hidden" name="command" value="join">
        <table>
          <tr>
            <td>이름</td>
            <td><input type="text" name="name" size="20"> *</td>
          </tr>
          <tr>
            <td>아이디</td>
            <td>
              <input type="text" name="userid" size="20"> *
              <input type="button" value="중복 체크" onClick="idCheck();">
              <input type="hidden" name="reid" value="">
            </td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pwd" size="20"> *</td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
            <td><input type="password" name="pwd_check" size="20"> *</td>
          </tr>
          <tr>
            <td>이메일</td>
            <td><input type="text" name="email" size="20"></td>
          </tr>
          <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" size="20"></td>
          </tr>
          <tr>
            <td>등급</td>
            <td>
              <input type="radio" name="admin" value="0" checked="checked">일반회원
              <input type="radio" name="admin" value="1">관리자
            </td>
          </tr>
          <tr>
            <td colspan="2" align="center">
              <input type="submit" value="회원가입" onclick="return joinCheck()">
              <input type="reset" value="취소">
            </td>
          </tr>
        </table>
      </form>
    </div>
  </div>
</body>
</html>
