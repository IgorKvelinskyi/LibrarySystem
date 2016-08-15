<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="MainPage" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <form action="${pageContext.request.contextPath}/command" method="get"class="exitBlock" >
        <p>
            <input type="hidden" name="do" value="exit"/>
            <input type="submit" value="<fmt:message key="Exit" bundle="${lang}"/>"/>
        </p>
    </form><label><H2><fmt:message key="RequestStatus" bundle="${lang}"/> -<fmt:message key="${requestStatus}" bundle="${lang}"/></H2><br></label>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <input type="hidden" name="do" value="listUsers"/>
            <input type="submit" name="do" value="<fmt:message key="ListUsers" bundle="${lang}"/>" />
        </p>
    </form>

    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <label><fmt:message key="EnterAbonnement" bundle="${lang}"/><br></label>
            <input type="text" name="abonnement" value="" size="15" maxlength="15"/>
            <input type="hidden" name="do" value="clientSearch"/>
            <input type="submit" value="<fmt:message key="Search" bundle="${lang}"/>"/>
        </p>
    </form>

    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <label><fmt:message key="ListBooks" bundle="${lang}"/>:</label>
            <input type="hidden" name="do" value="catalogueBooks"/>
            <input type="submit" value="<fmt:message key="Choice" bundle="${lang}"/>"/>
        </p>
    </form>
</div>
</body>
</html>
