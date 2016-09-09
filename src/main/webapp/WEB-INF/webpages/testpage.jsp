<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Granium
  Date: 27.08.16
  Time: 01:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form method="post" action="" enctype="multipart/form-data">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="file" name="attachments"/>

    <div class="row center">
        <div class="col m12 s12"><input class="btn" type="submit" value="Сохранить"/></div>
    </div>

</form:form>
</body>
</html>
