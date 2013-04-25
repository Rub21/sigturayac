CREATE OR REPLACE FUNCTION insert_punto(idpunto character(40),
				        usuario character(100),
				        nombre character(100),				         
				        fecha character(50),
				        hora character(50),
				        url_img character(100),
				        perfil_img character(100),
				        descripcion  text,
				        tipo character(2),
				        estado boolean,
				        lat numeric,
				        lon numeric				        				            
				        )
RETURNS character(50)
AS $$
DECLARE        
BEGIN
	INSERT INTO punto_desecho(idpunto, usuario, nombre, fecha, hora, url_img, perfil_img, descripcion,tipo,estado)
	VALUES (idpunto, usuario, nombre, fecha, hora, url_img, perfil_img, descripcion,tipo,estado);  
        INSERT INTO geometry(lat, lon, idpunto)
        VALUES (lat, lon, idpunto);
	RETURN 'Insert a Punto';
	
END;
$$ LANGUAGE plpgsql;


select insert_punto('tttttttttttttttttttttttt',  'usruario' ,'nombre ','fecha','hora' ,'url_img' ,' perfil_img' , 'descripcion','t' ,true ,-13.00, -74.00)

CREATE OR REPLACE VIEW select_punto AS
	SELECT p.idpunto, p.usuario, p.nombre, p.fecha, p.hora, p.url_img, p.perfil_img, p.descripcion, p.tipo, p.estado ,p.fecharegistro,g.lat, g.lon
	FROM punto_desecho as p 
	left join geometry as g  on p.idpunto = g.idpunto;	

select idpunto from select_punto where tipo='w'
select idpunto from select_punto where tipo='t';

/*
select insert_punto('324935',
'ediqp8',
'713303390',
'Thu, 18 Apr 2013 17:19:55 +0000',
'null',
'http://pbs.twimg.com/media/BIJm9wKCAAEXy5F.jpg',
' http://a0.twimg.com/profile_images/2426796802/8hevn3ed4dpqx6l8pkh0_normal.jpeg', 
'#aquid alameda http://t.co/vowx23eMSp',
't',true,
-13.16,-74.22);


select insert_punto('324935334204932096t','ediqp8','713303390','Thu, 18 Apr 2013 17:19:55 +0000','null','http://pbs.twimg.com/media/BIJm9wKCAAEXy5F.jpg',' http://a0.twimg.com/profile_images/2426796802/8hevn3ed4dpqx6l8pkh0_normal.jpeg', '#aquid alameda http://t.co/vowx23eMSp','t',true,-13.16728063,-74.22774986);


select insert_punto('idpunto4', 
 'usruario' ,
 'nombre ',
 'fecha',
 'hora' ,
 'url_img' ,
 ' perfil_img' ,
  'descripcion',
  't' ,true 
  ,-13.00, -74.00)
*/



