var tweets = ['%23tachito', '-12,-73,1500mi'];


function mm_twitter(callback) {
//url: 'http://search.twitter.com/search.json?q=%23aquid&include_entities=1',
//http://search.twitter.com/search.json?q=%23aquid&include_entities=1&&geocode=-13.15437,-74.22122,1mi
    reqwest({
        url: 'http://search.twitter.com/search.json?q=%23aquid&include_entities=1&&geocode=-13.15437,-74.22122,10mi',
        type: 'jsonp',
        jsonCallback: 'callback',

        success: process
    });

    function process(d) {
        var features = [];
        console.log(d.results);

        _.each(d.results, function(element, index) {

            if (!_.isUndefined(element.entities.media)) {

                if (element.geo && element.geo.type === 'Point') {
                    var lat = element.geo.coordinates[0],
                        lon = element.geo.coordinates[1];
                } else if (element.location && element.location.indexOf(': ') > 0) {
                    var coords = element.location.split(': ')[1],
                        $lat = coords.split(',')[0] || 0,
                        $lon = coords.split(',')[1] || 0;

                    if (!isNaN(parseFloat($lat)) && !isNaN(parseFloat($lon))) {
                        var lon = parseFloat($lon),
                            lat = parseFloat($lat);
                    }
                }

            }
            if (lat && lon) {
                var feature = {
                    geometry: {
                        type: 'Point',
                        coordinates: []
                    },
                    properties: {
                        'marker-size': 'small',
                        'marker-color': '#000',
                        'description': element.text,
                        'img': element.entities.media[0].media_url,
                        'date': element.created_at,
                        'hour': formatDate(new Date(element.created_at)),
                        'user': '@' + element.from_user,
                        'id':element.id
                    }
                };

                feature.geometry.coordinates[1] = lat;
                feature.geometry.coordinates[0] = lon;
                features.push(feature);
            }
        });
        console.log(features);
        return callback(features);
    }
};


function formatDate(d) {
    var hours = d.getHours();
    var minutes = d.getMinutes();
    var suffix = "AM";

    if (hours >= 12) {
        suffix = "PM";
        hours = hours - 12;
    }
    if (hours == 0) hours = 12;
    if (minutes < 10) minutes = "0" + minutes;

    return hours + ":" + minutes + " " + suffix;
}

/***********************************************************************/
function mm_twitter2() {

    reqwest({
        url: 'http://search.twitter.com/search.json?q=%23aquid&include_entities=1&&geocode=-13.16074,-74.22563,0.5mi',
        type: 'jsonp',
        jsonCallback: 'callback',
        success: process
    });

    function process(d) {
        var features = [];
        console.log(d.results);

        _.each(d.results, function(element, index) {

            if (!_.isUndefined(element.entities.media)) {

                if (element.geo && element.geo.type === 'Point') {
                    var lat = element.geo.coordinates[0],
                        lon = element.geo.coordinates[1];
                } else if (element.location && element.location.indexOf(': ') > 0) {
                    var coords = element.location.split(': ')[1],
                        $lat = coords.split(',')[0] || 0,
                        $lon = coords.split(',')[1] || 0;

                    if (!isNaN(parseFloat($lat)) && !isNaN(parseFloat($lon))) {
                        var lon = parseFloat($lon),
                            lat = parseFloat($lat);
                    }
                }

            }
            if (lat && lon) {
                var feature = {
                    geometry: {
                        type: 'Point',
                        coordinates: []
                    },
                    properties: {
                        'marker-size': 'small',
                        'marker-color': '#3B5998',
                        'description': element.text,
                        'img': element.entities.media[0].media_url,
                        'date': element.created_at,
                        'hour': formatDate(new Date(element.created_at)),
                        'user': '@' + element.from_user,
                        'id':element.id,
                        'from':'t'
                    }
                };

                feature.geometry.coordinates[1] = lat;
                feature.geometry.coordinates[0] = lon;
                features.push(feature);
                data.push(feature);
            }
        });
        console.log(features);        
        return features;
    }
};
