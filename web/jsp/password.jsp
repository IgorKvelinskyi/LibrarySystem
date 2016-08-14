<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="LOGIN" bundle="${lang}"/>Enter password</title>
</head>
<body>
<div class="block">
    <form action="${pageContext.request.contextPath}/command" method="post">
        <p>
            <label><fmt:message key="Your" bundle="${lang}"/> <fmt:message key="LOGIN" bundle="${lang}"/>: ${login}<br></label>
        </p>
        <label><fmt:message key="Your" bundle="${lang}"/> <fmt:message key="Password" bundle="${lang}"/>:<br></label>
        <input type="text" name="password" value="" size="15" maxlength="15"/>
        </p>
        <input type="hidden" name="login" value="${login}">

        <p>
            <input type="hidden" name="do" value="SingPass"/>
            <input type="submit" value="<fmt:message key="SignUp" bundle="${lang}"/>"/>
        </p>
    </form>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <input type="hidden" name="do" value="exit"/>
            <input type="submit" value="<fmt:message key="Exit" bundle="${lang}"/>"/>
        </p>
    </form>
    <c:if test="${checkInUserMessage != null}">
        <h1><fmt:message key="${checkInUserMessage}" bundle="${lang}"/></h1>
    </c:if>
</div>
</body>
</html>
