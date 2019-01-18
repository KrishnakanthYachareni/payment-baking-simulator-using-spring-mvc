<%--
  ~ Copyright (c) 2019 Mastercard. All rights reserved.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: e082952
  Date: 14-01-2019
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <tf:htmlHead title="KB Bank:Home"/>
</head>
<body>
<%--<h1>Welcome to KR Bank Application home page</h1>
<a href="${pageContext.request.contextPath}/bankapp/new">Create New Account</a>--%>
<div class="container">
    <%@include file="header.jsp" %>

    <div class="row">
        <div class="col-xl-12 col-lg-12 col-sm-12 col-12">
            <div class="jumbotron">
                <h1 class="display-4">Welcome to KR Bank</h1>
                <p class="lead">
                    Happiness = A Good Bank Account, A Good Cook and a Good Digestion - Krishnakanth
                </p>
                <a href="${pageContext.request.contextPath}/bankapp/new" class="btn btn-lg btn-success">Register
                    Here</a>
                <p><br/>Existing Users : <a href="${pageContext.request.contextPath}/user/login">Login Here</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
            <div class="card" style="height: 200px">
                <div class="card-header">Online</div>
                <img src="<spring:url value='${pageContext.request.contextPath}/static/style/images/card1.png' />"
                     class="card-img-top" alt="Online"/>
                <div class="card-body">
                    <p class="card-text">200+ Transactions via NetBanking</p>
                </div>
            </div>
        </div>

        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
            <div class="card" style="height: 200px">
                <div class="card-header">Online</div>
                <img src="<spring:url value='${pageContext.request.contextPath}/static/style/images/card2.png' />"
                     class="card-img-top" alt="Online"/>
                <div class="card-body">
                    <p class="card-text">200+ Transactions via NetBanking</p>
                </div>
            </div>
        </div>

        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
            <div class="card" style="height: 200px">
                <div class="card-header">Online</div>
                <img src="<spring:url value='${pageContext.request.contextPath}/static/style/images/card3.png' />"
                     class="card-img-top" alt="Online"/>
                <div class="card-body">
                    <p class="card-text">200+ Transactions via NetBanking</p>
                </div>
            </div>
        </div>

        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
            <div class="card" style="height: 200px">
                <div class="card-header">Online</div>
                <img src="<spring:url value='${pageContext.request.contextPath}/static/style/images/card4.png' />"
                     class="card-img-top" alt="Online"/>
                <div class="card-body">
                    <p class="card-text">200+ Transactions via NetBanking</p>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
