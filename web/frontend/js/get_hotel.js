//features_data=global data
//dir= global data
/*
function mm_hotel() {
    if (typeof reqwest === 'undefined') {
        throw 'CSV: reqwest required for mm_recurso';
    }
    var url = 'http://localhost:8080/sigturayac/SListarHotel?callback=callback';
    reqwest({
        url: url,
        type: 'jsonp',
        jsonpCallback: 'callback',
        success: response,
        error: response
    });

    function response(x) {
        var features = [];
        for (var i = 0; i < x.length; i++) {
            //some fixing
            _.each(x[i].imagenes, function(value, key) {
                x[i].imagenes[key].url = dir + x[i].imagenes[key].url;
            });
            //Properties
            x[i]['properties'] = {};
            x[i].properties['marker-size'] = 'small';
            x[i].properties['marker-symbol'] = 'hotel';
            x[i].properties['marker-color'] = '#000';
            //features.push(x[i]);
            features_data.push(x[i]); //global variable
        }
        console.log(features_data);
        return features;
    }
};
*/


function mm_hotel2(callback) {
    if (typeof reqwest === 'undefined') {
        throw 'CSV: reqwest required for mm_hotel';
    }
    var url = 'http://localhost:8080/sigturayac/SListarHotel?callback=callback';
    reqwest({
        url: url,
        type: 'jsonp',
        jsonpCallback: 'callback',
        success: response,
        error: response
    });

    function response(x) {
        var features = [];

        for (var i = 0; i < x.length; i++) {
            //some fixing
            _.each(x[i].imagenes, function(value, key) {
                x[i].imagenes[key].url = dir + x[i].imagenes[key].url;
            });
            //Properties
            x[i]['properties'] = {};
            x[i].properties['marker-size'] = 'small';
            x[i].properties['marker-symbol'] = 'hotel';
            x[i].properties['marker-color'] = '#000';
            features.push(x[i]);
        }
        return callback(features);
    }
};

