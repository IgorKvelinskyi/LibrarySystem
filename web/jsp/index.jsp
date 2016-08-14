<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="LOGIN" bundle="${lang}"/></title>
</head>
<body>
<div class="blockIndex">
    <h2><fmt:message key="LOGIN" bundle="${lang}"/></h2>
    <form action="${pageContext.request.contextPath}/command" method="post" >
            <label><fmt:message key="Your" bundle="${lang}"/> <fmt:message key="LOGIN" bundle="${lang}"/>:
                <br>
            </label>
            <input type="text" name="login" value="" size="15" maxlength="15"/>
            <br>
            <label><fmt:message key="Your" bundle="${lang}"/> <fmt:message key="Password" bundle="${lang}"/>:
                <br>
            </label>
            <input type="password" name="password" value=""  size="15" maxlength="15"/>
            <p>
            <input type="hidden" name="do" value="login"/>
            <input type="submit" value="<fmt:message key="SignIn" bundle="${lang}"/>"/>
            </p>
    </form>
    <form action="${pageContext.request.contextPath}/jsp/registration.jsp" >
        <button type="submit"><fmt:message key="SignUp" bundle="${lang}"/></button>
    </form>
    </div>
</body>
</html>
