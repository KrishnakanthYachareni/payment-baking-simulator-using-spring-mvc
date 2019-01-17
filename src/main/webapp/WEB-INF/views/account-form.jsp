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
<h2>Please Fill Up the Form Details</h2>
<tf:image src="Rupay-Logo.png" id="paypalLogo"/>
<form:form action="saveAccount" modelAttribute="account" method="post">
    <table>
        <tr>
            <td><spring:message code="label.accountNo"/>:</td>
            <td>
                <form:input path="accountNo" size="30"/>
                <form:errors path="accountNo" cssClass="error"/>
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
    </body>
    </html>
</form:form>