function mm_restaurant(callback) {
    if (typeof reqwest === 'undefined') {
        throw 'CSV: reqwest required for mm_hotel';
    }
    var url = 'http://localhost:8080/sigturayac/SListarRestaurant?callback=callback';
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
            x[i].properties['marker-symbol'] = 'restaurant';
            x[i].properties['marker-color'] = '#000';
            features.push(x[i]);
        }
        return callback(features);
    }
};

