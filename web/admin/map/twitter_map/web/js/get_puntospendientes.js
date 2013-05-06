function mm_puntos_p(callback) {
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
            x[i].properties['marker-color'] = '#000000';            
            features.push(x[i]); 
        }
        //console.log(features);
        return callback(features);
    }
}