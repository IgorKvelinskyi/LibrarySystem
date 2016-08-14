<%@include file="/jsp/header.jsp" %>
<%@ taglib uri="/WEB-INF/tlds/table.tld" prefix="tab"%>
<html>
<head>
    <title><fmt:message key="ListBooks" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <form action="${pageContext.request.contextPath}/jsp/librarianPages/mainLibrarianPage.jsp">
        <button type="submit"><fmt:message key="MainPage" bundle="${lang}"/></button>
    </form>
    <table border="1">
        <caption><fmt:message key="ListBooks" bundle="${lang}"/></caption>
        <tr>
            <th><fmt:message key="ID" bundle="${lang}"/> <fmt:message key="User" bundle="${lang}"/></th>
            <th><fmt:message key="Abonnement" bundle="${lang}"/></th>
            <th><fmt:message key="Title" bundle="${lang}"/></th>
            <th><fmt:message key="Author" bundle="${lang}"/></th>
            <th><fmt:message key="Publisher" bundle="${lang}"/></th>
            <th><fmt:message key="Status" bundle="${lang}"/></th>
            <th><fmt:message key="OrderStatus" bundle="${lang}"/></th>
            <th><fmt:message key="DateIssue" bundle="${lang}"/></th>
            <th><fmt:message key="DateReturn" bundle="${lang}"/></th>
        </tr>
        <c:forEach items="${catalogueBooks}" var="catalogueBookstElem">
            <tr>
                <td>${catalogueBookstElem.idUser}</td>
                <td>${catalogueBookstElem.getUser().abonnement}</td>
                <td>${catalogueBookstElem.getBook().title}</td>
                <td>${catalogueBookstElem.getBook().author}</td>
                <td>${catalogueBookstElem.getBook().publisher}</td>
                <td><fmt:message key="${catalogueBookstElem.status}" bundle="${lang}"/></td>
                <td><fmt:message key="${catalogueBookstElem.orderStatus}" bundle="${lang}"/></td>
                <td>${catalogueBookstElem.dateIssue}</td>
                <td>${catalogueBookstElem.dateReturn}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
