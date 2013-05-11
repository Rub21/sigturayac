var map_id = 'examples.map-vyofok3q',

    markerLayer,
    features = [],
    features_summary,
    interaction,
    map = mapbox.map('map');

map.addLayer(mapbox.layer().id(map_id));

$.when(mm_twitter2(), mmg_docs2()).done(function() { //call first andd second
    $('.contributor').html('Desarrollado por: Rub21, <a herf="mailto:rub2106@gmail.com">rub2106@gmail.com</a>.');
}).then(function() {
    //console.log(data);
});

window.setTimeout(function() {
    //console.log(data)
    mapData(data);
}, 3000);

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
    interaction.formatter(function(feature) {
        var o = '<h5>' + feature.properties.hour + '</h5>' +
            '<p>' + feature.properties.description + '</p>' +
            '<div class="well">' +
            '<img style=\'height: 150px; width:220px;\' src=\'' + feature.properties.img + '\'> ' +
            '</div>' +
            '<p><strong> Usuario :</strong> ' + feature.properties.user + '</p>';

        var button = '<a  role="button" class="btn"  href="#popover" onclick="call_detail(' + feature.properties.id + ')"> Más Detalle</a>';
        o = o + button;
        return o;
    });
    $('#map').removeClass('loading');
};


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
};



//estadisticas..
/*var url = 'http://rub21.github.io/osm_bots/bots_java/build/web/user451693.json?callback=callback';

$.getJSON(url, {
    format: "json"
}).done(function(data) {
console.log(data);



});*/


/**
    mm_stadistic(stadistis);

    function mm_stadistic(file_user, callback) {

        var url = 'http://rub21.github.io/osm_bots/bots_java/build/web/user451693.json?callback=callback';
        //console.log(url);
        reqwest({
            url: url,
            type: 'jsonp',
            jsonpCallback: 'callback',
            success: response,
            error: response
        });

        function response(x) {
            return callback(x);

        };
    };

    google.load("visualization", "1", {
        packages: ["corechart"]
    });

    function stadistis(f) {

        var rowArray = [];
        for (var i = 0; i < f[0].editions.length; i++) {
            rowArray.push([f[0].editions[i].date, f[0].editions[i].num_obj_changes]);
        };

        drawChart();

        function drawChart() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Day');
            data.addColumn('number', 'Num de puntos registrados');
            data.addRows(rowArray);
            var chart = new google.visualization.AreaChart(document.getElementById('draw_stadistic'));

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
                    width: "98%",
                    height: "70%"
                },
                backgroundColor: 'transparent',
                colors: ['#659E51']
            };

            chart.draw(data, options);
        }
        $('.draw').addClass('well');
    };*/


    $(document).on('ready', function() {
        $('#layer').on('click', 'li', function(e) {
            var id = $(this).attr('id') + "";
            markerLayer.filter(function(features) {
                if (features.properties.from === id) {
                    return true;
                }
            });
        });
    });