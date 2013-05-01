<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%

    String usuario = (String) session.getAttribute("user");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
    }

%>


<html>
    <head>
        <title>Admin</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <link rel='stylesheet' href='css/style.css' />   
        <link rel='stylesheet' href='css/bootstrap.css' />
        <link href='css/mapbox.css' rel='stylesheet' />
    </head>
    <body>

        <div id='masthead'>
            <div class="navbar navbar-fixed-top">
                <div class="navbar-inner">
                    <div class="container-fluid">
                        <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <a href="#" class="brand">Administración de Puntos de Desechos</a>
                        <div class="nav-collapse">
                            <ul class="nav">
                                <li class="active"><a href="#">Inicio</a></li>
                                <li class="dropdown">
                                    <a href="#puntosregistrados">Puntos Registrados</a>
                                </li>
                                <li><a href="#puntosatendidos">Puntos Atendidos</a></li>

                            </ul>

                            <div class="pull-right">
                                Bienvenido : ${user}

                                <p><a href="${pageContext.request.contextPath}/SCerrarsesion">Cerrar Sesion</a></p>

                            </div>
                        </div><!-- /.nav-collapse -->
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">       

                <div class=" well span12">
                    <h3>Sitio de Administracion de Puntos de Desechos en el distrito de Pueblo Libre</h3>
                    <p></p>
                </div>


            </div>

        </div>


        <div id='backdrop'></div>
        <div class="total-container" id='puntosregistrados'>
            <%@ include file="puntosregistrados.jspf" %>
        </div>



        <!--Scripts-->		
        <script src='http://api.tiles.mapbox.com/mapbox.js/v0.6.6/mapbox.js'></script>
        <script src='http://code.jquery.com/jquery-1.8.2.js'></script>
        <script type="text/javascript" src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js"></script>
        <script src='js/underscore.min.js'></script>

        <script src='js/bootstrap.js'></script>  
        <script src='js/app.js' ></script>   
        <script src='js/form_validate.js' ></script>
    </body>
</html>
