
function call_detail_recurso(id){  
    var link1='imagenes';
    var link2='videos';
    var link3='otros';
    var pro= buscarproducto(id);
    //$('#detail').html();
    var o='<div class="container" id="popover_recurso">'+
    '<div class="well">'+
        // '<div id="id_categoria">Categoria: </div>'+
        '<div class="navbar ">'+
            '<div class="img_popover"> <img src="http://dl.dropbox.com/u/43116811/icon-tur/'+pro.properties['marker-symbol']+'-l.png" alt=""></div>'+
            '<div class="navbar-inner">'+
                '<div class="container">'+
                    '<a class="brand" href="#">'+
                        pro.nombre+
                        '</a>'+
                    '<ul class="nav pull-right" >'+
                        '<li>'+
                            '<a href="#">'+
                                link1+
                                '</a>'+
                            '</li>'+
                        '<li>'+
                            '<a href="#">'+
                                link2+
                                '</a>'+
                            '</li>'+
                        '<li>'+
                            '<a href="#">'+
                                link3+
                                '</a>'+
                            '</li>'+
                        '</ul>'+
                    '</div>'+
                '</div>'+
            '</div>'+        
        '<div class="row-fluid">'+
            '<div class="span6">'+
                '<p  class="well">'+
                    pro.descripcion+
                    '</p>'+
                '<div id="id_detalles_recurso">'+

                '</div>'+
                '</div>'+
            '<div  id="carrucel" class="span6">'+
       
                '</div>'+
            //'</div>'+
        '</div>'+
    '</div>';
    //setTimeout(function(){
    $('#detail').append(o);
    //add_button_popovers('button_popover','id_temporada','cuando visitar');
    carrucel_images(pro.imagenes, 'carrucel',575); 
    add_detalles_recurso('id_detalles_recurso',pro);
        //},4000);


 $('#backdrop').fadeIn(200);        
    $('#detail').show(200);       
        
    $('#close').show(200);
};


function add_detalles_recurso(id_parent,p){
/*console.log(p.detalle);
console.log(p.detalle.distancia);*/

var tr_dis='';
var tr_cos='';
var tr_tem='';
var tr_com='';
//String.fromCharCode(160) espacio en blanco en jquery

if(check_null(p.detalle.distancia)){
   tr_dis= '<tr>'+
        '<td  width="150"> <i class="icon-hand-right"></i> Distancia </td>'+
        '<td>'+p.detalle.distancia+'</td>'+     
    '</tr>';
}
if(check_null(p.detalle.costo_ingreso)){
   tr_cos= '<tr>'+
        '<td width="150"> <i class="icon-hand-right"></i> Costo de Ingreso</td>'+
        '<td>'+p.detalle.costo_ingreso+'</td>'+
    '</tr>';  
}
if(check_null(p.detalle.temperatura)){
    tr_tem= '<tr>'+
        '<td width="150"> <i class="icon-hand-right"></i> Temperatura</td>'+
        '<td>'+p.detalle.temperatura+'</td>'+    
      '</tr>';
      
   
}
if(check_null(p.detalle.como_llegar)){
      tr_com= '<tr>'+
           '<tr>'+
        '<td width="150"> <i class="icon-hand-right"></i> Como Llegar</td>'+
        '<td>'+p.detalle.como_llegar+'</td>'+    
      '</tr>';
}


var table='';

    table='<table class="table table-striped table-bordered table-condensed">'+
    '<tbody>'+ tr_dis+ tr_cos+ tr_tem+ tr_com+
    '</tbody>'+ 
    '</table>';
    $('#'+id_parent).append(table);

};



function check_null(k){
if(k.replace(/\s/g,"")+ String.fromCharCode(160) != String.fromCharCode(160)){
    return true;
}else{
  return false;
}
}