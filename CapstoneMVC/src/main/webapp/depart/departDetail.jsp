<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Depart Details</title>
	<link rel="stylesheet" type="text/css" href="/memberMGR/css/departBoard/departDetail.css">

</head>
<body>
    <div class="business-card">
        <h1>세부 정보</h1>
        
        <div class="profile-picture">
            <img src="path/to/profile-picture.jpg" alt="Profile Picture">
        </div>
        
        <table>
            <tr>
                <th>이름</th>
                <td>${depart_member.name}</td>
            </tr>
            <tr>
                <th>부서</th>
                <td>${depart_member.d_name}</td>
            </tr>   
            <tr>
                <th>아이디</th>
                <td>${depart_member.userid}</td>
            </tr>
            <tr>
                <th>직급</th>
                <td>${depart_member.d_task}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>${depart_member.d_address}</td>
            </tr>
            <tr>
                <th>이미지</th>
                <td>${depart_member.d_img}</td>
            </tr>
            <tr>
                <th>날짜</th>
                <td>${depart_member.d_date}</td>
            </tr>
        </table>
        
        <button onclick="location.href='member.do?command=departedit&userid=${depart_member.userid}'">명함 수정</button>
        <button onclick="location.href='member.do?command=departdel&userid=${depart_member.userid}'">명함 삭제</button>
    </div>
</body>
</html>
