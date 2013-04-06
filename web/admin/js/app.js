function enable_check(id) {
    $('#chek_lat_lon-' + id).click(function() {
        if ($("#chek_lat_lon-" + id).is(':checked')) {
            $("#lat-" + id).removeAttr("readonly");
            $("#lon-" + id).removeAttr("readonly");
        } else {
            $("#lat-" + id).attr('readonly', 'readonly');
            $("#lon-" + id).attr('readonly', 'readonly');
        }
    });
}

function add_imagen(id) {
    var counter = 3;
    $('#del_file-' + id).hide();
    $('img#add_file-' + id).click(function() {
        $('#file_tools-' + id).before('<div class="well file_upload" id="f' + counter + '">' +
                '<input name="file' + counter + '" type="file" id="file_img' + counter + '-' + id + '" required>' + //forma ejemplo  file_img1-r
                '<input type="text" name="title_img' + counter + '" value=""  id="title_img' + counter + '-' + id + ' " placeholder="Nombre de Imagen ' + counter + '"/>' +
                ' <textarea class="span7" name="description_img' + counter + '" rows="2" cols="25"  id="description_img' + counter + '-' + id + '" placeholder="Descripcion de la imagen ' + counter + '"></textarea>' +
                '</div>');
        $('#del_file-' + id).fadeIn(0);
        counter++;
    });
    $('img#del_file-' + id).click(function() {
        if (counter == 4) {
            $('#del_file-' + id).hide();
        }
        counter--;
        $('#f' + counter).remove();
    });
}

function clean_filed(id) {
    $('#clear-' + id).click(function() {

        $(':input', '#form-' + id)
                .not(':button, :submit, :reset, :hidden')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
    });

}


function initializer() {
    //Recurso
    map('r');
    enable_check('r');
    add_imagen('r');
    clean_filed('r');
    //Hotel
    map('h');
    enable_check('h');
    add_imagen('h');
    clean_filed('h');
    //restaurant
    map('re');
    enable_check('re');
    add_imagen('re');
    clean_filed('re');

    //transporte
    map('t');
    enable_check('t');
    add_imagen('t');
    clean_filed('t');
    //servicios Complementario
    map('c');
    enable_check('c');
    add_imagen('c');
    clean_filed('c');
}

initializer();
$(function() {

    $('a[href="#recurso"]').click(function(e) {
        e.preventDefault();
        $('#backdrop').fadeIn(200);
        $('#recurso').show(200);
        $('#hotel').hide(200);
        $('#restaurant').hide(200);
        $('#transporte').hide(200);
        $('#complementario').hide(200);
    });

    $('a[href="#hotel"]').click(function(e) {
        e.preventDefault();
        $('#backdrop').fadeIn(200);
        $('#hotel').show(200);
        $('#recurso').hide(200);
        $('#restaurant').hide(200);
        $('#transporte').hide(200);
        $('#complementario').hide(200);
    });

    $('a[href="#restaurant"]').click(function(e) {
        e.preventDefault();
        $('#backdrop').fadeIn(200);
        $('#restaurant').show(200);
        $('#recurso').hide(200);
        $('#hotel').hide(200);
        $('#transporte').hide(200);
        $('#complementario').hide(200);
    });

    $('a[href="#transporte"]').click(function(e) {
        e.preventDefault();
        $('#backdrop').fadeIn(200);
        $('#restaurant').hide(200);
        $('#recurso').hide(200);
        $('#hotel').hide(200);
        $('#transporte').show(200);
        $('#complementario').hide(200);
    });

    $('a[href="#complementario"]').click(function(e) {
        e.preventDefault();
        $('#backdrop').fadeIn(200);
        $('#restaurant').hide(200);
        $('#recurso').hide(200);
        $('#hotel').hide(200);
        $('#transporte').hide(200);
        $('#complementario').show(200);
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

});


