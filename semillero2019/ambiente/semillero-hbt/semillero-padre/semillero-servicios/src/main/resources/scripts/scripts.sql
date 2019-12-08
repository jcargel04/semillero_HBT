--Se crea la tabla personaje para luego asocialrla a una entidad, declarando todos los campos como requeridos
--y llave primaria pers_id.
create table personaje (
  pers_id number(10) not null,
  pers_nombre varchar2(50) not null,
  pers_id_comic number(3) not null,
  pers_estado varchar2(50 char) not null,
  pers_superpoder varchar2(200 char) not null,
  constraint "personaje_estado_CHK" check (pers_estado IN('ACTIVO','INACTIVO')),
  constraint "PK_personaje" PRIMARY KEY (pers_id)
);

-- Se crea una sequeencia para asignar un autoincremento en la tabla personaje
create sequence "SEC_PERSONAJE" minvalue 1 start with 1 increment by 2;

--En la tabla personaje se crea una llave foránea con el campo pers_id_comic haciendo refefencia a la tabla comic con el campo SCID.
ALTER TABLE personaje add constraint "FK_PERSONAJE_ID" foreign key (pers_id_comic) references comic (SCID);

--Se insertan datos a la tabla personaje
insert into personaje (pers_id, pers_nombre, pers_id_comic, pers_estado, pers_superpoder, PERS_ROL_ID)
     values (SEC_PERSONAJE.nextval, 'BATMAN', 3, 'ACTIVO', 'MILLONARIO', 001);
commit;


--Se crea la tabla rol para luego asocialrla a una entidad, declarando el campo rol_nombre como UNICO, 
--y llave primaria rol_id
create table rol(
  rol_id number(10) not null,
  rol_nombre varchar(100) not null,
  rol_estado varchar(20) not null,
  constraint "rol_estado_CHK" check (rol_estado IN('ACTIVO','INACTIVO')),
  constraint  rol_nombre_UNI UNIQUE (rol_nombre),
  constraint "PK_rol" PRIMARY KEY (rol_id)
);


--En la tabla personaje se modifica el campo pers_id_comic como UNICO
alter table personaje add constraint pers_id_comic_UNI unique (pers_id_comic);

--En la tabla personaje se modifica el campo pers_nombre como UNICO
alter table personaje add constraint pers_nombre_UNI unique (pers_nombre);

--En la tabla personaje se adiciona el campo pers_rol_id como no nulo
alter table personaje add pers_rol_id number(10) not null;

--En la tabla personaje se crea una llave foránea con el campo pers_rol_id haciendo refefencia a la tabla rol con el campo rol_id;
alter table personaje add constraint "FK_pers_rol_id" foreign key (pers_rol_id) references rol (rol_id);

--Se realizan inserciones de datos en la tabla rol
insert into rol (rol_id, rol_nombre, rol_estado) values (1, 'ACTOR PRINCIPAL', 'ACTIVO');

--select * from personaje;
--select * from rol;
