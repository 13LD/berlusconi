<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" media="screen,projection"/>


    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

</head>
<body>


<div class="container">
    <div class="row center">
        <div class="col s12">
            <p class="flow-text">Login into admin panel</p>
        </div>
    </div>

    <div class="row">

        <form:form action="/login" method="post">
            <div class="row ">
                <div class="col m6 s12 offset-m3">
                    <label> User Name </label>
                    <input class="validate" type="text" name="username">
                </div>
            </div>
            <div class="row">
                <div class="col m6 s12 offset-m3">
                    <label> Password </label>
                    <input type="password" name="password"/>
                </div>
            </div>
            <div class="row center">
                <div class="col m12 s12"><input class="btn" type="submit" value="Sign In"/></div>
            </div>
        </form:form>


    </div>
</div>


</body>
</html>