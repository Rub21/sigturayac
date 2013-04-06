function draw_map(id_div, rec) {
    console.log(rec);
    var map_id = 'examples.map-dg7cqh4z',
        features = [],
        interaction,
        map = mapbox.map(id_div);
    map.addLayer(mapbox.layer().id(map_id));
    map.centerzoom({
        lat: rec.geometry.latitud,
        lon: rec.geometry.longitud
    }, 15);

    map.setZoomRange(0, 18);


    mm_hotel2(mapServicioAdicional);

    function mapServicioAdicional(f) {
        features = f;
        markerLayer = mapbox.markers.layer().features(features);
        markerLayer.factory(function(m) {
            var elem = simplestyle_factory_rub(m);
            MM.addEvent(elem, 'click', function(e) {
                map.ease.location({
                    lat: m.geometry.coordinates[1],
                    lon: m.geometry.coordinates[0]
                }).zoom(map.zoom()).optimal();
            });
            return elem;
        });

        interaction = mapbox.markers.interaction(markerLayer);
        map.addLayer(markerLayer);
        map.ui.zoomer.add();
        map.ui.zoombox.add();
        map.ui.hash.add();
        interaction.formatter(function(feature) {
            var o = '<h3 class="popover-geo-title">' + feature.nombre + '</h3>' +
                '<p>' + feature.descripcion.substring(0, 100) + '...</p>' +
                '<div class="well-toltip">' +
                '<img style="height: 120px; width:120px;   margin-right: 3px;" src="' + feature.imagenes[0].url + '">' +
                '<img style="height: 120px; width:120px;" src="' + feature.imagenes[1].url + '">' +
                '</div>';
            var a_button = '';
            var a = feature.clase.replace(/\s/g, "");

            a_button = '<a  role="button" class="btn"  href="#detail" onclick="call_detail_hotel(\'' + feature.idproducto + '\')"> Más Detalle</a>';

            return o + a_button;
        });

        //$('#map').removeClass('loading');

        function newMarker() {
            if (window.location.hash == '#new') {
                $('#new').fadeIn('slow');
                window.location.hash = '';
                window.setTimeout(function() {
                    $('#new').fadeOut('slow');
                }, 4000)
            }
        }


    }

};