
/*jQuery.validator.setDefaults({
    debug: true,
    success: "valid"
});*/
$(document).ready(function() {
    $("#form-r").validate({
        rules: {
            name: {required: true,  maxlength: 100},
            traveling_distance: {maxlength: 100},
            entry_cost: {maxlength: 100},
            opening_hours: {maxlength: 100},
            temperatura: {maxlength: 100},
            // how_get: {},       
            lat: {required: true, number: true},
            lon: {required: true, number: true
            }
        },
        messages: {
            name: "Por favor, ingrese el nombre",
            traveling_distance: "Por favor,  escriba menos de 100 caracteres.",
            entry_cost: "Por favor,  escriba menos de 100 caracteres.",
            opening_hours: "Por favor,  escriba menos de 100 caracteres.",
            temperatura: "Por favor,  escriba menos de 100 caracteres.",
            // how_get: {},       
            lat: "Por favor, ingrese numeros",
            lon: "Por favor, ingrese numeros"
        }

    });
    
        $("#form-h").validate({
        rules: {
            name: {required: true,  maxlength: 100},
            traveling_distance: {maxlength: 100},
            entry_cost: {maxlength: 100},
            opening_hours: {maxlength: 100},
            temperatura: {maxlength: 100},
            // how_get: {},       
            lat: {required: true, number: true},
            lon: {required: true, number: true
            }
        },
        messages: {
            name: "Por favor, ingrese el nombre",
            traveling_distance: "Por favor,  escriba menos de 100 caracteres.",
            entry_cost: "Por favor,  escriba menos de 100 caracteres.",
            opening_hours: "Por favor,  escriba menos de 100 caracteres.",
            temperatura: "Por favor,  escriba menos de 100 caracteres.",
            // how_get: {},       
            lat: "Por favor, ingrese numeros",
            lon: "Por favor, ingrese numeros"
        }

    });
    
    
    
});
