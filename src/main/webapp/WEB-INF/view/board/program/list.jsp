<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="../../includes/header.jsp" %>

<html>
<head>
    <title>BoardList</title>

</head>
<body>

<div class="jumbotron" style="margin-top:20px">
    <div class="container" >
        <h1 class="display-3" style="text-align: center;">프로그램 </h1>
    </div>
</div>

<!-- 게시글 리스트 -->

<div class="container" style="margin-top:40px">
    <div class="card shadow">
        <div class="card-body">
            <table class="table table-hover" id='board_list'>
                <thead class="table-light">
                <tr>
                    <th class="text-center d-none d-md-table-cell">글번호</th>
                    <th class="w-50">제목</th>
                    <th class="text-center d-none d-md-table-cell">작성자</th>
                    <th class="text-center d-none d-md-table-cell">작성날짜</th>
                </tr>
                </thead>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="5" align="center">
                                등록된 게시물이 없습니다^^*
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${list}" var="board">
                        <tbody>
                        <tr>
                            <td class="text-center d-none d-md-table-cell"> ${board.proBno}</td>
                            <td class="text-center d-none d-md-table-cell"> ${board.title}</td>
                            <td class="text-center d-none d-md-table-cell"> ${board.writer}</td>
                            <td class="text-center d-none d-md-table-cell"> ${board.regDate}</td>
                        </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>


        </div>
    </div>
</div>

<form method="get">
    <table width=100%  style="margin-top:20px">
        <tr>
            <td align="center">
                <select name="searchField" id="searchField" class="btn btn-outline-secondary">
                    <!-- option 타입으로 ▼ 클릭 시 선택 가능한 것 -->
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="searchWord" id="searchWord" class="btn btn-outline-secondary" />
                <input type="submit" value="검색하기" class="btn btn-outline-secondary" />
            </td>
        </tr>
    </table>
</form>





<%--<sec:authorize access="hasRole('ROLE_USER')">
   <h1>member board list </h1>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <h1>admin board list </h1>
    <button type="button" class="btn btn-warning" onclick="location.href='/admin/book/new'">자료추가</button>
</sec:authorize>--%>


<%@include file="../../includes/footer.jsp" %>
