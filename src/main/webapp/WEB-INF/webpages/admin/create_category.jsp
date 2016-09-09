<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<jsp:include page="template/Header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s12 m6 offset-m3">
            <form:form method="post" modelAttribute="Category" action="" enctype="multipart/form-data">
                <form:input path="id" type="hidden"/> <!-- bind to user.name-->
                <label>Имя категории</label>
                <form:input path="name" type="text"/> <!-- bind to user.name-->
                <form:errors path="name"/>

                <label>Описание категории</label>
                <form:textarea id="textarea1" cssClass="materialize-textarea" path="description"
                               type="text"/> <!-- bind to user.name-->
                <form:errors path="description"/>
                <c:set var="image" value="${Category.imageUrl}"/>
                <c:if test="${image.length() > 0}" >
                    <img class="col sm12 m4 materialboxed" src="${image}"/>
                </c:if>

                <input name="imagefile" class='file-field' type="file"/>

                <div class="row center">
                    <div class="col m12 s12"><input class="btn" type="submit" value="Сохранить"/></div>
                </div>
            </form:form>

        </div>

    </div>

</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/materialize.min.js'/>"></script>
<script>
    $(".button-collapse").sideNav();
</script>
<jsp:include page="template/Footer.jsp"/>