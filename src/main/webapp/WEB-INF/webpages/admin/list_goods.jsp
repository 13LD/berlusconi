<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="template/Header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">


    <div style="margin-top: 25px; margin-bottom: 25px" class="row">
        <div class="col s1 m2">Категории</div>
        <div class="col s12 m2">Заголовок</div>
        <div class="col s12 m2">Описание</div>
        <div class="col s6 m3"></div>
        <div class="col s6 m3"></div>

    </div>


    <c:forEach var="good" items="${goodsList}">
        <div class="row">
            <div class="col s1 m2 truncate"><span class=""><c:forEach var="category" items="${good.categories}"> <c:out value="${category.name} "/></c:forEach> </span>  </div>
            <div class="col s12 m2 truncate"><c:out value="${good.title}"/></div>
            <div class="col s12 m2 truncate" ><c:out value="${good.description}"/></div>
            <div class="col s6 m3">
                <a href="/admin/good/${good.id}">
                    <div class="btn blue">Изменить</div>
                </a>
            </div>
            <div class="col s6 m3">
                <form method="post" action="/admin/good/${good.id}/delete">
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