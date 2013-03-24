//features_data=global data
//dir= global data

function mm_recurso(callback) {
    if (typeof reqwest === 'undefined') {
        throw 'CSV: reqwest required for mm_recurso';
    }
    var url = 'http://localhost:8080/sigturayac/SListarRecurso?callback=callback';
    reqwest({
        url: url,
        type: 'jsonp',
        jsonpCallback: 'callback',
        success: response,
        error: response
    });



    function response(x) {
        //var features = [],
        latfield = '',
        lonfield = '';
        //console.log(x);



        for (var i = 0; i < x.length; i++) {
            var type_icon = x[i].tipo.toLowerCase().replace(/\s/g, ""); /*.replace('ó','o');;*/
            //some fixing
            _.each(x[i].imagenes, function(value, key) {
                x[i].imagenes[key].url = dir + x[i].imagenes[key].url;
            });
            //Properties
            x[i]['properties'] = {};
            x[i].properties['marker-size'] = 'large';
            x[i].properties['marker-symbol'] = type_icon;
            x[i].properties['marker-color'] = '#000000';

            features_data.push(x[i]); //global variable

        }



       // console.log('primero pasa por aqui' + features_data);
        //return callback;
        return callback(features_data);
    }
}