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
        <h1>명함 수정</h1>

        <form action="member.do" method="post">
            <input type="hidden" name="command" value="departeditaction">

            <label for="name">이름:</label>
            <input type="text" name="d_name" value="${depart_member.d_name}">

            <label for="task">직급:</label>
            <input type="text" name="d_task" value="${depart_member.d_task}">

            <label for="address">주소:</label>
            <input type="text" name="d_address" value="${depart_member.d_address}">

            <label for="image">이미지:</label>
            <input type="text" name="d_img" value="${depart_member.d_img}">

            <label for="readonly_field1">Num:</label>
            <input type="text" name="d_num" value="${depart_member.d_num}" readonly>

            <label for="readonly_field2">Code:</label>
            <input type="text" name="d_code" value="${depart_member.d_code}" readonly>

            <label for="readonly_field2">아이디:</label>
            <input type="text" name="userid" value="${depart_member.userid}" readonly>

            <label for="readonly_field2">날짜:</label>
            <input type="text" name="d_date" value="${depart_member.d_date}" readonly>

            <input type="submit" value="수정하기">
        </form>
    </div>
</body>
</html>
