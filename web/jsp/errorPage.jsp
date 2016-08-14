<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title>fmt:message key="ERROR 404" bundle="${lang}"/></title>
</head>
<body>
<div class="blockIndex">
    <H2><fmt:message key="ERROR 404" bundle="${lang}"/></H2>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <input type="hidden" name="do" value="exit"/>
        <input type="submit" value="<fmt:message key="OnMainPage" bundle="${lang}"/>" />
    </form>
</div>
</body>
</html>
