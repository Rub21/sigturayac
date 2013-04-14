function call_detaill_recurso(id) {

    var rec = buscarproducto(id); //rec=recurso
    var o = '<div id="popover_recurso">' +
        '<div class="content well">' +
        '<a name="up"></a><div class="navbar ">' +
        '<div class="img_popover"> <img src="http://dl.dropbox.com/u/43116811/icon-tur/' + rec.properties['marker-symbol'] + '-l.png" alt=""></div>' +
        '<div class="navbar-inner">' +
        '<div class="container">' +
        '<a class="brand" href="#">' + rec.nombre +
        '</a>' +
        '<ul class="nav pull-right" >' +
        '<li>' +
        '<a href="#hotel" ><i class="icon-dormir-black"></i>Donde Dormir' +
        '</a>' +
        '</li>' +
        '<li>' +
        '<a href="#restaurant"><i class="icon-comer-black"></i>Donde Comer' +
        '</a>' +
        '</li>' +
        '<li>' +
        '<a href="#transporte" ><i class="icon-transporte-black"></i>Como viajar' +
        '</a>' +
        '</li>' +
        '<li>' +
        '<a href="#complementario" ><i class="icon-dormir-black"></i>Otros Servicios' +
        '</a>' +
        '</li>' +
        '<li>' +
        '<a href="#"> Otros' +
        '</a>' +
        '</li>' +

        '</ul>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '<div class="row-fluid">' +
        '<div class="span6">' +
        '<p  class="well">' + rec.descripcion +
        '</p>' +
        '<div id="id_detalles_recurso">' +
        '</div>' +
        '</div>' +
        '<div  id="carrucel" class="span6">' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>';

    var close_button = '<div class="modal-footer"><button type="button" data-dismiss="modal" class="btn btn-primary" id="butoon_close">Close</button></div>';

    var div_map = '<div class="container-servicios">' +
        '<a id="servicios" >' +
        '<h3  class="text-info text-center" >Servicios Adicionales en : ' + rec.nombre + '</h3>' +
        '</a>' +
        '<div class="map_servicios"></div>' +
        '<div class="select_servicios">' +
        '<ul class="dropdown-menu">' +
        '<li><a id="select_hotel" href="#hotel"><i class="icon-hand-right"></i>Donde Dormir</a></li>' +
        '<li><a id="select_restaurant"href="#restaurant"><i class="icon-hand-right"></i>Donde Comer</a></li>' +
        '<li><a id="select_transporte" href="#transporte"><i class="icon-hand-right"></i>Como Viajar</a></li>' +
        '<li><a id="select_complementario" href="#complementario"><i class="icon-hand-right"></i>Otros Servicios</a></li>' +
        '<li class="divider"></li>' +
        '<li><a id="select_todos" href="#todos"><i class="icon-hand-right"></i>Todos</a></li>' +
        '</ul>' +
        '</div>' +
        '</div>'; //finish content



    var up_pages = '<a href="#up" class="ancla"></a>';

    o = o + div_map + close_button + up_pages;

    $('#detail').append(o);
    // call_map_servicios(rec.idproducto);
    $('#backdrop').fadeIn(200);
    $('#detail').show(200);
    $('#close').show(200);

    carrucel_images(rec.imagenes, 'carrucel', 575);
    add_detalles_recurso('id_detalles_recurso', rec);
    window.setTimeout(function() {
        call_map_servicios(rec.idproducto);
        $('.dropdown-toggle').dropdown();

    }, 1000);

};



function add_detalles_recurso(id_parent, rec) {
    var tr_dis = '';
    var tr_cos = '';
    var tr_tem = '';
    var tr_com = '';
    if (check_null(rec.detalle.distancia)) {
        tr_dis = '<tr>' +
            '<td  width="150"> <i class="icon-hand-right"></i> Distancia </td>' +
            '<td>' + rec.detalle.distancia + '</td>' +
            '</tr>';
    }
    if (check_null(rec.detalle.costo_ingreso)) {
        tr_cos = '<tr>' +
            '<td width="150"> <i class="icon-hand-right"></i> Costo de Ingreso</td>' +
            '<td>' + rec.detalle.costo_ingreso + '</td>' +
            '</tr>';
    }
    if (check_null(rec.detalle.temperatura)) {
        tr_tem = '<tr>' +
            '<td width="150"> <i class="icon-hand-right"></i> Temperatura</td>' +
            '<td>' + rec.detalle.temperatura + '</td>' +
            '</tr>';


    }
    if (check_null(rec.detalle.como_llegar)) {
        tr_com = '<tr>' +
            '<tr>' +
            '<td width="150"> <i class="icon-hand-right"></i> Como Llegar</td>' +
            '<td>' + rec.detalle.como_llegar + '</td>' +
            '</tr>';
    }

    var table = '';
    table = '<table class="table table-striped table-bordered table-condensed">' +
        '<tbody>' + tr_dis + tr_cos + tr_tem + tr_com +
        '</tbody>' +
        '</table>';
    $('#' + id_parent).append(table);

};


function check_null(k) {
    if (k.replace(/\s/g, "") + String.fromCharCode(160) != String.fromCharCode(160)) {
        return true;
    } else {
        return false;
    }
}


function call_map_servicios(id) {
    $('.map_servicios').empty();
    var rec = buscarproducto(id); //rec=recurso
    console.log(rec);
    $('.map_servicios').append('<div id="map_servicios"></div>');
    draw_map('map_servicios', rec); //id map, parametro para reconocer el hotel, y el objeto recurso
};