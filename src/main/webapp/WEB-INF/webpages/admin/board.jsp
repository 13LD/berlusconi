<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<jsp:include page="template/Header.jsp"/>
<div class="container">

    <div class="row">
        <br>
    </div>

    <div class="row">
        <div class="col s12 m6">
            <div class="card-panel teal">
              <span class="white-text">Всего категорий: ${boardInfo.first}
              </span>
            </div>
        </div>

        <div class="col s12 m6">
            <div class="card-panel teal">
              <span class="white-text">Всего товаров: ${boardInfo.second}</span>
            </div>
        </div>
    </div>



</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/materialize.min.js'/>"></script>
<script>
    $(".button-collapse").sideNav();
</script>

<jsp:include page="template/Footer.jsp"/>

