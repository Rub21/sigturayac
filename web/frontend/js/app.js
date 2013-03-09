var map_id='examples.map-4l7djmvo',
features=[],
interaction,
map = mapbox.map('map');   
var recursos_search = [];
map.addLayer(mapbox.layer().id(map_id));

mm_recurso(mm_hotel(mapData));//call the all funtions
map.centerzoom({
    lat: -13.16048,  
    lon: -74.22565
}, 15);
map.setZoomRange(0, 18);
function mapData(f) {
    features=f;
    //console.log(features);
    markerLayer = mapbox.markers.layer().features(features);  
    markerLayer.factory(function (m) {        
        var elem = mapbox.markers.simplestyle_factory(m);
        MM.addEvent(elem, 'click', function (e) {
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
    interaction.formatter(function (feature) {
        var o = '<h3 >' +feature.nombre +'</h3>'+
        '<p>'+ feature.descripcion.substring(0,200)+'...</p>'+
        '<div class="well-toltip">'+
        '<img style="height: 120px; width:120px;   margin-right: 3px;" src="'+feature.imagenes[0].url+'">' +
        '<img style="height: 120px; width:120px;" src="'+feature.imagenes[1].url+'">'+
        '</div>';
        var a_button='';
    var a =feature.clase.replace(/\s/g,"");

        if (a=='RecursoTurístico') {
               a_button='<a  role="button" class="btn"  href="#detail" onclick="call_detail_recurso(\''+feature.idproducto+'\')"> Más Detalle</a>';
        
        } else if(a=='Hotel') {
               a_button='<a  role="button" class="btn"  href="#detail" onclick="call_detail_hotel(\''+feature.idproducto+'\')"> Más Detalle</a>';
        
        }    
        return o+a_button;
    });
    $('#map').removeClass('loading');

    fill_search(features);
}


function newMarker() {
    if (window.location.hash == '#new') {
        $('#new').fadeIn('slow');
        window.location.hash = '';
        window.setTimeout(function() {
            $('#new').fadeOut('slow');
        }, 4000)
    }
}

function fill_search(f){
    _.each(f, function (value, key) {   
        var feature_search = {  
            title: f[key].nombre,
            categoria: f[key].clase
        };
        recursos_search.push(feature_search);   
    });
    console.log(recursos_search);
}


function buscarproducto(id){
    var producto;
    _.each(features, function (value, key) {   
       
        if(features[key].idproducto==id)
        {

            producto=features[key];
        

        }
    });
    return producto;

};












function call_sub_detail_recurso_video(){
    $('#backdrop_overdetail').fadeIn(200);
    $('#sub_detail').show(200);
    $('#close_overdetail').show(200);
    $('#sub_detail').html('<iframe width="640" height="360" src="http://www.youtube.com/embed/e97VrOhsczI?feature=player_detailpage" frameborder="0" allowfullscreen></iframe>');
}


// Document already
$(document).on('ready',function() {  
    /*$('a[href="#opendata"]').click(function (e) {
        e.preventDefault();
        $('#backdrop').fadeIn(200);
        $('#opendata').show(200);
        $('#close').show(200);
    });
    $('a[href="#howto"]').click(function (e) {
        e.preventDefault();
        $('#backdrop').fadeIn(200);
        $('#howto').show(200);
        $('#close').show(200);
    });*/
    $('#close').click(function (e) {
        e.preventDefault();
        $('#backdrop').fadeOut(200);
        $('#detail').hide(200);
        $('#detail').empty();
        //$('#howto').hide(200);
        $('#close').hide(200);
    });



    $('#close_overdetail').click(function (e) {
        e.preventDefault();
        $('#backdrop_overdetail').fadeOut(200);
        $('#sub_detail').hide(200);
        $('#sub_detail').empty();
        $('#close_overdetail').hide(200);
    });

    /***** slider */

    $('.quake-slider').quake({
        thumbnails: true,
        animationSpeed: 500,
        applyEffectsRandomly: true,
        navPlacement: 'inside',
        navAlwaysVisible: true,
        captionOpacity: '0.3',
        captionsSetup: [
        {
            "orientation": "top",
            "slides": [0, 1],
            "callback": captionAnimateCallback
        },
        {
            "orientation": "left",
            "slides": [2, 3],
            "callback": captionAnimationCallback1
        }
        ,
        {
            "orientation": "bottom",
            "slides": [4, 5],
            "callback": captionAnimateCallback
        }
        ,
        {
            "orientation": "right",
            "slides": [6, 7],
            "callback": captionAnimationCallback1
        }
        ]

    });

    function captionAnimateCallback(captionWrapper, captionContainer, orientation) {
        captionWrapper.css({
            left: '-990px'
        }).stop(true, true).animate({
            left: 0
        }, 500);
        captionContainer.css({
            left: '-990px'
        }).stop(true, true).animate({
            left: 0
        }, 500);
    }
    function captionAnimationCallback1(captionWrapper, captionContainer, orientation) {
        captionWrapper.css({
            top: '-330px'
        }).stop(true, true).animate({
            top: 0
        }, 500);
        captionContainer.css({
            top: '-330px'
        }).stop(true, true).animate({
            top: 0
        }, 500);
    }



    $('#search').betterAutocomplete('init',
        recursos_search,
        {
            cacheLimit: 128, 
            selectKeys: [13], 
            crossOrigin: true
        }, {
            /*processRemoteData: function(data) {
      if ($.type(data) == 'object' && $.isArray(data.geonames))
        return data.geonames;
      else
        return [];
    },*/
            themeResult: function(result) {
                output = '<h5>' + result.title + '</h5>';
                /*output += '<p>' + result.categoria +'</p>';*/
                return output;
            },
            select: function(result, $input) {
                $input.blur();
                $('#search').val(result.title);                
                markerLayer.filter(function (features) {
                    if (features.nombre === result.title) {
                        
                        map.ease.location({
                            lat: features.geometry.coordinates[1],
                            lon: features.geometry.coordinates[0]
                        }).zoom(18).optimal();

                        return true;

                    }
         
                });       
                //retarda por un momento y limpia la busqueda         
                window.setTimeout(function() {
                    $('#search').val(""); 
                }, 4000);

            },
            getGroup: function(result) {
                if ($.type(result.categoria) == 'string' && result.categoria.length)
                    return result.categoria;
            }
        });

/*navigatiosn midel content*/
/*
  $('#tj_container').gridnav({
      rows  : 3,
      type  : {
        mode    : 'sequpdown',    // use def | fade | seqfade | updown | sequpdown | showhide | disperse | rows
        speed   : 500,        // for fade, seqfade, updown, sequpdown, showhide, disperse, rows
        easing    : '',       // for fade, seqfade, updown, sequpdown, showhide, disperse, rows 
        factor    : 50,       // for seqfade, sequpdown, rows
        reverse   : false       // for sequpdown
          }
  });

*/











});





