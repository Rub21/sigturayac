function mm_producto(callback) {
    if (typeof reqwest === 'undefined') {
        throw 'CSV: reqwest required for mm_recurso';
    }
    var url = 'http://localhost:8080/sigturayac/SListarProducto?callback=callback';
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