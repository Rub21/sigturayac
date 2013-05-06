<%-- 
    Document   : registrar
    Created on : May 6, 2013, 5:28:11 AM
    Author     : ruben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset=utf-8 />

        <link rel="stylesheet" href="http://leafletjs.com/dist/leaflet.css" />
        <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
        <!--[if lte IE 8]>
        <link rel="stylesheet" href="css/leaflet.ie.css" />
        <![endif]-->
        <link rel="stylesheet" href="reg/css/style.css" />
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <link rel="stylesheet" href="reg/js/jquery.ptTimeSelect.css" />

    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a href="#" class="brand">Registre un punto Crítico de Basura</a>
                    <div class="nav-collapse"></div>
                </div>
                <!-- /.nav-collapse -->
            </div>
        </div>

        <div id="contentform">
            <div id="form" method="post"  action="<%=request.getContextPath()%>/SRegistrarPunto" enctype="multipart/form-data">		

                <form method="post"  class="content well span6"  >
                    <div class="row">
                        <div class="span4">Usuario</div>
                        <div class="span8"><input type="text" name="usuario" value=""  id="usuario" style="width:400px">
                        </div>
                    </div>
                    <div class="row">
                        <div class="span4">Fecha</div>
                        <div class="span8"> <input type="text" name="fecha" value=""  id="fecha" style="width:400px" >
                        </div>
                    </div>

                    <div class="row">
                        <div class="span4">Hora</div>
                        <div class="span8"> <input type="text" name="hora" value=""  id="hora" style="width:400px">
                        </div>
                    </div>

                    <div class="row">
                        <div class="span4">Descripción</div>
                        <div class="span8">
                            <textarea name="descirpcion" rows="8" cols="75"  id="descirpcion" style="width:400px"></textarea>
                        </div>
                    </div>

                    <div class="row">
                        <div class="span4">Latitud</div>
                        <div class="span8">
                            <input type="text" name="latitud" value=""  id="latitud" placeholder="click en el Mapa" style="width:400px">
                        </div>
                        <div class="span4">Longitud</div>
                        <div class="span8">
                            <input type="text" name="longitud"  id="longitud" placeholder="click en el Mapa" style="width:400px">
                        </div>
                    </div>

                    <div class="row">
                        <div class="span4">Imagen</div>
                        <div class="span8">
                            <input type="file" name="imagen" value="bas.jpg"  id="imagen"/>
                        </div>
                    </div>

                    <br>
                    <button type="submit" class="btn btn-primary" id="button">  Registrar</button>
                    <button type="reset" class="btn">Cancelar</button>



                </form>
            </div>

            <!--mapa-->
            <div id="map"></div>

            <div class="left">
                <a id="geojsonLayer"   href="#" ></a>
            </div>

        </div>

        <!--Scripts-->
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script src="reg/js/jquery.ptTimeSelect.js"></script>
        <script src="reg/js/jquery.validate.js"></script>
        <script src="http://leafletjs.com/dist/leaflet.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>      
        <script type="text/javascript" src="reg/js/app.js"></script>
        <script type="text/javascript" src="reg/js/form.js"></script>
    </body>

</html>
