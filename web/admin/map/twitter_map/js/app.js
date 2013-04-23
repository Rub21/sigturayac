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