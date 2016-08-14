<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="Registration" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <form action="${pageContext.request.contextPath}/command" method="post">
        <p>
            <label><fmt:message key="Your" bundle="${lang}"/> <fmt:message key="LOGIN" bundle="${lang}"/>:<br></label>
            <input type="text" name="login" value="" size="15" maxlength="15"/>
        </p>
        <c:if test="${login_used != null}">
            <h1><fmt:message key="${login_used}" bundle="${lang}"/></h1>
        </c:if>
        <p>
            <input type="hidden" name="do" value="SignUp"/>
            <input type="submit" value="<fmt:message key="Accept" bundle="${lang}"/>"/>
        </p>
    </form>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <input type="hidden" name="do" value="exit"/>
            <input type="submit" value="<fmt:message key="Exit" bundle="${lang}"/>"/>
        </p>
    </form>
</div>
</body>
</html>
