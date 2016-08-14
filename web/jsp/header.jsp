<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <style>
        <%@include file='/jsp/css/style.css' %>
    </style>
</head>
<body >
<div >
    <fmt:setLocale value="${locale}"/>
    <fmt:setBundle basename="language" var="lang"/>
    <table >
        <th>
            <form action="${pageContext.request.contextPath}/command" method="get">
                <input type="hidden" name="language" value="ru_RU"/>
                <input type="hidden" name="refer-path" value="${pageContext.request.requestURI}"/>
                <input type="hidden" name="do" value="changeLanguage"/>
                <input type="submit" value="<fmt:message key="RUS" bundle="${lang}"/>"/>
            </form>
        </th>
        <th>
            <form action="${pageContext.request.contextPath}/command" method="get">
                <input type="hidden" name="language" value="en_EN"/>
                <input type="hidden" name="refer-path" value="${pageContext.request.requestURI}"/>
                <input type="hidden" name="do" value="changeLanguage"/>
                <input type="submit" value="<fmt:message key="ENG" bundle="${lang}"/>"/>
            </form>
        </th>
    </table>
</div>
</body>
</html>
