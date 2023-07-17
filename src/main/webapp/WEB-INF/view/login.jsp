<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.111.3">
    <title>로그인</title>

    <jsp:include page="./includes/common_includes.jsp"></jsp:include>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
    <link href="assets/dist/css/sign-in.css" rel="stylesheet">




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

    <script>
        $(document).ready(function (){
            const result = '<c:out value="${result}" />';
            alert(result);
           /* checkModal(result);

            //회원
            function checkModal(result){
                console.log(result);
                if(result === '' || history.state){
                    //해당 메서드를 아예 끝내버려라.
                    return;
                }

                $(".modal-body").html(result);
                $("#myModal").modal('show');
            }*/
        });
    </script>
</head>
<body class="text-center">


<main class="form-signin w-100 m-auto">
    <form action="/login" method="post">
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
        <img class="mb-4" src="assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"
             onclick="location.href='/'">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com">
            <label for="email">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" name="password" id="password" placeholder="Password" autoComplete="off">
            <label for="password">Password</label>
        </div>

        <span>
            <c:if test="${error}">
                <p id="valid" class="alert alert-danger">${exception}</p>
            </c:if>
        </span>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" name="remember-me"> Remember me
            </label>
        </div>
        <button class="w-50 btn btn-lg btn-primary" type="submit">Sign in</button>
        <button class="w-50 btn btn-lg btn-light" type="button" onclick="location.href='/join'">Sign up</button>
    </form>


<%--    <!-- Modal  추가 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">처리가 완료되었습니다.</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Save
                        changes</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->--%>



<%--    <div class="modal-content rounded-3 shadow" id="myModal" aria-hidden="true">
        <div class="modal-body p-4 text-center">
            <p class="modal-body">처리가 완료되었습니다. </p>
        </div>
        <div class="modal-footer flex-nowrap p-0">
            <button type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 py-3 m-0 rounded-0 border-end"><strong>Yes, enable</strong></button>
            <button type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 py-3 m-0 rounded-0" data-bs-dismiss="modal">No thanks</button>
        </div>
    </div>--%>










</main>



</body>
</html>
