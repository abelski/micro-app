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


<c:if test="${not empty param.error}">
  <font color="red"> <spring:message key="label.loginerror" />
    : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />">
  <table>
    <tr>
      <td align="right">Login</td>
      <td><input type="text" name="j_username" /></td>
    </tr>
    <tr>
      <td align="right">Password</td>
      <td><input type="password" name="j_password" /></td>
    </tr>
    <tr>
      <td align="right">Remember me</td>
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