<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Depart Board</title>
   <link rel="stylesheet" type="text/css" href="/memberMGR/css/departBoard/Board.css">
</head>
<body>
    <div class="container">
        <c:forEach var="depart_member" items="${memberList}" varStatus="status">
            <div class="card">
                <h3>${depart_member.d_name}</h3>
                <div class="card-text">
                    <p><strong>직급:</strong> ${depart_member.d_task}</p>
                    <p><strong>이름:</strong> ${depart_member.name}</p>
                    <p><strong>이미지:</strong> ${depart_member.d_img}</p>
                    <p><strong>날짜:</strong> ${depart_member.d_date}</p>
                </div>
                <button onclick="location.href='member.do?command=departdetail&userid=${depart_member.userid}'">상세 정보</button>
            </div>
        </c:forEach>
    </div>
    <div class="pagination">
        <c:choose>
            <c:when test="${pageInfo.maxPage > 1}">
                <c:if test="${pageInfo.startPage > 0 and pageInfo.page != 1}">
                    <a href="?command=departlistaction&page=1">처음</a>
                    <a href="?command=departlistaction&page=${pageInfo.page - 1}">이전</a>
                </c:if>
                <c:forEach var="pageNum" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
                    <c:if test="${pageNum == pageInfo.page}">
                        <a class="current-page" href="?command=departlistaction&page=${pageNum}">${pageNum}</a>
                    </c:if>
                    <c:if test="${pageNum != pageInfo.page}">
                        <a href="?command=departlistaction&page=${pageNum}">${pageNum}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${pageInfo.endPage <= pageInfo.maxPage and pageInfo.page != pageInfo.maxPage}">
                    <a href="?command=departlistaction&page=${pageInfo.page + 1}">다음</a>
                    <a href="?command=departlistaction&page=${pageInfo.maxPage}">마지막</a>
                </c:if>
            </c:when>
        </c:choose>
    </div>
</body>
</html>
