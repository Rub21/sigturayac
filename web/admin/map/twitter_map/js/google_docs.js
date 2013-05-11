function mmg_docs(callback) {

    var url = 'https://spreadsheets.google.com/feeds/list/0AhfXukqwpMbidFEwQXVWNFdRLXdJZVcwamlUWDRvemc/od6/public/values?alt=json-in-script&callback=callback';
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
        if (!x || !x.feed) return features;
        for (var f in x.feed.entry[0]) {
            if (f.match(/\$Lat/i)) {
                latfield = f;
            }
            if (f.match(/\$Lon/i)) {
                lonfield = f;
            }
        }

        for (var i = 0; i < x.feed.entry.length; i++) {
            var entry = x.feed.entry[i];

            var id = entry['gsx$marcatemporal'].$t;
            //id=id.substr(10 ,18);
            id = id.replace('/', '').replace(/\s/g, "").replace(':', "");
            id = id.replace('/', '').replace(/\s/g, "").replace(':', "");
            var id_int = parseInt(id, 10);
            // console.log(id);

            var feature = {
                geometry: {
                    type: 'Point',
                    coordinates: []
                },
                properties: {
                    'marker-size': 'small',
                    'marker-color': '#0ff',
                    'description': entry['gsx$descripción-comentario'].$t,
                    'img': 'https://dl.dropboxusercontent.com/u/43116811/boots-osm/bas.jpg',
                    'date': entry['gsx$fechaaviso'].$t,
                    'hour': entry['gsx$horaaviso'].$t,
                    'user': entry['gsx$usuario'].$t,
                    'id': id_int
                }
            };

            for (var y in entry) {
                if (y === latfield) feature.geometry.coordinates[1] = parseFloat(entry[y].$t);
                else if (y === lonfield) feature.geometry.coordinates[0] = parseFloat(entry[y].$t);
                else if (y.indexOf('gsx$') === 0) {

                    //feature.properties[y.replace('gsx$', '')] = entry[y].$t;
                }
            }

            if (feature.geometry.coordinates.length == 2) features.push(feature);
        }
        //console.log(features)
        return callback(features);
    }
}

/***********************************/

function mmg_docs2() {

    var url = 'https://spreadsheets.google.com/feeds/list/0AhfXukqwpMbidFEwQXVWNFdRLXdJZVcwamlUWDRvemc/od6/public/values?alt=json-in-script&callback=callback';
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
        if (!x || !x.feed) return features;
        for (var f in x.feed.entry[0]) {
            if (f.match(/\$Lat/i)) {
                latfield = f;
            }
            if (f.match(/\$Lon/i)) {
                lonfield = f;
            }
        }

        for (var i = 0; i < x.feed.entry.length; i++) {
            var entry = x.feed.entry[i];

            var id = entry['gsx$marcatemporal'].$t;
            //id=id.substr(10 ,18);
            id = id.replace('/', '').replace(/\s/g, "").replace(':', "");
            id = id.replace('/', '').replace(/\s/g, "").replace(':', "");
            var id_int = parseInt(id, 10);
            // console.log(id);

            var feature = {
                geometry: {
                    type: 'Point',
                    coordinates: []
                },
                properties: {
                    'marker-size': 'small',
                    'marker-color': '#3B5998',
                    'description': entry['gsx$descripción-comentario'].$t,
                    'img': 'https://dl.dropboxusercontent.com/u/43116811/boots-osm/bas.jpg',
                    'date': entry['gsx$fechaaviso'].$t,
                    'hour': entry['gsx$horaaviso'].$t,
                    'user': entry['gsx$usuario'].$t,
                    'id': id_int,
                    'from':'w'
                }
            };

            for (var y in entry) {
                if (y === latfield) feature.geometry.coordinates[1] = parseFloat(entry[y].$t);
                else if (y === lonfield) feature.geometry.coordinates[0] = parseFloat(entry[y].$t);
                else if (y.indexOf('gsx$') === 0) {

                    //feature.properties[y.replace('gsx$', '')] = entry[y].$t;
                }
            }

            if (feature.geometry.coordinates.length == 2) {
                features.push(feature);
                data.push(feature);
            };
        }
       // console.log(features);
        return features;
    }
}