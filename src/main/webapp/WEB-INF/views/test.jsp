<%--
  Created by IntelliJ IDEA.
  User: GMIT
  Date: 2022-11-18
  Time: 오후 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>View Test Page</title>
</head>
<body>
    <h2>Hello ${name}</h2>
    <div> JSP LIST TEST </div>
    <c:forEach var="item" items="${list}" varStatus="idx">
        ${idx.index}, ${item.name}
    </c:forEach>

</body>
</html>
