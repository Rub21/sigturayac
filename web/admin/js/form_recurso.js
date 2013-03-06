//initializer




$(function(){
    var sit_nat=['Montañas','Planicies','Quebradas','Cañones','Pongos','Cuerpos de agua','Ríos','Caídas de agua','Aguas Minero Medicinales',
    'Costas','Grutas o Cavernas,Cuevas','Áreas protegidas','Otros'];
    var manf_cult=['Museos','Arquitectura y Espacios Urbanos','Lugares Históricos','Sitios Arqueológicos','Pueblos'];

    $('#category-r').change( function() {
        var filter = $(this).val();
        var parent = document.getElementById("type-r");//select
        var options='';
        $("#type-r option").remove();
   
        if ($(this).val() == 'Sitio Natural') {
            _.each(sit_nat, function (value, key) {           
                parent.innerHTML += '<option>'+decode_utf8(sit_nat[key])+'</option>';
            });           
        //parent.appendChild(new_option);
        } else if ($(this).val() == decode_utf8('Manifestación Cultural')) {

            _.each(manf_cult, function (value, key) {           
                parent.innerHTML += '<option>'+decode_utf8(manf_cult[key])+'</option>';
            });           
        // parent.appendChild(new_option);
        } 
    });
});
function decode_utf8( s )
{
    return decodeURIComponent( escape( s ) );
}
function encode_utf8( s )
{
    return unescape( encodeURIComponent( s ) );
}

