<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="Welcome" bundle="${lang}"/>: ${firstName} ${lastName}</title>
</head>
<body>
<div class="block">
    <p >
    <form action="${pageContext.request.contextPath}/command" method="get" class="exitBlock">
        <input type="hidden" name="do" value="exit"/>
        <input type="submit" value="<fmt:message key="Exit" bundle="${lang}"/>"/>
    </form>
    </p>
    <fmt:message key="Welcome" bundle="${lang}"/>: ${firstName} ${lastName}<br>
    <p>
    <form action="<c:url value="/jsp/userPages/userEditDataPage.jsp"/>">
        <input type="submit" value="<fmt:message key="PersonalProfile" bundle="${lang}"/>"/>
    </form>
    </p>
    <ul>
        <li>
            <form action="${pageContext.request.contextPath}/command" method="get">
                <label><fmt:message key="Genres" bundle="${lang}"/>  : </label>
                    <input type="hidden" name="do" value="choiceGenres"/>
                    <input type="submit" value="<fmt:message key="Choice" bundle="${lang}"/>"/>
                </form>
        </li>
        <li>
            <form action="${pageContext.request.contextPath}/command" method="get">
                <fmt:message key="ListBooksGenre" bundle="${lang}"/>:
                <input type="hidden" name="do" value="listBooksGenre"/>
                <input type="submit"  value="<fmt:message key="Choice" bundle="${lang}"/>"/>
            </form>
        </li>
        <li>
            <form action="${pageContext.request.contextPath}/command" method="get">
                <fmt:message key="ListBooksUser" bundle="${lang}"/>:
                <input type="hidden" name="do" value="showUserOrderBooks"/>
                <input type="submit"  value="<fmt:message key="Choice" bundle="${lang}"/>"/>
            </form>
        </li>
    </ul>
</div>
</body>
</html>
