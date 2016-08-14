<%@include file="/jsp/header.jsp" %>
<%@ taglib uri="/WEB-INF/tlds/table.tld" prefix="tab" %>
<html>
<head>
    <title><fmt:message key="ListBooks" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <table border="1" align="center">
        <caption><fmt:message key="ListBooks" bundle="${lang}"/></caption>
        <tr>
            <th><fmt:message key="Genres" bundle="${lang}"/></th>
            <th><fmt:message key="Title" bundle="${lang}"/></th>
        </tr>
        <c:forEach items="${listBooksGenre}" var="listBooksGenreElem">
            <tab:table-body title="${listBooksGenreElem.title}" genre="${listBooksGenreElem.genre.genre}" />
        </c:forEach>
    </table>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <input type="hidden" name="do" value="mainUserPage"/>
            <input type="submit" value="<fmt:message key="MainPage" bundle="${lang}"/>"/>
        </p>
    </form>
</div>
</body>
</html>
