<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/my.css" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <!-- Compiled and minified JavaScript -->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>


    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper indigo darken-1 z-depth-3">
            <a href="#!" class="brand-logo">Berlusconi</a>
            <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="#">Мебель</a></li>
                <li><a href="#">Техника</a></li>
                <li><a href="#">Матрасы</a></li>
                <li><a href="#">Услуги</a></li>
            </ul>
            <ul class="side-nav" id="mobile-demo">
                <li><a href="#">Мебель</a></li>
                <li><a href="#">Техника</a></li>
                <li><a href="#">Матрасы</a></li>
                <li><a href="#">Услуги</a></li>
            </ul>
        </div>
    </nav>
</div>

<div class="container">


    <div class="row center ">
        <h4><br>Категория</h4>

    </div>


    <div class="row">

        <c:forEach var="item" items="${goods}">
            <div class="col s12 m4">
                <div class="card medium">
                    <c:if test="${item.attachments.isEmpty() == false}">
                    <div class="card-image">
                        <img src="<c:out value="${item.attachments.get(0)}"/>">
                    </div>
                    </c:if>
                    <div class="card-content">
                        <a href="/good/${item.id}"> <h5><c:out value="${item.title}"/></h5></a>

                        <c:out value="${item.description}"/>
                    </div>

                </div>
            </div>

        </c:forEach>


    </div>

    <div class="row">

        <ul class="pagination center">
            <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
            <li class="active"><a href="#!">1</a></li>
            <li class="waves-effect"><a href="#!">2</a></li>
            <li class="waves-effect"><a href="#!">3</a></li>
            <li class="waves-effect"><a href="#!">4</a></li>
            <li class="waves-effect"><a href="#!">5</a></li>
            <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
        </ul>

    </div>

</div>

<footer class="page-footer teal">
    <div class="footer-copyright">
        <div class="container">
            Made by <a class="brown-text text-lighten-3" href="#">Berlusconi</a>
        </div>
    </div>
</footer>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/indexpage.js"></script>


</body>
</html>
