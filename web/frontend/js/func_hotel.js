
function call_detail_hotel(id){  
    var link1='imagenes';
    var link2='videos';
    var link3='otros';
    var pro= buscarproducto(id);
    //$('#detail').html();
    var o='<div class="container" id="popover_hotel">'+
    '<div class="well">'+

    '<div class="navbar ">'+
        '<dic class="img_popover"> <img src="http://a.tiles.mapbox.com/v3/marker/pin-m-'+pro.properties['marker-symbol']+'+000.png" alt=""></dic>'+
        '<div class="navbar-inner">'+
            '<div class="container">'+
                '<a class="brand"  href="#">'+                                        
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
            '<p class="well">'+
                pro.descripcion+
            '</p>'+
            '<div  id="id_detalles">'+
            '</div>'+
        '</div>'+
        '<div  id="carrucel" class="span6">'+
            //'<img src="'+pro.imagenes[0].url+'" style=" width: 500px; height: auto;">'+
            '</div>'+
        '</div>'+ 
        '</div>'+
    '</div>';

    var id_habitacion='<div class="container">'+
    '<div class="row-fluid">'+
        '<div class="span4 well" id="id_habitacion">'+
            '<h3>Habitaciones</h3>'+   
            '</div>'+  
        '<div class="span4 well " id="id_promocion" >'+  
            '<h3>Promociones</h3>'+
            '</div>'+  
        '<div class="span4 well " id="id_servicio" >'+  
            '<h3>Servicios Adicionales</h3>'+  
            '</div>'+ 
        '</div>'+
    '</div>';

    
    //setTimeout(function(){
    $('#detail').append(o);
    $('#detail').append(id_habitacion);
    //add_button_popovers('button_popover','id_temporada','cuando visitar');
    carrucel_images(pro.imagenes, 'carrucel',575);
    add_details('id_detalles',pro);
    add_habitacion('id_habitacion',pro.bHabitacion);
    add_promocion('id_promocion','id_popover_prom',pro.bPromocion);
    add_servicio('id_servicio','id_popover_serv',pro.bServiciosAdicional);
        //},4000);


 $('#backdrop').fadeIn(200);        
    $('#detail').show(200);       
        
    $('#close').show(200);
}



function add_details(id_parent,p){

    var table='<table class="table table-striped table-bordered table-condensed">'+
    '<tbody>'+
         '<tr>'+
        '<td> <i class="icon-hand-right"></i> Dirceción</td>'+
        '<td>'+p.direccion+'</td>'+
     
      '</tr>'+   

     '<tr>'+
        '<td> <i class="icon-hand-right"></i> Telefono</td>'+
        '<td>'+p.telefono+'</td>'+

      '</tr>'+  
           '<tr>'+
        '<td> <i class="icon-hand-right"></i> Sitio Web</td>'+
        '<td>'+p.sitio+'</td>'+

      '</tr>'+   
           '<tr>'+
        '<td> <i class="icon-hand-right"></i> Horario de Atenciónn</td>'+
        '<td>'+p.hora_aten+'</td>'+    
      '</tr>'+
    '</tbody>'+ 
    '</table>';
    $('#'+id_parent).append(table);

/*direccion: "ppppppppppppppppppppppppp ",
telefono: "ppppppppppppppppppp ",
sitio: "pppppppppppppppppppppppppp ",
hora_aten: "pppppppppppppppppppppp ",*/

}















function add_habitacion(id_parent,array){
    var tr = '';
    for (var i =0 ; i<array.length; i++) {
        tr +=  '<tr>'+
        '<td>'+array[i].tipo+'</td>'+
        '<td>'+array[i].precio+'</td>'+
        '<td>'+array[i].descripcion+'</td>'+
        '</tr>';	
    };

    var table='<table class="table table-striped table-bordered table-condensed">'+
    '<thead>'+
    '<tr>'+
    '<th>Tipo</th>'+
    '<th>Costo</th>'+
    '<th>Descripción</th>'+
    '</tr>'+
    '</thead>'+
    '<tbody>'+tr+
    '</tbody>'+
    '</table>';
    $('#'+id_parent).append(table);
};



function add_promocion(id_parent,id_button, array){
for (var i =0 ; i<array.length; i++) {
console.log(array[i]);
var a='';
var pop='';
var tipo='';
var descripcion='';

    tipo=array[i].tipo;
    descripcion=array[i].descripcion;

    a='<a href="#" id="'+(id_button+i)+'" class="btn large primary" rel="popover'+i+'" style="display: none">inf</a>';
    
    $('#'+id_parent).append(a);

       $("#"+id_button+i).popover({
        placement : 'bottom',
        title : tipo,
        html: 'true',      
        content : descripcion
    });

    $('[rel=popover'+i+']').popover({'trigger': 'manual'});
   $('[rel=popover'+i+']').popover('show');

}

};


function add_servicio(id_parent,id_button, array){

for (var i =0 ; i<array.length; i++) {
console.log(array[i]);
var a='';
var pop='';
var tipo='';
var descripcion='';

    tipo=array[i].tipo;
    descripcion=array[i].descripcion;
    a='<a href="#" id="'+(id_button+i)+'" class="btn large primary" rel="popover'+i+'" style="display: none">inf ser</a>';
    $('#'+id_parent).append(a);
       $("#"+id_button+i).popover({
        placement : 'bottom',
        title : tipo,
        html: 'true',      
        content : descripcion
    });

    $('[rel=popover'+i+']').popover({'trigger': 'manual'});
   $('[rel=popover'+i+']').popover('show');

}
};