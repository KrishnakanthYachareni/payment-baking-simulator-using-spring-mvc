<%--
  ~ Copyright (c) 2019 Mastercard. All rights reserved.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: e082952
  Date: 17-01-2019
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags/page" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <tf:htmlHead title="KR Bank: Account Holder Details"/>
</head>
<body>
<div class="container">
    <%@include file="header.jsp" %>
    <div class="row">
        <div class="col-12">
            <a href="<c:url value="/bankapp/new"/>" class="btn btn-lg btn-primary">Add New Account</a>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <table class="table table-bordered table-hover">
                <thead class="bg-success">
                <tr>
                    <th><spring:message code="label.accountNo"/></th>
                    <th><spring:message code="label.accountHolderName"/></th>
                    <th><spring:message code="label.balance"/></th>
                    <th><spring:message code="label.accountType"/></th>
                    <th><spring:message code="label.dob"/></th>
                    <th><spring:message code="label.krcode"/></th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="account" items="${accounts}">
                    <c:url var="updateLink" value="/bankapp/edit">
                        <c:param name="accountNo" value="${account.accountNo}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/bankapp/delete">
                        <c:param name="accountNo" value="${account.accountNo}"/>
                    </c:url>
                    <tr>
                        <td>${account.accountNo}</td>
                        <td>${account.accountHolderName}</td>
                        <td>${account.balance}</td>
                        <td>${account.accountType}</td>
                        <td>${account.dateOfBirth}</td>
                        <td>${account.krCode}</td>
                        <td><a href="${updateLink}" class="btn btn-warning"> Edit</a></td>
                        <td><a href="${deleteLink}" class="btn btn-danger"
                               onclick="if(!(confirm('Are you sure to delete'))) return false"> Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%@include file="footer.jsp" %>
        </div>
    </div>
</div>

</body>
</html>
