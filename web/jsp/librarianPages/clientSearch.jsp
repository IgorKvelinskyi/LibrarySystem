<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="User" bundle="${lang}"/> <fmt:message key="Search" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <p>

    <form action="${pageContext.request.contextPath}/jsp/librarianPages/mainLibrarianPage.jsp">
        <button type="submit"><fmt:message key="MainPage" bundle="${lang}"/></button>
    </form>
    <form action="${pageContext.request.contextPath}/command" method="get">
    </p>
    <table border="1" content="block">
            <tr>
                <table border="1">
                    <caption><fmt:message key="User" bundle="${lang}"/></caption>
                    <tr>
                        <th><fmt:message key="FirstName" bundle="${lang}"/></th>
                        <th><fmt:message key="LastName" bundle="${lang}"/></th>
                        <th><fmt:message key="Abonnement" bundle="${lang}"/></th>
                    </tr>
                    <tr>
                        <td><input type="text" name="fist_name" value="${client.firstName}" size="8"/></td>
                        <td><input type="text" name="last_name" value="${client.lastName}" size="8"/></td>
                        <td><input type="text" name="abonnement" value="${client.abonnement}" size="8"/></td>
                    </tr>
                </table>
            </tr>
            <tr>
                <table border="1">
                    <caption><fmt:message key="ListBooks" bundle="${lang}"/> </caption>
                    <tr>
                        <th><fmt:message key="Title" bundle="${lang}"/></th>
                        <th><fmt:message key="Author" bundle="${lang}"/></th>
                        <th><fmt:message key="DateIssue" bundle="${lang}"/></th>
                        <th><fmt:message key="DateReturn" bundle="${lang}"/></th>
                        <th><fmt:message key="Status" bundle="${lang}"/></th>
                        <th><fmt:message key="OrderStatus" bundle="${lang}"/></th>
                        <th><fmt:message key="ChangeStatus" bundle="${lang}"/></th>
                    </tr>
                    <c:forEach items="${bookUserList}" var="booksUserListElem">
                        <tr>
                            <td>${booksUserListElem.getBook().title}</td>
                            <td>${booksUserListElem.getBook().author}</td>
                            <td><input type="date" name="dateIssue"  required oninvalid="this.setCustomValidity(<fmt:message key="DateIssue" bundle="${lang}"/>)" oninput="setCustomValidity('')"   value="${booksUserListElem.dateIssue}"   pattern="[0-9]{4}\-[0-9]{2}\-[0-9]{2}" size="8"/></td>
                            <td><input type="date" name="dateReturn" required oninvalid="this.setCustomValidity(<fmt:message key="DateReturn" bundle="${lang}"/>)" oninput="setCustomValidity('')"   value="${booksUserListElem.dateReturn}" pattern="[0-9]{4}\-[0-9]{2}\-[0-9]{2}" size="8"/></td>
                            <td>
                                    <input type="hidden" name="idCatal" value="${booksUserListElem.id}"/> <fmt:message key="${booksUserListElem.status}" bundle="${lang}"/>
                            </td>
                            <td><fmt:message key="${booksUserListElem.orderStatus}" bundle="${lang}"/></td>
                            <td>
                                <select name="idStat">
                                    <c:forEach items="${statusList}" var="statusListElem">
                                        <option value="${statusListElem.idStatus}"> <fmt:message key="${statusListElem.status}" bundle="${lang}"/></option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </tr>
    </table>
        <p>
            <input type="hidden" name="do" value="placeOrder"/>
            <input type="submit"  value="<fmt:message key="Accept" bundle="${lang}"/>"/>
        </p>
</form>
</div>
</body>
</html>
