$(function() {

    // DESTINO
    var counter_destino = 2;
    //agregamos el un IMPUT  para contparasar a java
    $('#destino_tools-t').append('<input type="text"  name="num-destino" id="num-destino-t" value="' + (counter_destino - 1) + '"  style="width: 0px; height: 0px; padding:0;" />')
    $('#del_destino-t').hide();
    $('#add_destino-t').click(function() {
        $('#destino_tools-t').before('<div class="well" id="destino' + counter_destino + '">' +
                '<div class="row-fluid ">' +
                '<div class="span4">Destino</div>' +
                '<div class="span4"> ' +
                '<input type="text"  name="destino' + counter_destino + '" value="" align="left" id="destino-t' + counter_destino + '"  placeholder="Destino"/>' +
                ' </div>' +
                '</div> ' +
                '</div> ');

        $('#del_destino-t').fadeIn(0);
        counter_destino++;

        //poniendo el valor del contador en el div
        $('#num-destino-t').attr('value', counter_destino - 1);
    });

    $('#del_destino-t').click(function() {
        if (counter_destino == 3) {
            $('#del_destino-t').hide();
        }
        counter_destino--;
        $('#destino' + counter_destino).remove();

        //poniendo el valor del contador en el div
        $('#num-destino-t').attr('value', counter_destino - 1);

    });




});


