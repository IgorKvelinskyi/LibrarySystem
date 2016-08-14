<%@include file="/jsp/header.jsp" %>
<html>
<head>
    <title><fmt:message key="PersonalProfile" bundle="${lang}"/></title>
</head>
<body>
<div class="block">
    <form action="${pageContext.request.contextPath}/command" method="get">
        <table border="1" align="center">
            <caption><fmt:message key="PersonalProfile" bundle="${lang}"/></caption>
            <tr>
                <th><fmt:message key="ID" bundle="${lang}"/></th>
                <th><fmt:message key="FirstName" bundle="${lang}"/></th>
                <th><fmt:message key="LastName" bundle="${lang}"/></th>
                <th><fmt:message key="Abonnement" bundle="${lang}"/></th>
                <th><fmt:message key="ContactInformation" bundle="${lang}"/></th>
                <th><fmt:message key="LOGIN" bundle="${lang}"/></th>
                <th><fmt:message key="Password" bundle="${lang}"/></th>
            </tr>
            <tr>
                <td>${id}
                </td>
                <td><input type="text" name="first_name" value="${firstName}"/>
                </td>
                <td><input type="text" name="last_name" value="${lastName}"/>
                </td>
                <td>${abonnement}
                </td>
                <td><input type="text" name="contact_information" value="${contactInformation}"/>
                </td>
                <td>${login}
                </td>
                <td><input type="text" name="password" value="${password}" size="5" maxlength="15"/>
                </td>
            </tr>
        </table>
        <p>
            <input type="hidden" name="do" value="edit"/>
            <input type="submit" value="<fmt:message key="Edit" bundle="${lang}"/>"/>
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
