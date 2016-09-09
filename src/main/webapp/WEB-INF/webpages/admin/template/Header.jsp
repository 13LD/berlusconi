<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <!-- Compiled and minified JavaScript -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/materialize.min.css'/>"
          media="screen,projection"/>


    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


</head>
<body>

<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper indigo darken-1 z-depth-3">
            <a href="#!" class="brand-logo center hide-on-small-and-down">Администрирование</a>
            <a href="#" data-activates="mobile-demo" class="button-collapse show-on-medium-and-up"><i
                    class="material-icons">menu</i></a>
            <ul class="side-nav" id="mobile-demo">
                <li class="hide-on-med-and-up"><a href=""><h5>Администрирование</h5></a></li>
                <li><a href="/admin">Главная</a></li>
                <li><a href="/admin/category">Категории</a></li>
                <li><a href="/admin/good">Товары</a></li>
                <li><a href="/admin/category/create">Добавить категорию</a></li>
                <li><a href="/admin/good/create">Добавить товар</a></li>
            </ul>
        </div>
    </nav>
</div>
