<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sec:authorize access="hasRole('ROLE_USER')">
   <h1>member board list </h1>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <h1>admin board list </h1>
    <button type="button" class="btn btn-warning" onclick="location.href='/admin/book/new'">자료추가</button>
</sec:authorize>
</body>
</html>
