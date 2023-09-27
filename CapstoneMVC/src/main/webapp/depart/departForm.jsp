<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Become a Member</title>
	<link rel="stylesheet" type="text/css" href="/memberMGR/css/departBoard/departForm.css">
</head>
<body>
	<div class="container">
		<div class="form-container">
			<h2>명함 등록</h2>
			<p>'*' 표시 항목은 필수 입력 항목입니다.</p>
			<form action="member.do" method="post" name="businesscard">
				<input type="hidden" name="command" value="departaction">
				<table>
					<tr>
						<td>코드</td>
						<td><input name="d_code" type="text"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${loginUser.name}</td>
					</tr>
					<tr>
						<td>부서</td>
						<td><input name="d_name" type="text"></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td>${loginUser.userid}</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${loginUser.email}</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td>${loginUser.phone}</td>
					</tr>
					<tr>
						<td>직급</td>
						<td><input name="d_task" type="text"></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input name="d_address" type="text"></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input type="text" name="d_img"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="명함 등록">
							<input type="reset" value="취소">
							<input type="button" value="메인" onClick="location.href='member.do?command=main'">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
