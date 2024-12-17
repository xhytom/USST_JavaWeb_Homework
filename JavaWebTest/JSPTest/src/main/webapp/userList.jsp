<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10042
  Date: 2024/12/18
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table border="1" align="center" style="border-collapse: collapse;width: 30%">
        <tr align="center">
            <th align="center">序号</th>
            <th align="center">名称</th>
            <th align="center">年龄</th>
            <th align="center">冻结</th>
            <th align="center">操作</th>
        </tr>
        <c:forEach items="${userEntities}" var="user" varStatus="i">
            <tr align="center">
                <td align="center">${i.index + 1}</td>
                <td align="center">${user.getName()}</td>
                <td align="center">${user.getAge()}</td>
                <td align="center"><c:if test="${user.getState()==0}">未冻结</c:if><c:if test="${user.getState()==1}">冻结</c:if> </td>
                <td align="center"><a href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
