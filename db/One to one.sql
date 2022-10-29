create table serialnumber(
	id serial primary key,
	number int
);

create table car(
	id serial primary key,
	name varchar(255),
	serialnumber_id int references serialnumber(id) unique
);

insert into serialnumber(number) values(100500);
insert into car(name, serialnumber_id) values ('AudiA6', 1);