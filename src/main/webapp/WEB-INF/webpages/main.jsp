<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Berlusconi</title>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="resources/css/my.css" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <!-- Compiled and minified JavaScript -->
    <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>


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


<div class="slider">
    <ul class="slides">
        <li>
            <img  src="https://unsplash.it/1024/768?random"> <!-- random image -->
        </li>
        <li>
            <img src="https://unsplash.it/1024/768?random"> <!-- random image -->
        </li>
        <li>
            <img src="https://unsplash.it/1024/768?random"> <!-- random image -->
        </li>
        <li>
            <img src="https://unsplash.it/1024/768?random"> <!-- random image -->
        </li>
    </ul>
</div>

<div class="row">
    <div class="section center-align">
        <h3>Мы предлагаем</h3>
    </div>
</div>

<div class="container">

    <div class="row">

        <div class="col m4 ">

            <div class="card medium">
                <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator responsive-img"
                         src="https://unsplash.it/1024/768?random">
                </div>
                <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Мебель<i class="material-icons right">more_vert</i></span>
                    <p><a href="#">Подробнее</a></p>
                </div>
                <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Мебель<i
                            class="material-icons right">close</i></span>
                    <p>Информация о разделе</p>
                </div>
            </div>

        </div>
        <div class="col m4 ">

            <div class="card medium">
                <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator responsive-img"
                         src="https://unsplash.it/1024/768?random">
                </div>
                <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Техника<i class="material-icons right">more_vert</i></span>
                    <p><a href="#">Подробнее</a></p>
                </div>
                <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Техника<i
                            class="material-icons right">close</i></span>
                    <p>Информация о разделе</p>
                </div>
            </div>

        </div>
        <div class="col m4 ">

            <div class="card medium">
                <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator responsive-img"
                         src="https://unsplash.it/1024/768?random">
                </div>
                <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">Услуги<i class="material-icons right">more_vert</i></span>
                    <p><a href="#">Подробнее</a></p>
                </div>
                <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4">Услуги<i
                            class="material-icons right">close</i></span>
                    <p>Информация о разделе</p>
                </div>
            </div>

        </div>

    </div>


    <div class="row">
        <div class="divider"></div>
    </div>

    <div class="row">

        <div class="col s4 center">
            <i class="material-icons medium ">flash_on</i>
            <p class="center">Оперативное выполнение заказа</p>
        </div>
        <div class="col s4 center">
            <i class="material-icons medium">hd</i>
            <p class="center">Только качественные материалы</p>
        </div>

        <div class="col s4 center">
            <i class="material-icons medium">message</i>
            <p class="center">Индивидуальный подход</p>
        </div>

    </div>

    <div class="row">

        <div class="col s4 center">
            <i class="material-icons medium ">business</i>
            <p class="center">Собственное производство</p>
        </div>
        <div class="col s4 center">
            <i class="material-icons medium">fast_forward</i>
            <p class="center">Доставка и сборка</p>
        </div>

        <div class="col s4 center">
            <i class="material-icons medium">shopping_cart</i>
            <p class="center">Огромный выбор</p>
        </div>

    </div>


    <div class="row">
        <div class="divider"></div>
        <div class="section center-align">
            <h4>Наши партнеры</h4>
        </div>

    </div>

    <div class="row">
        <div class="col s12 m6">
            <div class="card lighten-1">
                <div class="card-content ">
                    <span class="card-title">Партнер 1</span>
                    <p>Описание партнера</p>
                </div>
                <div class="card-action">
                    <a href="#">Посетить</a>
                </div>
            </div>
        </div>

        <div class="col s12 m6">
            <div class="card lighten-1">
                <div class="card-content ">
                    <span class="card-title">Партнер 1</span>
                    <p>Описание партнера</p>
                </div>
                <div class="card-action">
                    <a href="#">Посетить</a>
                </div>
            </div>
        </div>

        <div class="col s12 m6">
            <div class="card lighten-1">
                <div class="card-content ">
                    <span class="card-title">Партнер 1</span>
                    <p>Описание партнера</p>
                </div>
                <div class="card-action">
                    <a href="#">Посетить</a>
                </div>
            </div>
        </div>

        <div class="col s12 m6">
            <div class="card lighten-1">
                <div class="card-content ">
                    <span class="card-title">Партнер 1</span>
                    <p>Описание партнера</p>
                </div>
                <div class="card-action">
                    <a href="#">Посетить</a>
                </div>
            </div>
        </div>
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
<script type="text/javascript" src="resources/js/materialize.min.js"></script>
<script type="text/javascript" src="resources/js/indexpage.js"></script>


</body>
</html>
