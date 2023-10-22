
<%--
  Created by IntelliJ IDEA.
  User: titan
  Date: 14.10.2023
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<sp:message code="label.title"/><br>
First page - Home JSP. USING SPRING - ver 2.0<br>
<a href="/home?lang=en">ENG</a>
<a href="/home?lang=ru">RU</a>
<br>

<sf:form action="/home" method="post" modelAttribute="test">
    <sf:input path="name"/><sf:errors path="name"/><br>
    <sf:input path="secondName"/><sf:errors path="secondName"/><br>
    <sf:button>Add</sf:button>
</sf:form>
<br><br>
<ul>
<c:forEach var="test" items="${tests}">
    <li>${test.name} | ${test.secondName}</li>
</c:forEach>
</ul>
</body>
</html>
