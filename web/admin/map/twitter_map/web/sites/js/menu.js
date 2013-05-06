function menu_pendientes() {
    var monthNames = [
        'Enero',
        'Febrero',
        'Marzo',
        'Abril',
        'Mayo',
        'Junio',
        'Julio',
        'Agosto',
        'Setiembre',
        'Octubre',
        'Noviembre',
        'Diciembre'
    ];
    mm_date(menu);
    function menu(f) {
        $('#accordion_moth').empty();

        for (i = f.length - 1; i >= 0; i--) {

            if (f[i].length > 0) {
                var m = '';
                if (i <= 9) {
                    m = '0' + (i + 1);
                } else {
                    m = i + '';
                }

                var html_month = '<div class="accordion-group">' +
                        '<div class="accordion-heading">' +
                        '<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion_moth" href="#collapse' + m + '">' +
                        monthNames[i] + ' del 2013' +
                        '</a>' +
                        '</div>' +
                        '<div id="collapse' + m + '" class="accordion-body collapse">' +
                        '<ul id="month' + m + '" class="dropdown-menu accordion-inner">' +
                        '</ul>' +
                        '</div>' +
                        '</div>';

                $('#accordion_moth').append(html_month);

                var li = '';
                for (j = 0; j < f[i].length; j++) {

                    var d = f[i][j];
                    if (d <= 9) {
                        d = '0' + d;
                    }



                    li += '<li><a class="select_pentiente" id="' + d + '/' + m + '/2013" href="#">' + d + '/' + m + '/2013</a></li>';
                }
                $('#month' + m).append(li);



            }
        }
 
    }

}