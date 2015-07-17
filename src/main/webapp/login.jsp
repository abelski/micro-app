<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf8">
  <title><spring:message key="label.title" /></title>
</head>
<body>
<%--
<a href="<c:url value="/index" />">
  <spring:message code="label.contacts" />
</a><br/>--%>

<%--
<c:if test="${not empty param.error}">
  <font color="red"> <spring:message key="label.loginerror" />
    : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />">
  <table>
    <tr>
      <td align="right"><spring:message key="label.login" /></td>
      <td><input type="text" name="j_username" /></td>
    </tr>
    <tr>
      <td align="right"><spring:message key="label.password" /></td>
      <td><input type="password" name="j_password" /></td>
    </tr>
    <tr>
      <td align="right"><spring:message key="label.remember" /></td>
      <td><input type="checkbox" name="_spring_security_remember_me" /></td>
    </tr>
    <tr>
      <td colspan="2" align="right"><input type="submit" value="Login" />
        <input type="reset" value="Reset" /></td>
    </tr>
  </table>
</form>
<div>
  <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
    <div class="container" style="margin-left: 60px">
      <div class="row">
        <div class="well span4">
          <legend><spring:message key="main.authorization.authorization"/></legend>
          <div class="alert alert-error">
            <a href="#" class="close" data-dismiss="alert"></a> <spring:message key="main.authorization.invalid.authentication"/>
          </div>
          <form method="POST" action="/j_spring_security_check'">
            <input type="text" class="span12" placeholder="Login" name="j_username" />
            <input type="password" class="span12" placeholder="Password" name="j_password" />
            <label class="checkbox">
              <input type="checkbox" name="j_spring_security_remember_me" value="1" /> <spring:message key="main.authorization.remember.me"/>
            </label>
            <button type="submit" class="btn btn-block btn-success"><spring:message key="main.authorization.login"/></button>
          </form>
        </div>
      </div>
    </div>
  </sec:authorize>

</div>
--%>



<c:if test="${not empty param.error}">
  <font color="red"> <spring:message key="label.loginerror" />
    : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />">
  <table>
    <tr>
      <td align="right"><spring:message key="label.login" /></td>
      <td><input type="text" name="j_username" /></td>
    </tr>
    <tr>
      <td align="right"><spring:message key="label.password" /></td>
      <td><input type="password" name="j_password" /></td>
    </tr>
    <tr>
      <td align="right"><spring:message key="label.remember" /></td>
      <td><input type="checkbox" name="_spring_security_remember_me" /></td>
    </tr>
    <tr>
      <td colspan="2" align="right"><input type="submit" value="Login" />
        <input type="reset" value="Reset" /></td>
    </tr>
  </table>
</form>



</body>
</html>