<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.111.3">
   <meta name="_csrf" content="${_csrf.token}"/>
   <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>회원가입</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
    <link href="assets/dist/css/sign-in.css" rel="stylesheet">

    <jsp:include page="./includes/common_includes.jsp"></jsp:include>

 <%--   <script type="text/javascript" src="assets/dist/js/commonAjax.js"></script>
    <script type="text/javascript" src="assets/dist/js/member.js"></script>--%>

    <style>


        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }


        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }


    </style>



</head>
<script>

</script>
<body class="text-center">
<main class="form-signin w-100 m-auto">
    <form:form  name="join_form" action="/join" method="post" modelAttribute="memberSaveForm">
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>

        <img class="mb-4" src="assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"
             onclick="location.href='/'">
        <h1 class="h3 mb-3 fw-normal">Please join in</h1>
        <div class="form-floating">
            <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com">
            <label for="email">Email address</label><%--<button class="btn btn-light rounded-pill px-3" type="button" name="btn" id="btnEmailCheck">Duplicate check</button>--%>
            <%--<span id="id-check"></span>--%>
            <span class="text-danger"><form:errors path="email" /></span>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" name="password" id="password" placeholder="Password" autoComplete="off">
            <label for="password">Password</label>
            <span class="text-danger"><form:errors path="password" /></span>

        </div>
<%--        <div class="form-floating">
            <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="passwordConfirm" autoComplete="off">
            <label for="passwordConfirm">passwordConfirm</label>
            <form:errors path="passwordConfirm" /><br>
        </div>--%>
        <div class="form-floating">
            <input type="text" class="form-control" name="name" id="name" placeholder="name">
            <label for="name">name</label>
            <span class="text-danger"><form:errors path="name" /></span>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" name="nickname" id="nickname" placeholder="nickname">
            <label for="nickname">nickname</label>
            <%--<button class="btn btn-light rounded-pill px-3" type="button" name="btn" id="btnNicknameCheck">Duplicate check</button>--%>
            <%--<span id="nickname-check"></span>--%>
            <span class="text-danger"><form:errors path="nickname" /></span>
        </div>
        <div class="form-floating">
            <div class="form-check">
                <input id="men" name="mfCode"  value="MEN" type="radio" class="form-check-input" checked>
                <label class="form-check-label" for="men">Men</label>
            </div>
            <div class="form-check">
                <input id="female" name="mfCode" value="FEMALE" type="radio" class="form-check-input">
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" name="cellNo" id="cellNo" placeholder="cellNo">
            <label for="cellNo">cellNo</label>
            <span class="text-danger"><form:errors path="cellNo" /></span>
        </div>
        <button class="w-50 btn btn-lg btn-dark" type="button" onclick="history.back();" >이전페이지로가기</button>
        <%--<button class="w-50 btn btn-lg btn-primary" type="button" name="btn" id="btnSingUp" >Sign up</button>--%>
        <button type="submit" class="w-50 btn btn-lg btn-primary">Sign up</button>
    </form:form>
</main>



</body>
</html>
