create table cities(
	id serial primary key,
	name varchar(255)
);

create table countries(
	id serial primary key,
	name varchar(255),
	cities_id int references cities(id)
);

insert into cities(name) values('Moscow');
insert into countries(name, cities_id) VALUES ('Russia', 1);

select * from countries;

select * from cities where id in (select cities_id from countries);

