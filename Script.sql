/**Nota: no olvide colocar las llaves foraneas en cascada**/

create database bd_hibernate3;
use bd_hibernate3;

create table mascotas
(id_mascota int(11) NOT NULL auto_increment,
nombre varchar(45) not null,
raza varchar(45) default null,
color varchar(45) default null,
sexo varchar(45) default null,
primary key (id_mascota)
)engine=InnoDB auto_increment=6 default charset=utf8mb4;


create table persona
(id_persona int(11) not null,
nombre_persona varchar(45) default null,
profesion_persona varchar(45) default null,
telefono_persona varchar(45) default null,
tipo_persona int(2) not null,
nacimiento_id int(11) not null,
primary key (id_persona)
);

create table nacimiento
(id_nacimiento int(11) not null auto_increment,
ciudad_nacimiento varchar(45) default null,
departamento_nacimiento varchar(45) default null,
fecha_nacimiento date default null,
pais_nacimiento varchar(45) default null,

primary key (id_nacimiento)
);

alter table persona
add index fk_persona_nacimiento(nacimiento_id Asc);
;
alter table persona
add constraint fk_persona_nacimiento
foreign key (nacimiento_id)
references nacimiento(id_nacimiento)
on delete no action
on update no action; 

/*======================================================*/

alter table bd_hibernate3.mascotas
add column persona_id int(11) null after sexo;

alter table  bd_hibernate3.mascotas
add index fk_mascotas_personas_idx(persona_id ASC);
;
alter table bd_hibernate3.mascotas
add constraint fk_mascotas_persona
foreign key (persona_id)
references bd_hibernate3.persona (id_persona)
on delete no action
on update no action;


/*=================================================================*/

create table productos
(id_producto int(11) not null auto_increment,
nombre_producto varchar(45) not null,
precio_producto double default null,
primary key(id_producto)
)engine=InnoDB default charset=utf8mb4;

CREATE TABLE persona_productos(
persona_id INT(11)not null,
producto_id INT(11)not null,
key FK_producto (producto_id),
key FK_persona (persona_id),
constraint FK_producto foreign key (producto_id) references productos (id_producto),
constraint FK_persona foreign key (persona_id) references persona (id_persona)
)engine=InnoDB default charset=utf8mb4;
