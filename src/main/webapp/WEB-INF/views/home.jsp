<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Home"/>

<%@ include file="header.jsp" %>
Welcome to my world!

<a href="<c:url value='/test-response' />">test-response</a>
<%@ include file="footer.jsp" %>