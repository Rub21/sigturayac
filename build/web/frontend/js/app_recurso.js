//features_data=global data
//dir= global data
function mm_recurso(callback) {
    if (typeof reqwest === 'undefined'){
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
           
            var a =x[i].categoria.replace(/\s/g,"");
       

            //some fixing

            _.each(x[i].imagenes, function (value, key) {
                x[i].imagenes[key].url= dir+x[i].imagenes[key].url;
            });
    





            //Properties
            x[i]['properties']={};
            if(a=='ManifestaciónCultural'){
                x[i].properties['marker-size'] =  'small';
                x[i].properties['marker-symbol'] ='monument';
                x[i].properties['marker-color']= '#000';
            }else if(a=='SitioNatural'){
                x[i].properties['marker-size'] =  'small';
                x[i].properties['marker-symbol'] ='park';
                x[i].properties['marker-color']= '#000';

            }                                    
            //features.push(x[i]);                         
            features_data.push(x[i]);//global variable
        } 
        
        return callback;
    }
}
