
function call_detail_recurso(id){  
    var link1='imagenes';
    var link2='videos';
    var link3='otros';
    var pro= buscarproducto(id);
    //$('#detail').html();
    var o='<div class="container">'+
    '<div class="well">'+
    '<div class="navbar ">'+
    '<div class="navbar-inner">'+
    '<div class="container">'+
    '<a class="brand" href="#">'+
    '<i class="icon-leaf">'+
    '</i>'+ pro.nombre+
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
    '<div>'+
    '<p>'+
    pro.descripcion+
    '</div>'+
    '</div>'+
    '<div  id="carrucel" class="span6">'+
    //'<img src="'+pro.imagenes[0].url+'" style=" width: 500px; height: auto;">'+
    '</div>'+
    '</div>'+
    '</div>'+
    '</div>';
    //setTimeout(function(){
    $('#detail').append(o);
    //add_button_popovers('button_popover','id_temporada','cuando visitar');
    carrucel_images(pro.imagenes, 'carrucel',575); 
        //},4000);


 $('#backdrop').fadeIn(200);        
    $('#detail').show(200);       
        
    $('#close').show(200);
}
