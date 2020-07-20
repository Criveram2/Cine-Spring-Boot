DROP TABLE IF EXISTS Banners;

CREATE SEQUENCE banners_id_seq;

CREATE TYPE estatus_Banners AS ENUM ('Activo', 'Inactivo');

CREATE TABLE Banners (
  id_banner  integer NOT NULL DEFAULT nextval('banners_id_seq'),
  titulo varchar(250) NOT NULL,
  fecha date NOT NULL,
  archivo varchar(250) NOT NULL,
  estatus estatus_Banners,
  PRIMARY KEY (id_banner)
) ;
ALTER SEQUENCE banners_id_seq OWNED BY Banners.id_banner;


DROP TABLE IF EXISTS Detalles;

CREATE SEQUENCE detalles_id_seq;

CREATE TABLE Detalles (
  id_detalle integer NOT NULL DEFAULT nextval('detalles_id_seq'),
  director varchar(100)  DEFAULT NULL,
  actores varchar(255) DEFAULT NULL,
  sinopsis varchar(1048) DEFAULT NULL,
  trailer varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_detalle)
);
ALTER SEQUENCE detalles_id_seq OWNED BY Detalles.id_detalle;




DROP TABLE IF EXISTS Noticias;

CREATE SEQUENCE noticias_id_seq;

CREATE TABLE Noticias (
  id_noticia integer NOT NULL  DEFAULT nextval('noticias_id_seq'),
  titulo varchar(250) NOT NULL,
  fecha date NOT NULL,
  detalle text NOT NULL,
  estatus varchar(8) NOT NULL,
  PRIMARY KEY (id_noticia)
);



DROP TABLE IF EXISTS Horarios;

CREATE SEQUENCE horarios_id_seq;

CREATE TABLE Horarios (
  id_Horario integer  NOT NULL DEFAULT nextval('horarios_id_seq'),
  fecha date NOT NULL,
  hora time NOT NULL,
  sala varchar(100) NOT NULL,
  precio double precision NOT NULL DEFAULT '0',
  idPelicula integer  REFERENCES Peliculas(id_Pelicula),
  PRIMARY KEY (id_Horario)
) ;




DROP TABLE IF EXISTS Peliculas;

CREATE SEQUENCE peliculas_id_seq;

CREATE TYPE estatus_Pelicula AS ENUM ('Activo', 'Inactivo');
CREATE TYPE estatus_clasificacion AS ENUM ('A','B','C');

CREATE TABLE Peliculas (
  id_Pelicula integer NOT NULL DEFAULT nextval('peliculas_id_seq'),
  titulo varchar(150) NOT NULL,
  duracion integer NOT NULL,
  clasificacion varchar(2) NOT NULL,
  genero varchar(45) NOT NULL,
  imagen varchar(200) DEFAULT NULL,
  fechaEstreno date NOT NULL,
  estatus varchar(8) not NULL ,
  id_Detalle integer REFERENCES Detalles(id_detalle),
  PRIMARY KEY (id_Pelicula)
) 

DROP TABLE IF EXISTS Usuarios;

CREATE SEQUENCE Usuarios_id_seq;

CREATE TABLE Usuarios (
  id_usuario integer NOT NULL DEFAULT nextval('Usuarios_id_seq'),
  nombre varchar(150) NOT NULL,
  email varchar(50) NOT NULL,
  username varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE  (username)
) ;

DROP TABLE IF EXISTS UsuarioPerfil;

CREATE SEQUENCE Perfil_id_seq;

CREATE TABLE UsuarioPerfil (
  id_perfil integer NOT NULL DEFAULT nextval('Perfil_id_seq'),
  id_usuario integer REFERENCES Usuarios(id_usuario),
  perfil varchar(50) NOT NULL,
  PRIMARY KEY (id_perfil));




