<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="template/Header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">


    <div style="margin-top: 25px; margin-bottom: 25px" class="row">
        <div class="col s1 m1">ID</div>
        <div class="col s12 m3">Название</div>
        <div class="col s6 m3"></div>
        <div class="col s6 m3"></div>

    </div>


    <c:forEach var="category" items="${categoriesList}">
        <div class="row">
            <div class="col s1 m1"><c:out value="${category.id}"/></div>
            <div class="col s12 m3"><c:out value="${category.name}"/></div>
            <div class="col s6 m3">
                <a href="/admin/category/${category.id}">
                    <div class="btn blue">Изменить</div>
                </a>
            </div>
            <div class="col s6 m3">
                <form method="POST" action="/admin/category/${category.id}/delete">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input class="btn red" type="submit" value="Удалить"/>
                </form>
            </div>

        </div>
    </c:forEach>

</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/materialize.min.js'/>"></script>
<script>
    $(".button-collapse").sideNav();
</script>
<jsp:include page="template/Footer.jsp"/>