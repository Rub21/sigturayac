$(function() {
    //Set up date pickers
    var now = new Date();
    now = now.getDate() + '/' + now.getMonth() + '/' + now.getFullYear();
    $('#fecha').datepicker({
        dateFormat: 'dd/mm/yy', // formato de fecha que se usa en España
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sabado'], // días de la semana
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'], // días de la semana (versión super-corta)
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'], // días de la semana (versión corta)
        firstDay: 1, // primer día de la semana (Lunes)
        maxDate: new Date(), // fecha máxima
        minDate: '-2y',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'], // meses
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'], // meses
        navigationAsDateFormat: true,
    });
    //Set up hour pickers
    $('#hora').ptTimeSelect({
        hoursLabel: 'Horas',
        minutesLabel: 'Minutos',
        setButtonLabel: 'Establecer',
    });

    $("#fecha").attr('readonly', 'readonly');
    $("#hora").attr('readonly', 'readonly');
    $("#latitud").attr('readonly', 'readonly');
     $("#longitud").attr('readonly', 'readonly');
});


function Valida(formulario) {
    //Selected the list and renplace wit "_"
    var typeincidente = $('#entry_0 option:selected').text().replace(/\s/g, "_");
    var getdate = $('#entry_1').val().split("/");

    if ($("#entry_1").val().length == 0) {
        alert("Ingrese la Fecha del Incidente");
        return false;
    } else if ($("#entry_4").val().length == 0) {
        alert("Ingrese la Descripcion del Incidente ");
        return false;
    } else {
        $("#entry_7").attr('value', typeincidente + getdate[0]);
        $("#entry_8").attr('value', typeincidente + getdate[1]);
        $("#entry_9").attr('value', typeincidente + getdate[2]);
        $("#entry_10").attr('value', getdate[0]);
        $("#entry_11").attr('value', getdate[1]);
        $("#entry_12").attr('value', getdate[2]);
        return true;
    }

}