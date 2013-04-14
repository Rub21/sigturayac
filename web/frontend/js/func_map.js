function draw_map(id_div, rec) {
    // console.log(rec);
    var map_id = 'examples.map-dg7cqh4z',
        features = [],
        interaction,
        map = mapbox.map(id_div, null, null, [
        easey_handlers.DoubleClickHandler(),
        easey_handlers.DragHandler(),
        easey_handlers.TouchHandler()]);



    map.addLayer(mapbox.layer().id(map_id));
    map.centerzoom({
        lat: rec.geometry.latitud,
        lon: rec.geometry.longitud
    }, 15);

    map.setZoomRange(0, 18);


    //Seleccion de Servicios Complementarios
    for (var i = 0; i < features_data.length; i++) {

        var clase = features_data[i].clase.replace(/\s/g, "");

        if (clase === 'Hotel') {

            features.push(features_data[i]);

        } else if (clase === 'Restaurant') {

            features.push(features_data[i]);

        } else if (clase === 'Transporte') {

            features.push(features_data[i]);

        } else if (clase === 'Complementario') {

            features.push(features_data[i]);
        }

    };

    mapServicioAdicional(features);

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
    };


    /*****************************************
initializer events
******************************************/

    $('a[href="#hotel"]').click(function(e) {
        e.preventDefault();
        scroll_to = document.getElementById('servicios');        
        scroll_to.scrollIntoView();
        markerLayer.filter(function(features) {
            var clase = features.clase.replace(/\s/g, "");
            if (clase === 'Hotel') {
                return true;
            }
        });

        $('#select_hotel').addClass('active');
    });

    $('a[href="#restaurant"]').click(function(e) {
        e.preventDefault();
        scroll_to = document.getElementById('servicios');
        scroll_to.scrollIntoView();
        markerLayer.filter(function(features) {
            var clase = features.clase.replace(/\s/g, "");
            if (clase === 'Restaurant') {
                return true;
            }
        });
    });

    $('a[href="#transporte"]').click(function(e) {
        e.preventDefault();
        scroll_to = document.getElementById('servicios');
        scroll_to.scrollIntoView();
        markerLayer.filter(function(features) {
            var clase = features.clase.replace(/\s/g, "");
            if (clase === 'Transporte') {
                return true;
            }
        });
    });

    $('a[href="#complementario"]').click(function(e) {
        e.preventDefault();
        scroll_to = document.getElementById('servicios');
        scroll_to.scrollIntoView();
        markerLayer.filter(function(features) {
            var clase = features.clase.replace(/\s/g, "");
            if (clase === 'Complementario') {
                return true;
            }
        });
    });

    $('a[href="#todos"]').click(function(e) {
        e.preventDefault();
        markerLayer.filter(function(features) {
            return true;
        });
    });



};