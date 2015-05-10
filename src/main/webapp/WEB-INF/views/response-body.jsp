<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Home"/>

<%@ include file="header.jsp" %>
<script type="text/javascript" src="<c:url value='/scripts/personHandler.js' />"></script>
<table>
    <tr>
        <td>id</td>
        <td><input id="id" value="100" /></td>
    </tr>
    <tr>
        <td>name</td>
        <td><input id="name" value="snowolf" /></td>
    </tr>
    <tr>
        <td>status</td>
        <td><input id="status" value="true" /></td>
    </tr>
    <tr>
        <td><input type="button" id="profile" value="Profile——GET" /></td>
        <td><input type="button" id="login" value="Login——POST" /></td>
    </tr>
</table>

<%@ include file="footer.jsp" %>