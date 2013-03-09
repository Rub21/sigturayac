function carrucel_images(aray,id_parent,size){
     
    $('#'+id_parent).append('<div id="myCarousel" class="carousel slide"><div>');
    $('#myCarousel').append('<ol class="carousel-indicators"><ol>');
    $('#myCarousel').append('<div class="carousel-inner"></div>');

    for (var i =0 ; i<aray.length; i++) {
        var ol='';
        var img='';

        if(i==0){ 
     
            ol = '<li data-target="#myCarousel" data-slide-to="'+i+'" class="active"></li>';
            img = ' <div class="item active"> <img src="'+aray[i].url+'"  style=" width:'+size+'px; height: auto;"/>'+
            '<div class="carousel-caption">  <h3>'+aray[i].titulo+'</h3> <p>'+aray[i].descripcion+'</p> </div> </div>';
        }else{

            ol = '<li data-target="#myCarousel" data-slide-to="'+i+'"></li>';
            img = ' <div class="item"> <img src="'+aray[i].url+'"  style=" width:'+size+'px; height: auto;"/>'+
            '<div class="carousel-caption">  <h3>'+aray[i].titulo+'</h3>  </div> </div>'; //<p>'+aray[i].descripcion+'</p> 
        }   
        $('.carousel-indicators').append(ol);
        $('.carousel-inner').append(img);
    }
    $('#myCarousel').append('<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>');
    $('#myCarousel').append('<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>');

    $('#myCarousel').css("width",size);
}
