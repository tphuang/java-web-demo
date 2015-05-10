<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="NewUser"/>

<%@ include file="../header.jsp" %>
<div class="content-container clear">
    <div class="content user-pages">
        <form class="form-horizontal" name='f' action="<c:url value='/user/create' />" method="post">
            <div class="error"><b>${errorMessage}</b></div>
            <div class="control-group">
                <label class="control-label" for="userName">Username*</label>

                <div class="controls">
                    <input class="form-control" type='text' id="userName" name='userName' placeholder="Username"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="passWord">Password*</label>

                <div class="controls">
                    <input class="form-control" type="password" id="passWord" name="passWord" placeholder="Password"/>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-primary">Sign In</button>
                </div>
            </div>

            Have an account, please login! <a href='<c:url value="/login" />'>Click here to login</a>
        </form>
    </div>
</div>

<%@ include file="../footer.jsp" %>