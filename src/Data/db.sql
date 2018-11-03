
    
CREATE TABLE persona(  
	id bigserial NOT NULL,         	 
	nombre character varying(40) NOT NULL, 	
	telefono integer NOT NULL,                  	
	nacionalidad character varying(25) NOT NULL,
	ci character varying(8) NOT NULL, 	
	direccion character varying(40),
 	tipo character varying(2),
 	
	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id)
);

CREATE TABLE usuario(  
	id bigserial NOT NULL,
	id_persona integer NOT NULL,
	correo character varying(40) NOT NULL, 		
	password character varying(40) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_persona) REFERENCES persona (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT 
);

CREATE TABLE evento(  
	id bigserial NOT NULL,   	 
	titulo character varying(100) NOT NULL,
	fecha_inicio character varying(15) NOT NULL,
	fecha_fin character varying(15) NOT NULL,
	costo float NOT NULL,
	tipo char(1) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id)
);

CREATE TABLE reserva(  
	id bigserial NOT NULL,
	id_persona integer NOT NULL,
	id_evento integer NOT NULL,   	 
	fecha character varying(15) NOT NULL, 	

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_persona) REFERENCES persona (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	FOREIGN KEY (id_evento) REFERENCES evento (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE objetivos(  
	id bigserial NOT NULL,
	id_evento integer NOT NULL,
	nombre character varying(40) NOT NULL,   	 
	descripcion character varying(512) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_evento) REFERENCES evento (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE requisitos(  
	id bigserial NOT NULL,
	id_evento integer NOT NULL,  	 
	descripcion character varying(512) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_evento) REFERENCES evento (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE modo_pago(  
	id bigserial NOT NULL,
	id_evento integer NOT NULL,   	 
	descripcion character varying(512) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_evento) REFERENCES evento (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE cronograma(  
	id bigserial NOT NULL,
	id_evento integer NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_evento) REFERENCES evento (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE dia(  
	id bigserial NOT NULL,
	dia character varying(15) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id)

);


CREATE TABLE lugar(  
	id bigserial NOT NULL,
	descripcion character varying(512) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id)
);


CREATE TABLE horario(  
	id bigserial NOT NULL,
	id_cronograma integer NOT NULL,
	id_dia integer NOT NULL,
	id_lugar integer NOT NULL,
	inicio character varying(15) NOT NULL,
	fin character varying(15) NOT NULL,
	
	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_cronograma) REFERENCES cronograma (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	FOREIGN KEY (id_dia) REFERENCES dia (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	FOREIGN KEY (id_lugar) REFERENCES lugar (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE contenido(  
	id bigserial NOT NULL,
	id_evento integer NOT NULL,
	titulo character varying(100) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_evento) REFERENCES evento (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE detalle_contenido(  
	id bigserial NOT NULL,
	id_contenido integer NOT NULL,
	descripcion character varying(512) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_contenido) REFERENCES contenido (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE disertante(  
	id bigserial NOT NULL,
	id_evento integer NOT NULL,
	nombre character varying(100) NOT NULL,
	foto character varying(4096),
	nacionalidad character varying(20),
	descripcion character varying(512) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_evento) REFERENCES evento (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE venta(  
	id bigserial NOT NULL,
	id_evento integer NOT NULL,
	fecha character varying(20) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id)
);

CREATE TABLE detalle_venta(  
	id bigserial NOT NULL,
	id_evento integer NOT NULL,
	id_usuario integer NOT NULL,
	id_persona integer NOT NULL,
	id_venta integer NOT NULL,
	nro_comprobante character varying(40) NOT NULL,
	fecha_comprobante character varying(40) NOT NULL,

	created_at character varying(14),
	updated_at character varying(14),
	deleted_at character varying(14),

	PRIMARY KEY(id),
	FOREIGN KEY (id_evento) REFERENCES evento (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	FOREIGN KEY (id_usuario) REFERENCES usuario (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	FOREIGN KEY (id_persona) REFERENCES persona (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	FOREIGN KEY (id_venta) REFERENCES venta (id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT

);




