var map_id = 'examples.map-vyofok3q',
        markerLayer,
        features = [],
        features_summary,
        interaction,
        map = mapbox.map('map');

map.addLayer(mapbox.layer().id(map_id));

//mm_puntos_pen(mapData);
mm_puntos(mapData);
menu_pendientes();



map.centerzoom({
    lat: -13.16048,
    lon: -74.22565
}, 15);

map.setZoomRange(0, 18);

function mapData(f) {
    features = f;
    markerLayer = mapbox.markers.layer().features(features);
    markerLayer.factory(function(m) {
        var elem = mapbox.markers.simplestyle_factory(m);
        MM.addEvent(elem, 'click', function(e) {
            map.ease.location({
                lat: m.geometry.coordinates[1],
                lon: m.geometry.coordinates[0]
            }).zoom(map.zoom()).optimal();
        });
        return elem;
    });

    interaction = mapbox.markers.interaction(markerLayer);
    map.interaction.auto();
    map.addLayer(markerLayer);
    map.ui.zoomer.add();
    map.ui.zoombox.add();
    map.ui.hash.add();

    interaction = mapbox.markers.interaction(markerLayer);
    map.addLayer(markerLayer);
    interaction.formatter(function(feature) {
        var o = '<h5 class="popover-geo-title">' + feature.fecha + '</h5>' +
                '<p>' + feature.descripcion + '</p>' +
                '<div >' +
                '<img style="height: 120px; width:auto;   margin-right: 25px;" src="' + feature.url_img + '">' +
                '</div>';
        var a_button = '<a  role="button" class="btn"  href="#detail" onclick="call_detail(\'' + feature.idpunto + '\')"> Más Detalle</a>';
        return o + a_button;
    });

    $('#map').removeClass('loading');
}
;


function call_detail(id) {
    $('.click').trigger('click');
    $('#popover').css({
        'width': '820px',
        'margin-top': '-5%',
        'margin-left': function() {
            return -($(this).width() / 2);
        }
    });
    var f = _.find(features, function(feature) {
        console.log(feature.properties.id);
        return feature.properties.id === id
    });
    // console.log(f);
    $('.date').text(f.properties.hour);
    $('.description').text(f.properties.description);
    $('.img').attr('src', f.properties.img);
    $('.usuario').text(f.properties.user);
}
;


google.load("visualization", "1", {
    packages: ["corechart"]
});


function stadistis_p_pen(f) {
    console.log(f);
    var rowArray = [];
    for (var i = 0; i < f.length; i++) {
        rowArray.push([f[i].fecha, f[i].p_pen]);
    } ;
    console.log(rowArray);
    drawChart();

    function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Day');
        data.addColumn('number', 'Num de puntos registrados');
        data.addRows(rowArray);
        var chart = new google.visualization.AreaChart(document.getElementById('draw_p_pen'));

        var options = {
            height: 320,
            title: 'Numero de Puntos de Deschos registrados',
            hAxis: {
                title: 'Day',
                titleTextStyle: {
                    color: '#404040'
                }
            },
            vAxis: {
                title: 'Num de Puntos',
                titleTextStyle: {
                    color: '#404040'
                }
            },
            legend: 'none',
            chartArea: {
                left: 25,
                top: 20,
                width: "95%",
                height: "70%"
            },
            backgroundColor: 'transparent',
            colors: ['#E55C3C']
        };

        chart.draw(data, options);
    }
    $('.draw').addClass('well');
    
    stadistis_p_ate(f);///call puntos atendidos
};



function stadistis_p_ate(f) {
    console.log(f);
    var rowArray = [];
    for (var i = 0; i < f.length; i++) {
        rowArray.push([f[i].fecha, f[i].p_ate]);
    } ;
    console.log(rowArray);
    drawChart();

    function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Day');
        data.addColumn('number', 'Num de puntos registrados');
        data.addRows(rowArray);
        var chart = new google.visualization.AreaChart(document.getElementById('draw_p_ate'));

        var options = {
            height: 320,
            title: 'Numero de Puntos de Deschos registrados',
            hAxis: {
                title: 'Day',
                titleTextStyle: {
                    color: '#404040'
                }
            },
            vAxis: {
                title: 'Num de Puntos',
                titleTextStyle: {
                    color: '#404040'
                }
            },
            legend: 'none',
            chartArea: {
                left: 25,
                top: 20,
                width: "95%",
                height: "70%"
            },
            backgroundColor: 'transparent',
            colors: ['#659E51']
        };

        chart.draw(data, options);
    }
    $('.draw').addClass('well');
};


$(document).on('ready', function() {
mm_stadistic(stadistis_p_pen);

    $('#layer').on('click', 'li', function(e) {
        var id = $(this).attr('id') + "";
        markerLayer.filter(function(features) {
            if (features.properties.from === id) {
                return true;
            }
        });
    });

    $('.select_pentiente').click(function() {
        var id = $(this).attr('id');
        markerLayer.filter(function(features) {
            //console.log(features.fecha.replace(/\s/g, "") + ' - ' + id);
            if (features.fecha.replace(/\s/g, "") === id) {
                return true;
            }
        });
    });
});