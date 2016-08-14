<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="MakeOrder" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <form action="${pageContext.request.contextPath}/command" method="get">
        <table border="1" align="center">
            <caption><fmt:message key="ListBooks" bundle="${lang}"/></caption>
            <tr>
                <th><fmt:message key="Title" bundle="${lang}"/></th>
                <th><fmt:message key="Author" bundle="${lang}"/></th>
                <th><fmt:message key="Publisher" bundle="${lang}"/></th>
                <th><fmt:message key="PublicationDate" bundle="${lang}"/></th>
                <th><fmt:message key="NumberPages" bundle="${lang}"/></th>
                <th><fmt:message key="Status" bundle="${lang}"/></th>
                <th><fmt:message key="OrderStatus" bundle="${lang}"/></th>
                <th><fmt:message key="Choice" bundle="${lang}"/></th>
            </tr>
            <c:forEach items="${bookList}" var="booksUserListElem">
                <tr>
                    <th>${booksUserListElem.getBook().title}</th>
                    <th>${booksUserListElem.getBook().author}</th>
                    <th>${booksUserListElem.getBook().publisher}</th>
                    <th>${booksUserListElem.getBook().publicationDate}</th>
                    <th>${booksUserListElem.getBook().numberPages}</th>
                    <th><fmt:message key="${booksUserListElem.status}" bundle="${lang}"/></th>
                    <th><fmt:message key="${booksUserListElem.orderStatus}" bundle="${lang}"/></th>
                    <th><input type="checkbox" name="bookId" value="${booksUserListElem.getBook().id}"/> </th>
                </tr>
            </c:forEach>
        </table>
        <p><fmt:message key="MakeOrder" bundle="${lang}"/>:         
            <input type="hidden" name="do" value="showUserOrderBooks"/>
            <input type="submit"  value="<fmt:message key="Choice" bundle="${lang}"/>"/>
        </p>
    </form>
    <form action="${pageContext.request.contextPath}/command" method="get">
        <p>
            <input type="hidden" name="do" value="mainUserPage"/>
            <input type="submit" value="<fmt:message key="MainPage" bundle="${lang}"/>"/>
        </p>
    </form>
</div>
</body>
</html>
