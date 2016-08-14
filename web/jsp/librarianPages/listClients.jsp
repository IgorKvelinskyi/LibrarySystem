<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="List" bundle="${lang}"/> <fmt:message key="User" bundle="${lang}"/> </title>
</head>
<body>
<div class="block">
    <table border="1">
        <p>
        <form action="${pageContext.request.contextPath}/jsp/librarianPages/mainLibrarianPage.jsp">
            <button type="submit"><fmt:message key="MainPage" bundle="${lang}"/></button>
        </form>
        </p>
        <caption><h1><fmt:message key="ListUsers" bundle="${lang}"/></h1></caption><br>
        <tr>
            <th><fmt:message key="ID" bundle="${lang}"/></th>
            <th><fmt:message key="FirstName" bundle="${lang}"/></th>
            <th><fmt:message key="LastName" bundle="${lang}"/></th>
            <th><fmt:message key="Abonnement" bundle="${lang}"/></th>
            <th><fmt:message key="ContactInformation" bundle="${lang}"/></th>
            <th><fmt:message key="LOGIN" bundle="${lang}"/></th>
            <th><fmt:message key="Password" bundle="${lang}"/></th>
            <th><fmt:message key="LibrarianStatus" bundle="${lang}"/></th>
        </tr>
        <c:forEach items="${customersList}" var="customersListElem">
            <tr>
                <td>${customersListElem.id}</td>
                <td><input type="text" name="fist_name" value="${customersListElem.firstName}" size="15"/>  </td>
                <td><input type="text" name="last_name" value="${customersListElem.lastName}" size="15"/> </td>
                <td><input type="text" name="abonnement" value="${customersListElem.abonnement}" size="12"/> </td>
                <td><input type="text" name="contact_information" value="${customersListElem.contactInformation}" size="30"/> </td>
                <td><input type="text" name="login" value="${customersListElem.login}" size="10"/> </td>
                <td><input type="text" name="password" value="${customersListElem.password}" size="10"/> </td>
                <td><input type="text" name="librarian" value=<fmt:message key="${customersListElem.librarian}" bundle="${lang}"/> size="20"/> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
