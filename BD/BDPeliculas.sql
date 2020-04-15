CREATE DATABASE Peliculas;
USE Peliculas;
CREATE TABLE usuario(
  nombreUsuario VARCHAR(30) PRIMARY KEY,
  contrasena VARCHAR(30),
  nombre VARCHAR (40),
  apellido VARCHAR (40),
  edad INT,
  correo VARCHAR (50)
);


CREATE TABLE genero(
id INT AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR (20)

);

CREATE TABLE peliculasDisponibles(
nombrePelicula  VARCHAR (50) PRIMARY KEY,
director VARCHAR (40),
anoEstreno INT,
idGenero INT, 
FOREIGN KEY (idGenero) REFERENCES genero(id)
);


CREATE TABLE peliculasFavoritas(
nombreUsuario VARCHAR (30),
nombrePelicula VARCHAR (50),
PRIMARY KEY (nombreUsuario, nombrePelicula),
FOREIGN KEY(nombreUsuario) REFERENCES usuario(nombreUsuario),
FOREIGN KEY(nombrePelicula) REFERENCES peliculasDisponibles(nombrePelicula)
);

/*Generos*/
INSERT genero(tipo)
VALUES ("Terror");
INSERT genero(tipo)
VALUES ("Comedia");
INSERT genero(tipo)
VALUES ("Romance");
INSERT genero(tipo)
VALUES ("Accion");
INSERT genero(tipo)
VALUES ("Drama");
INSERT genero(tipo)
VALUES ("Anime");
INSERT genero(tipo)
VALUES ("Ciencia ficcion");

/*Peliculas disponibles*/
/*Terror*/
INSERT peliculasDisponibles
VALUES ("La noche del demonio","James Wan",2011,1);
INSERT peliculasDisponibles
VALUES ("Anabelle", "John R. Leonetti",2014,1);
INSERT peliculasDisponibles
VALUES ("The Conjuring", "James Wan",2013,1);

/*Comedia*/
INSERT peliculasDisponibles
VALUES ("La mascara","Chuck Russell",1994,2);
INSERT peliculasDisponibles
VALUES ("Deadpool","Tim Miller",2016,2);
INSERT peliculasDisponibles
VALUES ("The Hangover","Todd Phillips",2009,2);

/*Romance*/
INSERT peliculasDisponibles
VALUES("Titanic","James Cameron",1998,3);
INSERT peliculasDisponibles
VALUES("The notebook","Nick Cassavetes",2004,3);
INSERT peliculasDisponibles
VALUES("A Walk to Remember","Adam Shankman",2002,3);

/*Accion*/
INSERT peliculasDisponibles
VALUES ("The Fast and the Furious","Rob Cohen",2001,4);
INSERT peliculasDisponibles
VALUES ("Fight Club"," David Fincher",1999,4);
INSERT peliculasDisponibles
VALUES ("Soldado universal"," Roland Emmerich",1992,4);

/*Drama*/
INSERT peliculasDisponibles
VALUES ("El niño con el pijama de rayas","Mark Herman",2008,5);
INSERT peliculasDisponibles
VALUES ("En busca de la felicidad","Gabriele Muccino",2007,5);
INSERT peliculasDisponibles
VALUES ("Siete almas","Gabriele Muccino",2008,5);

/*Anime*/
INSERT peliculasDisponibles
VALUES ("Haru en el reino de los gatos","Hiroyuki Morita",2002,6);
INSERT peliculasDisponibles
VALUES ("Mi vecino Totoro","Hayao Miyazaki",1988,6);
INSERT peliculasDisponibles
VALUES ("El viaje de Chihiro","Hayao Miyazaki",2003,6);

/*Ciencia ficcion*/
INSERT peliculasDisponibles
VALUES ("Odisea espacial","Stanley Kubrick",2001,7);
INSERT peliculasDisponibles
VALUES ("Interestelar","Christopher Nolan",2014,7);
INSERT peliculasDisponibles
VALUES ("Predestination","Michael Spierig",2014,7);

/*Consultas*/
SELECT *FROM peliculasDisponibles;
