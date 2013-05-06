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