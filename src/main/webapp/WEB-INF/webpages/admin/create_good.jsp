<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="template/Header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s12 m6 offset-m3 ">
            <form:form method="post" modelAttribute="GoodDTO" action="" enctype="multipart/form-data" >
                <form:input path="id" type="hidden"/> <!-- bind to user.name-->
                <label>Заголовок товара</label>
                <form:input path="title" type="text"/> <!-- bind to user.name-->
                <form:errors path="title"/>

                <label>Описание товара</label>


                <form:textarea id="textarea1" cssClass="materialize-textarea" path="description"
                               type="text"/> <!-- bind to user.name-->
                <form:errors path="description"/>

                <label>Категории</label>
                <form:select multiple="true" path="categories">
                    <form:options items="${categoriesList}" itemLabel="name"/>
                </form:select>


                <div class="row">
                    <c:forEach var="attachment" items="${GoodDTO.attachments}" varStatus="status">
                        <div id="attachment-${attachment.id}">
                            <form:hidden path="attachments[${status.index}].id"/>
                            <form:hidden path="attachments[${status.index}].url"/>
                            <form:hidden path="attachments[${status.index}].good"/>
                            <form:hidden path="attachments[${status.index}].type"/>
                            <img class="col sm12 m4 materialboxed" src="${attachment.url}"/>
                            <div class="btn green remove">Удалить</div>
                        </div>
                    </c:forEach>
                </div>
                <div class="row center">
                    <div id="add-image" class="btn red">Добавить изображение</div>

                </div>

                <div id="images-container" class="row">

                </div>

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
    $(document).ready(function () {
        $('select').material_select();
        $('#add-image').click(function () {
            $('#images-container')
                    .append("<div> " +
                            "<input class='file-field' type=\"file\" name=\"files\"/>" +
                            "</div>");
        })

    });
    $(".button-collapse").sideNav();



    $('.remove').click(function () {
        $(this).parent().remove();
    })
</script>
<jsp:include page="template/Footer.jsp"/>
