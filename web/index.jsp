<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Incidentes Ayacucho</title>
    <link type='text/css' href='frontend/css/mapbox.css' rel='stylesheet' />
    <link rel='stylesheet' href='frontend/css/reset.css' type='text/css'  />
    <link  type='text/css' href='frontend/css/style.css' rel='stylesheet' />
    <link  type='text/css' href='frontend/css/table.css' rel='stylesheet' />                                                                   
  </head>
  <body>
    <div id='masthead'>
      <div id='header'>
          <h1><span>TUR</span>AYACUCHO</h1>
          <h2>Conoce Ayacucho...</h2>
      </div>
     <!-- block for menu by type incident -->
      <div align="center" id="menu_type_incident" >
        <ul id="ul_menu_type_incident">            
            <li><a href='#' class='active' id='donde_ir'>Donde ir</a></li>
            <li><a id="donde_dormir" name="1" href="#">Donde Dormir</a></li>
            <li><a id="donde_comer" name="2" href="#">Donde Comer</a></li>
            <li><a id="como_viajar" name="3" href="#">Como Viajar</a></li>
            <li><a id="donde_comprar" name="4" href="#">Donde Comparar</a></li>
            <li><a id="Otros" name="6" href="#">Otros</a></li>
        </ul>
      </div>
    </div>
      
      
      
      
    <!-- block map -->
    <div id="map" class="loading"></div>
     <!-- block for arrow under  the map -->
    <div align="center" id="arrow_show_block"><a href="#">X</a></div>
    <div id="indicate_menu"><p>Todos los incidentes registrados</p></div>
    <!-- block menu by month -->
    <div align="center" id="menu_month" >
      <ul id="ul_menu_month">
        <li>
          <a href='#' class='active' id='all_incident_month'>Todos</a>
        </li>
      </ul>
    </div>
    <!-- block midle content  -->
    <div align="center" id="middle_content">
      <a id="id_close" href="#">X</a> 
      <div class='statistic_by_month' id="all_incident_type_statistic"></div>  
      <div id="block_text_desription">
        <h3>Incidentes Delictivos</h3>
        <p> Actualmente en la ciudad de  Ayacucho los incidentes delictivos son  una actividad cotidiana,como sucede en cualquier otro lugar, la  Sub Gerencia de Seguridad Ciudadana encargado de la seguridad en la  ciudad de Ayacucho pone a disposición sus datos, para el conocimiento de la ciudadania, con finalidad de  prevenir  incidentes futuros en  ciertos lugares de la ciudad.</p>
        <p>El mapa de arriba muestra  los puntos donde ocurrieron los incidentes delictivos, estos datos son recolectados, ingresados  y publicados por la Sub Gerencia  de Seguridad Ciudadana de la Municipalidad Provincial de Humanga con la  iniciativa de Datos Abiertos.
        </p>
      </div>
      <div id="block_statistic" class="loading">
        <div id="title_statistic">Porcentaje total de incidentes </div>
        <div id="img_total_percentage"></div>        
        <div id="num-incident"></div>
      </div>

      <!--block downloads --> 
      <div id="block_downloads">
        <div id='downloads' class='clearfix'>
          <div class='limiter'>
              <div class='col dl'>
                <div class='dl-data'>.CSV</div>
                  <div>
                    <a id="download_csv" title='Descarga de Datos' class='button'>Descargar Datos</a>
                  </div>
                  <p class='details'>Descargue el documento .csv que contiene todos los datos visibles en este sitio para su uso en un programa de hoja de cálculo o <a href="http://mapbox.com/tilemill">TileMill</a>.
                  </p>
              </div>
            <div class='col dl'>
              <div class='dl-map'>JSON</div>
                <div>
                  <a id="download_josn" title='API Feed' class='button'>Datos API Feed</a>
                </div>
                <p class='details'>Accede a  los datos visualizados en formato  JSON API para el uso en programación  de una aplicación web.</p>
            </div>
          </div>
        </div>
      </div>          
    </div>
<!-- block for superposition  -->
    <div id='backdrop'></div>
