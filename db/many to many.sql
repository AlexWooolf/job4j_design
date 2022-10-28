create table movies(
	id serial primary key,
	name varchar(255)
);

create table actors(
	id serial primary key,
	name varchar(255),
);

create table actors_movies(
	id serial primary key,
	movies_id int references movies(id),
	actors_id int references actors(id)
);


insert into actors(name) values ('DiCaprio');
insert into actors(name) values ('Pitt');
insert into movies(name) values ('Revenant');
insert into movies(name) values ('Once Upon a Time... in Hollywood');
insert into actors_movies(movies_id, actors_id) values (1, 1);
insert into actors_movies(movies_id, actors_id) values (1, 2);
insert into actors_movies(movies_id, actors_id) values (2, 2);