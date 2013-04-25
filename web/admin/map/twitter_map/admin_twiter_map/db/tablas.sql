--DROP DATABASE dbdesechos;
CREATE DATABASE db_desechos4;

CREATE TABLE punto_desecho(
	idpunto varchar(40) NOT NULL  PRIMARY KEY,
	usuario  character(100),
	nombre  character(100),
	fecha  character(50),
	hora character(50),
	url_img character(100),
	perfil_img character(100),
	descripcion text,
	tipo character(2),
	estado boolean,		
	fecharegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP  
);

CREATE TABLE geometry(
  lat numeric,
  lon numeric,  
  idpunto varchar(40)
);


alter table geometry
add constraint fk_idpunto_geometry
Foreign key (idpunto)
references punto_desecho(idpunto);

/********************************
Login
*********************************/
CREATE TABLE login(
	idusuario  VARCHAR(10) NOT NULL PRIMARY KEY,
	nombre VARCHAR(80) ,
	apellidos VARCHAR(80) ,
	usuario varchar(20) NOT NULL unique,
	contrasenia text not null unique,	
	estado boolean not null,
	fecharegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
 );


INSERT INTO login(idusuario, nombre, apellidos, usuario, contrasenia, estado)
    VALUES ('1u','Ruben','Lopez Mendoza','Rub21','1234',true);


