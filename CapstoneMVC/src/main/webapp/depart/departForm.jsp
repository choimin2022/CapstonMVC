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
						<td>제목</td>
						<td><input name="b_title" type="text" required></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="b_content" rows="10" cols="50" required></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="게시판 등록">
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
