function mm_producto(callback) {
    if (typeof reqwest === 'undefined') {
        throw 'CSV: reqwest required for mm_producto';
    }
    var url = 'http://localhost:8080/sigturayac/SListar?callback=callback';
    reqwest({
        url: url,
        type: 'jsonp',
        jsonpCallback: 'callback',
        success: response,
        error: response
    });

    function response(x) {
        var features = [];
        //console.log(x);

        for (var i = 0; i < x.length; i++) {

            /**************************************
            Recurso
            ****************************************/
            console.log(x[i].clase);
            var clase = x[i].clase.replace(/\s/g, "");

            if (clase === 'RecursoTurístico') {

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

                /**************************************
            Hotel
            ****************************************/
            } else if (clase === 'Hotel') {
                //some fixing
                _.each(x[i].imagenes, function(value, key) {
                    x[i].imagenes[key].url = dir + x[i].imagenes[key].url;
                });
                //Properties
                x[i]['properties'] = {};
                x[i].properties['marker-size'] = 'small';
                x[i].properties['marker-symbol'] = 'hotel';
                x[i].properties['marker-color'] = '#000';
                /**************************************
            Restaurant
            ****************************************/
            } else if (clase === 'Restaurant') {
                //some fixing
                _.each(x[i].imagenes, function(value, key) {
                    x[i].imagenes[key].url = dir + x[i].imagenes[key].url;
                });
                //Properties
                x[i]['properties'] = {};
                x[i].properties['marker-size'] = 'small';
                x[i].properties['marker-symbol'] = 'restaurant';
                x[i].properties['marker-color'] = '#000';

                /**************************************
            Transporte
            ****************************************/
            } else if (clase === 'Transporte') {
                //some fixing
                _.each(x[i].imagenes, function(value, key) {
                    x[i].imagenes[key].url = dir + x[i].imagenes[key].url;
                });
                //Properties
                x[i]['properties'] = {};
                x[i].properties['marker-size'] = 'small';
                x[i].properties['marker-symbol'] = 'transporte';
                x[i].properties['marker-color'] = '#000';
                /**************************************
            Servicio Complementario
            ****************************************/
            } else if (clase === 'Complementario') {
                //some fixing
                _.each(x[i].imagenes, function(value, key) {
                    x[i].imagenes[key].url = dir + x[i].imagenes[key].url;
                });

                var type_icon = x[i].tipo.toLowerCase().replace(/\s/g, ""); /*.replace('ó','o');;*/

                //Properties
                x[i]['properties'] = {};
                x[i].properties['marker-size'] = 'small';
                x[i].properties['marker-symbol'] = type_icon;
                x[i].properties['marker-color'] = '#000';
            }



            features.push(x[i]);

        }
        console.log(features);
        return callback(features);
    }
}