function map() {
    var map = mapbox.map('map');
    map.addLayer(mapbox.layer().id('examples.map-vyofok3q'));

    map.setZoomRange(3, 18);
    map.centerzoom({
        lat: -13.16048,
        lon: -74.22565
    }, 15);
    map.ui.zoomer.add();
    map.ui.zoombox.add();
    map.ui.hash.add();
    map.ui.attribution.add().content('<a href="http://www.openstreetmap.org/copyright">(c) OpenStreetMap contributors</a>');

    map.ease.location({
        lat: -13.1606,
        lon: -74.2
    }).zoom(16).optimal();
}







$(function() {
map();
    $('a[href="#puntosregistrados"]').click(function(e) {
        e.preventDefault();
      
        $('#backdrop').fadeIn(300);
        $('#puntosregistrados').show(300);

          

    });
    $('a[href="#close"]').click(function(e) {
        e.preventDefault();
        $('#backdrop').fadeOut(200);
        $('#recurso').hide(200);
        $('#hotel').hide(200);
        $('#restaurant').hide(200);
        $('#transporte').hide(200);
        $('#complementario').hide(200);
    });

});


