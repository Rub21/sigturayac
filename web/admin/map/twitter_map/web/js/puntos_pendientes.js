var features = [];
function map_pendientes() {



    $('#map_pen').empty();
    var map = mapbox.map('map_pen');
    map.addLayer(mapbox.layer().id('examples.map-vyofok3q'));
    map.centerzoom({
        lat: -13.16048,
        lon: -74.22565
    }, 15);
    map.setZoomRange(3, 18);

    map.ui.zoomer.add();
    map.ui.hash.add();
    map.ui.attribution.add().content('<a href="http://www.openstreetmap.org/copyright">(c) OpenStreetMap contributors</a>');

    map.ease.location({
        lat: -13.1606,
        lon: -74.2
    }).zoom(16).optimal();

    mm_puntos_p(mapData);


    function mapData(f) {
        features = f;
        markerLayer = mapbox.markers.layer().features(features);
        markerLayer.factory(function(m) {
            var elem = mapbox.markers.simplestyle_factory(m);
            MM.addEvent(elem, 'click', function(e) {
                map.ease.location({
                    lat: m.geometry.coordinates[1] + reduce,
                    lon: m.geometry.coordinates[0]

                }).zoom(map.zoom()).optimal();
            });
            return elem;
        });

        interaction = mapbox.markers.interaction(markerLayer);
        map.addLayer(markerLayer);
        interaction.formatter(function(feature) {
            var o = '<h5 class="popover-geo-title">' + feature.fecha + '</h5>' +
                    '<p>' + feature.descripcion + '</p>' +
                    '<div >' +
                    '<img style="height: 120px; width:120px;   margin-right: 25px;" src="' + feature.url_img + '">' +
                    '</div>';
            var a_button = '<a  role="button" class="btn"  href="#detail" onclick="call_detail(\'' + feature.idpunto + '\')"> Más Detalle</a>';
            return o + a_button;
        });

    }


}

function menu_pendientes() {
    var monthNames = [
        'Enero',
        'Febrero',
        'Marzo',
        'Abril',
        'Mayo',
        'Junio',
        'Julio',
        'Agosto',
        'Setiembre',
        'Octubre',
        'Noviembre',
        'Diciembre'
    ];
    mm_date(menu);
    function menu(f) {
        $('#accordion_moth').empty();

        for (i = f.length - 1; i >= 0; i--) {

            if (f[i].length > 0) {
                var m = '';
                if (i <= 9) {
                    m = '0' + (i + 1);
                } else {
                    m = i + '';
                }

                var html_month = '<div class="accordion-group">' +
                        '<div class="accordion-heading">' +
                        '<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion_moth" href="#collapse' + m + '">' +
                        monthNames[i] + ' del 2013' +
                        '</a>' +
                        '</div>' +
                        '<div id="collapse' + m + '" class="accordion-body collapse">' +
                        '<ul id="month' + m + '" class="dropdown-menu accordion-inner">' +
                        '</ul>' +
                        '</div>' +
                        '</div>';

                $('#accordion_moth').append(html_month);

                var li = '';
                for (j = 0; j < f[i].length; j++) {

                    var d = f[i][j];
                    if (d <= 9) {
                        d = '0' + d;
                    }



                    li += '<li><a class="select_pentiente" id="' + d + '/' + m + '/2013" href="#">' + d + '/' + m + '/2013</a></li>';
                }
                $('#month' + m).append(li);



            }
        }

        maneja_eventos();
    }

}
;

function  maneja_eventos() {
    //clieck for filter
    $('.select_pentiente').click(function() {
        var id = $(this).attr('id');
        markerLayer.filter(function(features) {
            //console.log(features.fecha.replace(/\s/g, "") + ' - ' + id);
            if (features.fecha.replace(/\s/g, "") === id) {
                return true;
            }
        });
    });
}


function call_detail(id) {
    console.log(id);
    $('.click').trigger('click');
    $('#popover').css({
        'width': '820px',
        'margin-top': '-5%',
        'margin-left': function() {
            return -($(this).width() / 2);
        }
    });
    var f = _.find(features, function(feature) {
        console.log(feature.idpunto);
        return feature.idpunto === id
    });
    console.log(f);
    $('.hora').text(f.hora);
    $('.fecha').text(f.fecha);
    $('.description').text(f.descripcion);
    $('.img').attr('src', f.url_img);
    $('.usuario').text(f.usuario);
    $('#id_punto').val(f.idpunto);

}
;


