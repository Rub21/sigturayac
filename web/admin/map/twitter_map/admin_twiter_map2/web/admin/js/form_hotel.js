$(function(){  
    
    // HABITACION
    var counter_room = 2;
    //agregamos el un IMPUT  para contparasar a java
    $('#room_tools-h').append('<input type="text"  name="num-rooms" id="num-rooms-h" value="'+(counter_room-1)+'"  style="width: 0px; height: 0px; padding:0;" />')
    $('#del_room-h').hide();
    $('#add_room-h').click(function(){
        
        $('#room_tools-h').before('<div class="well" id="room'+counter_room+'">'+
            '<div class="row-fluid">'+
            '<div class="span4 left">Tipo</div>'+
            '<div class="span4">'+
            '<select name="type-room'+counter_room+'" id="type-room'+counter_room+'-h" align="left" >'+
            '<option value="simple">Simple</option>'+
            '<option value="Doble">Doble</option>'+
            '<option value="Matrimonial">Matrimonial</option>'+
            '<option value="Suit">Suit</option>'+

            '</select>'+
            '</div>'+
            '</div>'+
            '<div class="row-fluid ">'+
            '<div class="span4">Precio</div>'+
            '<div class="span4">'+                          
            '<input type="text"  name="price-room'+counter_room+'" value=""  align="left" id="price-room'+counter_room+'-h"  placeholder="Precio de la Habitacion"/>'+
            '</div>'+
            '</div>'+ 
            '<div class="row-fluid">'+
            '<div class="span4">Descripci&oacute;n</div>'+
            '<div class="span4">'+                          
            '<textarea  name="description-room'+counter_room+'"  rows="3" cols="75" id="description-room'+counter_room+'-h" align="left">'+'</textarea>'+
            '</div>'+
            '</div>'+ 
            '</div> ');
        
        $('#del_room-h').fadeIn(0);
        counter_room++;     
       
        //poniendo el valor del contador en el div
        $('#num-rooms-h').attr('value', counter_room-1);
    });

    $('#del_room-h').click(function(){
        if(counter_room==3){
            $('#del_room-h').hide();
        }   
        counter_room--;
        $('#room'+counter_room).remove();
      
        //poniendo el valor del contador en el div
        $('#num-rooms-h').attr('value', counter_room-1);
      
    });
 
 
    // SERVICIO
    var counter_service = 2;
    //agregamos el un IMPUT  para contparasar a java
    $('#service_tools-h').append('<input type="text"  name="num-services" id="num-services-h" value="'+(counter_service-1)+'"  style="width: 0px; height: 0px; padding:0;" />')
    $('#del_service-h').hide();
    $('#add_service-h').click(function(){
        
        $('#service_tools-h').before('<div class="well" id="service'+counter_service+'">'+
            '<div class="row-fluid ">'+
            '<div class="span4">Tipo de Servicio '+counter_service+'</div>'+
            '<div class="span4">'+                          
            '<input type="text"  name="type-service'+counter_service+'" value=""  align="left" id="type-service'+counter_service+'-h"  placeholder="Nombre del Servicios "/>'+
            '</div>'+
            '</div>'+  
            '<div class="row-fluid">'+
            '<div class="span4">Descripci&oacute;n del Servicio</div>'+
            '<div class="span4">'+                          
            '<textarea  name="description-service'+counter_service+'"  rows="3" cols="75" id="description-service'+counter_service+'-h" align="left">'+'</textarea>'+
            '</div>'+
            '</div>'+ 
            '</div>');
        
        $('#del_service-h').fadeIn(0);
        counter_service++;     
    
    
        //poniendo el valor del contador en el div
        $('#num-services-h').attr('value', counter_service-1);
    });
    
    $('#del_service-h').click(function(){
        if(counter_service==3){
            $('#del_service-h').hide();
        }   
        counter_service--;
        $('#service'+counter_service).remove();
      
        //poniendo el valor del contador en el div
        $('#num-services-h').attr('value', counter_service-1);
      
    });
    
    // PROMOCION
    var counter_promotion = 2;
    $('#promotion_tools-h').append('<input type="text"  name="num-promotions" id="num-promotions-h" value="'+(counter_room-1)+'"  style="width: 0px; height: 0px; padding:0;" />')
    
    $('#del_promotion-h').hide();
    $('#add_promotion-h').click(function(){
        
        $('#promotion_tools-h').before('<div class="well" id="promotion'+counter_promotion+'">'+
            '<div class="row-fluid ">'+
            '<div class="span4">Tipo de la Promoci&oacute;n  '+counter_promotion+'</div>'+
            '<div class="span4">'+                          
            '<input type="text"  name="type-promotion'+counter_promotion+'" value=""  align="left" id="type-promotion'+counter_promotion+'-h"  placeholder="Nombre de la Promoci&oacute;n "/>'+
            '</div>'+
            '</div>'+  
            '<div class="row-fluid">'+
            '<div class="span4">Descripci&oacute;n del Servicio</div>'+
            '<div class="span4">'+                          
            '<textarea  name="description-promotion'+counter_promotion+'"  rows="3" cols="75" id="description-promotion'+counter_promotion+'-h" align="left">'+'</textarea>'+
            '</div>'+
            '</div>'+ 
            '</div>');
        
        $('#del_promotion-h').fadeIn(0);
        counter_promotion++;        
        $('#num-promotions-h').attr('value', counter_promotion-1);
    });
    $('#del_promotion-h').click(function(){
        if(counter_promotion==3){
            $('#del_promotion-h').hide();
        }   
        counter_promotion--;
        $('#promotion'+counter_promotion).remove();        
        $('#num-promotions-h').attr('value', counter_promotion-1);
    });
    
    
    


});


