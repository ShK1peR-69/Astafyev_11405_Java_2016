<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 19.03.2016
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form method='post' action='${pageContext.request.contextPath}/process'>
    <label>
        <textarea rows='17' cols='55' name='myText'></textarea>
    </label>

    <br/>

    <div align='left'>
        <label>
            <select name='menu' size='1'>
                <option value='symbols'> Number of symbols</option>
                <option value='words'> Number of words</option>
                <option value='sentences'> Number of sentences</option>
                <option value='paragraphs'> Number of paragraphs</option>
            </select>
        </label>&nbsp
        <input type='submit' value='Process'/>
    </div>
</form>

</body>
</html>
