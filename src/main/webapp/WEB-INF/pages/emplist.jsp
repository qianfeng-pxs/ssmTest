<%--
  Created by IntelliJ IDEA.
  User: 彭兴昇
  Date: 2020/11/20
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet"  href="${pageContext.servletContext.contextPath}/style/bootstrap4/css/bootstrap.css" >
    <title>员工信息</title>
</head>
<body>
<table class="table table-hover table-dark">
    <tr>
        <th>eid</th>
        <th>ename</th>
        <th>age</th>
        <th>sex</th>
        <th>department</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${empList}" var="emp">
        <tr>
            <td>${emp.eid}</td>
            <td>${emp.ename}</td>
            <td>${emp.age}</td>
            <td>${emp.sex==0?"女":"男"}</td>
            <td>${emp.department.dname}</td>
            <td>
                <a href="emp">删除</a>
                <a href="emp">修改</a>
            </td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="10">${page}</td>
    </tr>

</table>
</body>
</html>
