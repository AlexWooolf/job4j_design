create table position(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    position_id int references position(id)
);

insert into position(name) values
('chief'),
('engineer'),
('worker'),
('manager'),
('janitor');

insert into employees(name, position_id) values
('Oleg', 1),
('Valera', 2),
('Vasya', 3);

select * from position p left join employees e on p.id = e.position_id;

select * from position p right join employees e on p.id = e.position_id;

select * from position p full join employees e on p.id = e.position_id;

select * from position p cross join employees e;

select p.name from position p left join employees e on p.id = e.position_id where e.name is null;

select p.name, e.name from position p right join employees e on p.id = e.position_id;

select p.name, e.name from employees e left join position p on p.id = e.position_id;

create table teens(
	id serial primary key,
    name varchar(255),
	gender  varchar(255)
);

insert into teens(name, gender) values
('Vasya', 'm'),
('Oleg', 'm'),
('Semen', 'm'),
('Olga', 'f'),
('Anna', 'f');

select t1.name, t2.name from teens t1 cross join teens t2 where t1.gender != t2.gender;