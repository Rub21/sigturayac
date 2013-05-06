function mm_puntos(callback) {
    if (typeof reqwest === 'undefined') {
        throw 'CSV: reqwest required for';
    }
    var url = 'http://localhost:8080/admin_twiter_map/SListarPuntos?callback=callback';
    reqwest({
        url: url,
        type: 'jsonp',
        jsonpCallback: 'callback',
        success: response,
        error: response
    });

    function response(x) {
console.log(x)
        var features = [],
                latfield = '',
                lonfield = '';

        for (var i = 0; i < x.length; i++) {
            //Properties
            x[i]['properties'] = {};
            x[i].properties['marker-size'] = 'small';
            if(x[i].estado){
               x[i].properties['marker-color'] = '#E55C3C'; 
            }else{
                x[i].properties['marker-color'] = '#659E51';
            }
            
            features.push(x[i]);
        }
        //console.log(features);
        return callback(features);
    }
};


function mm_puntos_pen(callback) {
    if (typeof reqwest === 'undefined') {
        throw 'CSV: reqwest required for';
    }
    var url = 'http://localhost:8080/admin_twiter_map/SListarPuntosPendientes?callback=callback';
    reqwest({
        url: url,
        type: 'jsonp',
        jsonpCallback: 'callback',
        success: response,
        error: response
    });

    function response(x) {

        var features = [],
                latfield = '',
                lonfield = '';

        for (var i = 0; i < x.length; i++) {
            //Properties
            x[i]['properties'] = {};
            x[i].properties['marker-size'] = 'small';
            x[i].properties['marker-color'] = '#659E51';
            features.push(x[i]);
        }
        //console.log(features);
        return callback(features);
    }
};


function mm_date(callback) {
    var url = 'http://localhost:8080/admin_twiter_map/SListarDate?callback=callback';
    reqwest({
        url: url,
        type: 'jsonp',
        jsonpCallback: 'callback',
        success: response,
        error: response
    });
    function response(x) {
        return callback(x);
    }
}
;


function mm_stadistic(callback) {

    var url = 'http://localhost:8080/admin_twiter_map/SListarEstadisticas?callback=callback';
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
    }
    ;
}
;


