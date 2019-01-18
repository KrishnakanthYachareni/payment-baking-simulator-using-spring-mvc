<%--
  ~ Copyright (c) 2019 Mastercard. All rights reserved.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: e082952
  Date: 18-01-2019
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="container">
    <%@include file="header.jsp" %>

    <div class="col-6 offset-3 align-self-center">
        <div class="card">
            <div class="card-header bg-info text-white">
                Existing Users:: Login Here
            </div>
            <div class="card-body">
                <form role="form" method="post" action="<c:url value='/user/login'/> ">
                    <div class="form-group">
                        <label for="Username">User name :</label>
                        <input type="text" class="form-controller" placeholder="Username" name="username"/>
                    </div>

                    <div class="form-group">
                        <label for="Password">Password &nbsp;:</label>
                        <input type="password" class="form-controller" placeholder="Password" name="password"/>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="Login" name="submit" class="btn btn-primary"/>
                </form>
                <div class="row">
                    <div class="col-12">
                        <c:if test="${not empty error}">
                            <p class="alert-danger">${error}</p>
                        </c:if>
                        <c:if test="${not empty msg}">
                            <p class="alert-warning">${msg}</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="footer.jsp" %>
</div>
</body>
</html>
