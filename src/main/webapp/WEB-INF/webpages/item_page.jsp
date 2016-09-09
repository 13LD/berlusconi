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
    <link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css" media="screen,projection"/>


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


    <div class="row z-depth-1">
        <div class="carousel carousel-slider">
            <a class="carousel-item" href="#one!"><img src="http://lorempixel.com/800/400/food/1"></a>
            <a class="carousel-item" href="#two!"><img src="http://lorempixel.com/800/400/food/2"></a>
            <a class="carousel-item" href="#three!"><img src="http://lorempixel.com/800/400/food/3"></a>
            <a class="carousel-item" href="#four!"><img src="http://lorempixel.com/800/400/food/4"></a>
        </div>
    </div>

    <div class="row">

        <div class="col m7 s12 push-m5">
            <h3>Наименование товара</h3>

                <span>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias aliquid eligendi esse expedita illo inventore ipsa labore laborum magni natus nihil odio odit quibusdam quo sunt suscipit vel, voluptatibus voluptatum?
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. A, accusantium cum cumque dignissimos dolorem, id impedit laudantium magni numquam provident quaerat quasi quidem quod recusandae repellendus saepe suscipit vitae! Debitis.
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias, aperiam, consectetur ducimus earum et exercitationem expedita explicabo fugit iste magni, molestiae non suscipit totam ullam unde ut veritatis vero voluptatem.
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consectetur deserunt, ducimus eaque et expedita illo labore laboriosam odio placeat quod, ratione suscipit veritatis. Beatae dolore porro voluptas voluptatem voluptatum.
                </span>
        </div>


        <div class="col m5 s12 pull-m7">

            <div class="row">

                <div class="chip right blue white-text"> Кухни</div>

            </div>

            <div class="row">
                <div class="col s12">
                    <img class="responsive-img materialboxed" src="http://lorempixel.com/800/400/food/1"/>
                </div>
            </div>

            <div class="row">
                <div class="col s12">
                    <img class="responsive-img materialboxed" src="http://lorempixel.com/800/400/food/1"/>
                </div>
            </div>

            <div class="row">
                <div class="col s12">
                    <img class="responsive-img materialboxed" src="http://lorempixel.com/800/400/food/1"/>
                </div>
            </div>

        </div>

    </div>

    <div class="row">
        <h5 class="subheader center">Посмотреть еще</h5>
    </div>

    <div class="row">

        <div class="col s12 m4">
            <div class="card z-depth-1 ">
                <img class="activator responsive-img"
                     src="https://unsplash.it/1024/768?random">
                <div class="card-content">
                    <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet delectus dignissimos, dolores eius excepturi</span>
                </div>
            </div>
        </div>

        <div class="col s12 m4">
            <div class="card z-depth-1 ">
                <img class="activator responsive-img"
                     src="https://unsplash.it/1024/768?random">
                <div class="card-content">
                    <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet delectus dignissimos, dolores eius excepturi</span>
                </div>
            </div>
        </div>

        <div class="col s12 m4">
            <div class="card z-depth-1 ">
                <img class="activator responsive-img"
                     src="https://unsplash.it/1024/768?random">
                <div class="card-content">
                    <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet delectus dignissimos, dolores eius excepturi</span>
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
<script type="text/javascript" src="/resources/js/materialize.min.js"></script>
<script type="text/javascript" src="/resources/js/indexpage.js"></script>
<script>
    $('.carousel.carousel-slider').carousel({full_width: true});

</script>

</body>
</html>
