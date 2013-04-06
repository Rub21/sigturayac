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
        '<a href="#servicios" onclick="call_map(\'' + rec.idproducto + '\')"><i class="icon-comer-black"></i>Donde Comer' +
        '</a>' +
        '</li>' +
        '<li>' +
        '<a href="#servicios" onclick="call_map(\'' + rec.idproducto + '\')"><i class="icon-dormir-black"></i>Donde Dormir' +
        '</a>' +
        '</li>' +
        '<li>' +
        '<a href="#"> Otros'+ 
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
    var div_map = '<a name="servicios"><h3>Donde comer</h3></a><div name="servicios" class="map_recurso"></div>';
    var up_pages = '<a href="#up" class="ancla"></a>';
    o = o + div_map + close_button + up_pages;
    $('#detail').append(o);
    carrucel_images(rec.imagenes, 'carrucel', 575);
    add_detalles_recurso('id_detalles_recurso', rec);
    $('#backdrop').fadeIn(200);
    $('#detail').show(200);
    $('#close').show(200);
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

function call_map(id) {
    $('.map_recurso').empty();
    var rec = buscarproducto(id); //rec=recurso
    $('.map_recurso').append('<div id="maps"></div>');
    draw_map('maps', rec);
};