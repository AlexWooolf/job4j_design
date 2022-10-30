create table countries(
	id serial primary key,
	name varchar(255)
);

create table cities(
	id serial primary key,
	name varchar(255),
	countries_id int references countries(id)
);

insert into countries(name) values ('Russia');
insert into cities(name, countries_id) values('Moscow', 1);


