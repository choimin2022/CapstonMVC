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
        <c:forEach var="board" items="${boardList}" varStatus="status">
            <div class="card">
                <h3>${board.b_title}</h3>
                <div class="card-text">
                    <p><strong>작성자:</strong> ${board.u_name}</p>
                    <p><strong>내용:</strong> ${board.b_content}</p>
                    <p><strong>날짜:</strong> ${board.b_date}</p>
					<p><strong>좋아요:</strong> ${board.b_like}</p>
			        <c:choose>
			            <c:when test="${board.b_check}">
			                <i class="fa-heart" style="color: red;"></i>
			            </c:when>
			            <c:otherwise>
			                <i class="fa-heart"></i>
			            </c:otherwise>
			        </c:choose>
                </div>
                <button onclick="location.href='boardView.do?b_num=${board.b_num}'">상세 정보</button>
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
