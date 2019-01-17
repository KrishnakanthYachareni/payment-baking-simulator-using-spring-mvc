<%@ tag display-name="Page XHTML header" body-content="scriptless" %>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" required="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="-1" />
    <meta name="robots" content="noindex" />
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/style/site.css" />" />
    <jsp:doBody/>
</head>