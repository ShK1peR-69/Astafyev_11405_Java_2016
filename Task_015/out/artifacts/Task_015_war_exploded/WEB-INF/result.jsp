<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 20.03.2016
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<%if (request.getParameter("menu").equals("symbols")) {%>
Text has about ${symbols} symbols!
<%}%>

<%if (request.getParameter("menu").equals("words")) {%>
Text has about ${words} words!
<%}%>

<%if (request.getParameter("menu").equals("sentences")) {%>
Text has about ${sentences} sentences!
<%}%>

<%if (request.getParameter("menu").equals("paragraphs")) {%>
Text has about ${paragrphs} paragraphs!
<%}%>

</body>
</html>
