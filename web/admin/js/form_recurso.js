$(function() {
    var sitios_arqueologicos = ['Conjunto Arqueológico', 'Sitio Arqueológico', 'Camino', 'Andenes', 'Sistema de Riego'];
    var arquitectura_colonial = ['Templo', 'Casona', 'Museos'];
    var sitio_historicos = ['Santuario Histórico', 'Casa de la capitulación', 'Puente colonial'];
    var cultura_viva = ['Fiesta Tradicional', 'Artesanía', 'Música', 'Danza', 'Otros'];
    var paisaje_natural = ['Valle', 'Mirador', 'Agua termal', 'Laguna', 'Bosque de Piedra', 'Bosque Natural', 'Catarata', 'Nevado', 'Río', 'Cerro', 'Reserva Nacional', 'Santuario Natural', 'Cañón'];
    $('#category-r').change(function() {        
        console.log(sitios_arqueologicos[0].toLowerCase().replace(/\s/g,"_"));
        var filter = $(this).val();
        var parent = document.getElementById("type-r");//select
        var options = '';
        $("#type-r option").remove();

        if ($(this).val() === decode_utf8('Sitios Arqueológicos')) {

            _.each(sitios_arqueologicos, function(value, key) {
                parent.innerHTML += '<option>' + decode_utf8(sitios_arqueologicos[key]) + '</option>';
            });
            //parent.appendChild(new_option);
        } else if ($(this).val() === decode_utf8('Arquitectura Colonial')) {
            _.each(arquitectura_colonial, function(value, key) {
                parent.innerHTML += '<option>' + decode_utf8(arquitectura_colonial[key]) + '</option>';
            });
            // parent.appendChild(new_option);
        } else if ($(this).val() === decode_utf8('Sitios Historicos')) {

            _.each(sitio_historicos, function(value, key) {
                parent.innerHTML += '<option>' + decode_utf8(sitio_historicos[key]) + '</option>';
            });
            // parent.appendChild(new_option);
        } else if ($(this).val() === decode_utf8('Cultura Viva')) {

            _.each(cultura_viva, function(value, key) {
                parent.innerHTML += '<option>' + decode_utf8(cultura_viva[key]) + '</option>';
            });
            // parent.appendChild(new_option);
        } else if ($(this).val() === decode_utf8('Paisaje Natural')) {

            _.each(paisaje_natural, function(value, key) {
                parent.innerHTML += '<option>' + decode_utf8(paisaje_natural[key]) + '</option>';
            });
            // parent.appendChild(new_option);
        }
    });
});


function decode_utf8(s)
{
    return decodeURIComponent(escape(s));
}
function encode_utf8(s)
{
    return unescape(encodeURIComponent(s));
}

