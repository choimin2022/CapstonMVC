<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Depart Edit</title>
	<link rel="stylesheet" type="text/css" href="/memberMGR/css/departBoard/departEdit.css">
</head>
<body>
    <div class="edit-form">
        <h1>게시글 수정</h1>

        <form action="board.do" method="post">
            <input type="hidden" name="command" value="updateboardaction">
            <input type="hidden" name="b_num" value="${board.b_num}">

            <label for="b_title">제목:</label>
            <input type="text" name="b_title" value="${board.b_title}">

            <label for="b_content">내용:</label>
            <textarea name="b_content">${board.b_content}</textarea>

            <input type="submit" value="수정하기">
        </form>
    </div>
</body>
</html>
