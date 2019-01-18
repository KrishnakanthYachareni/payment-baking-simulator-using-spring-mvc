<%--
  ~ Copyright (c) 2019 Mastercard. All rights reserved.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: e082952
  Date: 14-01-2019
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <tf:htmlHead title="KB Bank:New Account"/>
</head>
<body>
<%--<h2>Please Fill Up the Form Details</h2>
<tf:image src="Rupay-Logo.png" id="paypalLogo"/>
<form:form action="saveAccount" modelAttribute="account" method="post">
    <table>
        <tr>
            <td><spring:message code="label.accountNo"/>:</td>
            <td>
                <form:input path="accountNo" size="30"/>
                <form:errors path="accountNo" cssClass="error"/>
                <b><font color="red">${message}</font></b>
            </td>
        </tr>
        <tr>
            <td><spring:message code="label.accountHolderName"/>:</td>
            <td>
                <form:input path="accountHolderName" size="30"/>
                <form:errors path="accountHolderName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="label.balance"/>:</td>
            <td>
                <form:input path="balance" size="30"/>
                <form:errors path="balance" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="label.accountType"/>:</td>
            <td>
                <form:select path="accountType">
                    <form:option value="">Select Account Type</form:option>
                    <form:option value="SAVINGS">Savings</form:option>
                    <form:option value="CURRENT">Current</form:option>
                </form:select>
                <form:errors path="accountType" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="label.dob"/>:</td>
            <td>
                <form:input path="dateOfBirth" size="30"/>
                <form:errors path="dateOfBirth" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="label.krcode"/>:</td>
            <td>
                <form:input path="krCode" size="30"/>
                <form:errors path="krCode" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save Account" name="btnSubmit"/>
            </td>
        </tr>
    </table>
</form:form>--%>

<!-- Form Styling with Bootstrap-->
<div class="container">
    <%@include file="header.jsp" %>

    <div class="row">
        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <h2 class="page-header"> Please Fill Up the Form Details</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <form:form action="saveAccount" modelAttribute="account" cssClass="form-horizontal" role="form">
                <div class="form-group row">
                    <label for="accountNo" class="col-6 col-form-label"><spring:message code="label.accountNo"/></label>
                    <div class="col-6">
                        <form:input path="accountNo" cssClass="form-control"/>
                        <form:errors path="accountNo" cssClass="alert-danger"/>
                        <text class="alert-danger">${message}</text>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="accountHolderName" class="col-6 col-form-label"><spring:message
                            code="label.accountHolderName"/></label>
                    <div class="col-6">
                        <form:input path="accountHolderName" cssClass="form-control"/>
                        <form:errors path="accountHolderName" cssClass="alert-danger"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="balance" class="col-6 col-form-label"><spring:message code="label.balance"/></label>
                    <div class="col-6">
                        <form:input path="balance" cssClass="form-control"/>
                        <form:errors path="balance" cssClass="alert-danger"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="accountType" class="col-6 col-form-label"><spring:message
                            code="label.accountType"/></label>
                    <div class="col-6">
                        <form:select path="accountType" cssClass="form-control">
                            <form:option value="">Select Account type</form:option>
                            <form:option value="SAVINGS">Savings</form:option>
                            <form:option value="CURRENT">Current</form:option>
                        </form:select>
                        <form:errors path="accountType" cssClass="alert-danger"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="dateOfBirth" class="col-6 col-form-label"><spring:message code="label.dob"/></label>
                    <div class="col-6">
                        <form:input path="dateOfBirth" cssClass="form-control"/>
                        <form:errors path="dateOfBirth" cssClass="alert-danger"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="krCode" class="col-6 col-form-label"><spring:message code="label.krcode"/></label>
                    <div class="col-6">
                        <form:input path="krCode" cssClass="form-control"/>
                        <form:errors path="krCode" cssClass="alert-danger"/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-6 col6">
                        <input type="submit" value="Save Account" name="btnSubmit" class="btn btn-primary"/>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>

