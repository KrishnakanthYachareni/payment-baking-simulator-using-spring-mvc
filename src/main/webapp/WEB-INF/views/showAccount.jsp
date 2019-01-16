<%--
  ~ Copyright (c) 2019 Mastercard. All rights reserved.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: e082952
  Date: 14-01-2019
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags/page" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title"/></title>
    <tf:htmlHead/>
</head>
<body>
<h2>KR: Bank Account Details</h2>

<%-- This is for jsp page to page with query Param data reading.
<p>Account # : ${param.accountNo}</p>
<p>Account Holder Name : ${param.accountHolderName}</p>
<p>Balance : ${param.balance}</p>--%>

<p><spring:message code="label.accountNo"/>: ${account.accountNo}</p>
<p><spring:message code="label.accountHolderName"/>: ${account.accountHolderName}</p>
<p><spring:message code="label.balance"/>: ${account.balance}</p>
<p><spring:message code="label.accountType"/>: ${account.accountType}</p>
<p><spring:message code="label.dob"/>: ${account.dateOfBirth}</p>
<p><spring:message code="label.krcode"/>: ${account.krCode}</p>
</body>
</html>