<!-- block footer  -->
    <div id="footer">
      <div class="center">
        <p><a class="button" href='#opendata'>Datos Abiertos</a></p>
        <p><a  class="button"  href='#howto'>Como desarrollar</a></p>
        <div class="separator">--</div>
        <span>Desarrollado con <a href='http://tilemill.com' title='TileMill'> TileMill</a></span>
        <a href="http://mapbox.com/" target='_blank'><img src="images/mapbox.png"></a>
      </div>
    </div>

  <div id='opendata' class='popover'>
    <h1>Datos Abiertos</h1>
    <p>Mediante la presente  aplicación "SEGAYAC" se viene abriendo  datos  con respectos  a los incidentes delictivos,  registrados   desde septiembre del 2012 a la actualidad, por la Municipalidad provincial de Huamanga, Los incidentes delictivos registrados han sido clasificados en: Robo, Intento de Robo, Agresión, Accidentes, Violencia Familiar, Otros, los cuales son los que de manera frecuente suceden en la ciudad.
    </p>
    <p>La municipalidad Provincial de Humanga es un institución publica que se encuentra en el proceso de adoptar el nuevo paradigma  Datos Abiertos, esta institución  cuenta con una gran cantidad de datos,  que ya anteriormente  han sido otorgados  para su publicación de forma abierta, es el caso de planos catastrales que fueron publicados en <a href="http://www.openstreetmap.org/?lat=-13.16078&lon=-74.22367&zoom=16&layers=M">OpenStreetMap</a>  en Octubre del 2011. por algunos usuarios activos en esta ciudad.
    </p>
    <p>La Municipalidad Provincial de Huamanga, esta en el proceso de desarrollo de su portal de Datos Abiertos, que en próximos meses sera presentado a la ciudadanía. Para mas información en: <a href="http://datos.munihuamanga.gob.pe/">datos.munihuamanga.gob.pe</a>
    </p>
  </div>

  <div id='howto' class='popover'>
    <h1>Como Desarrollar</h1>
    <p>La presente aplicación fue desarrollado utilizando datos de <a href="http://www.openstreetmap.org/?lat=-13.16078&lon=-74.22367&zoom=16&layers=M">OpenStreetMap</a>, estos datos fueron procesados con ImpOSM y PostGIS, seguidamente  para el diseño del mapa  se ha utilizado   TileMill con OSM-bright stylesheets, los cuales nos permite empezar en seguida con un mapa hermoso, con un combinación de colores personalizados y limpios  que permitirá  complementar cualquier tipo de información sobrepuestos en el mapa.
    </p>
    <p>Para el almacenamiento  de datos se ha utilizado Google spreadsheet API, que permite acceder a una  spreadsheets publico  a traves de  un jsonp feed. Seguidamente estos datos son recuperados  mediante una <a href="https://github.com/mapbox/mapbox.js/blob/master/extensions/mapbox.converters.googledocs.js, ">extencion</a> de  <a href="http://mapbox.com/mapbox.js/">mapbox.js</a> 
    </p>
    <p>Los marcadores  sobrepuestos en el mapa fueron desarrollados mediante  <a href="http://mapbox.com/mapbox.js/">mapbox.js</a> 
    </p>
    <p>
      <span>Se puede encontrar mayor información en:</span>
      <br>
      <span>
      <a href="http://developmentseed.org/blog/2012/sept/13/mapping-dynamic-data-google-spreadsheet/">
      Mapping Dynamic Data Directly from a Google Spreadsheet</a> 
      </span>
      <br>
      <span>
        <a href="http://mapbox.com/blog/2012-09-05-mapping-crowdsourced-locations-google-docs/">
        Mapping Crowdsourced Locations with MapBox and Google Docs</a>
      </span>
    </p>
  </div>
  <a id='close' href='#close'>✕</a>
  <!-- scripts-->
  <script src='http://api.tiles.mapbox.com/mapbox.js/v0.6.6/mapbox.js'></script>
  <script src="frontend/js/jquery.min.js"></script>
  <script src="frontend/js/underscore-min.js"></script>
  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
  <script src="frontend/js/app_rec.js"></script>
  <script src="frontend/js/app.js"></script>    
  <!-- end scripts--> 
  </body>
</html>