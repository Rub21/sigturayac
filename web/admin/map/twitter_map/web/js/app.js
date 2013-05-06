$(function() {

    $('a[href="#puntosregistrados"]').click(function(e) {
        e.preventDefault();
        $('#backdrop').fadeIn(300);
        $('#puntosregistrados').show(300);
        
        map_pendientes();
        menu_pendientes();
    });

    $('a[href="#close"]').click(function(e) {
        e.preventDefault();
        $('#backdrop').fadeOut(200);
        $('#recurso').hide(200);
        $('#hotel').hide(200);
        $('#restaurant').hide(200);
        $('#transporte').hide(200);
        $('#complementario').hide(200);
    });


    $('#button_submit').click(function(e) {

        e.preventDefault();
        var ajaxdata = $("#id_punto").val();
        console.log(ajaxdata);
        var value = 'id_punto=' + ajaxdata;

        $.ajax({
            url: "Servlet_Actualizar",
            //type: "post",
            data: value,
            cache: false,
            success: function(data) {
                $("#id_punto").val('');
                  map_pendientes();
            }
        });

    });



});


