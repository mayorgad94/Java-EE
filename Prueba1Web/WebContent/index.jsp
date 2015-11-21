<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
    <title> ALERTA MOVIL</title>
    <meta name="description" content="">
    <meta name=",FRANCISCO ,FELIPE ,PATRICIO,EDGARDO" content="">

     
    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <!-- Custom styles-->
    <link href="css/cover.css" rel="stylesheet">
    <link href="css/style.css"  rel="stylesheet" type="text/css" /> 
</head>
 
<style>
</style>
 
<body>
    <div class="site-wrapper">
 
      <div class="site-wrapper-inner">
 
        <div class="cover-container">
 
            <div class="masthead clearfix">   
                <div class="inner">
                  <h1 class="masthead-brand">ALERTA MOVIL</h1>
                  <nav>
                    <ul class="nav masthead-nav">
                      <li class="active"><a href="index.php">Inicio</a></li>
                      <li><a href="contacto.html">Contacto</a></li>
                    </ul>
                  </nav>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="login">
                            <header  class="tabla">
                                <form class="form-signin" action="Servlet" method="POST">
                                    <center>
                                        <strong><h1 class="form-signin-heading">REGISTRATE!!!!</h2></strong><br>
                                        <input type="text" id="ingresoId" name="id" class="form-control" placeholder="ID jugador" required autofocus><br>
                                        <input type="password" id="ingresoPassword" name="pass" class="form-control" placeholder="Contraseña" required autofocus>
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox" value="recuerdame"> Recuerdame
                                          </label>
                                        </div>
                                        <button class="btn btn-lg btn-default" type="submit">Ingresar</button><br><br>
                                    </center>
                                </form>
                            </header>
                        </div>
                    </div>
                </div>
 
                <?php
                if (isset($_SESSION))
                     session_destroy();
                ?>
                <br>
                <div class="mastfoot">
                    <div class="inner">
                        <p>Sitio desarrollado por:<a href="https://twitter.com/FrancoVP"> Franco Valerio</a> - Leandro Mondaca - Diego Mayorga</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
 
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>