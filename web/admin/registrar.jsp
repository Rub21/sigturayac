<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
    <head>
        <title>Registrar Recursos Turistico</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <link rel='stylesheet' href='css/style.css' />
        <link rel='stylesheet' href='css/style-h.css' />
        <link rel='stylesheet' href='css/bootstrap.css' />
        <link href='css/mapbox.css' rel='stylesheet' />
    </head>
    <body>
        <div id='masthead'>
            <div id='header' class='limiter'>
                <h1><a href='/'><span class='brand'>Seg</span>Ayac <span class='subtitle'>Formulario para el Registro de Recurso Turistico</span></a></h1>
            </div>

            <div class="navbar navbar-fixed-top">
                <div class="navbar-inner">
                    <div class="container-fluid">
                        <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <a href="#" class="brand">Turismo Ayacucho</a>
                        <div class="nav-collapse">
                            <ul class="nav">
                                <li class="active"><a href="#">Inicio</a></li>
                                <li class="dropdown">
                                    <a href="#recurso">Recursos Turistico</a>
                                </li>

                                <li class="dropdown">
                                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">Planta Turistica<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#hotel">Hotel</a></li>
                                        <li><a href="#">Restaurant</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Medios de Transporte</a></li>
                                <li><a href="#">Servicios Coplementarios</a></li>


                            </ul>

                            <div class="pull-right">
                                Usuarios:Ruben21
                            </div>
                        </div><!-- /.nav-collapse -->
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">       

                <div class=" well span12">
                    <h1>Sitio de Administracion de Producto Turistico</h1>
                    Bienvenido a la sitio de administracion de Producto turistico de la Region de Ayacucho.
                </div>

            </div>

        </div>
        <div id='backdrop'></div>
        <div class="total-container" id='recurso'>
            <%@ include file="recurso.jspf" %>
        </div>
        <div class="total-container" id='mancult'>         
        </div>

        <div class="total-container" id='hotel'>            
            <%@ include file="hotel.jspf" %>            
        </div>

        <!--Scripts-->		
        <script src='http://api.tiles.mapbox.com/mapbox.js/v0.6.6/mapbox.js'></script>
        <script src='http://code.jquery.com/jquery-1.8.2.js'></script>
        <script type="text/javascript" src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js"></script>
        <script src='js/underscore.min.js'></script>
        <script src='js/bootstrap.js'></script>        
        <script src='js/app_map.js' ></script>
        <script src='js/app.js' ></script>
        <script src='js/form_recurso.js' ></script>
        <script src='js/form_hotel.js' ></script>
        <script src='js/form_validate.js' ></script>
    </body>
</html>
