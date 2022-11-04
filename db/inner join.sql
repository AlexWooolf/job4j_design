create table driver(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255),
	driver_id int references driver(id)
);

insert into driver(name) values ('Oleg');
insert into driver(name) values ('Vasya');
insert into car(name, driver_id) values ('Ferrari', 1);
insert into car(name, driver_id) values ('Lada', 2);

select * from driver;
select * from car;

select *
from driver join car on car.driver_id = driver.id;

select drvr.name, cr.name
from driver as drvr join car as cr on cr.driver_id = drvr.id;

select drvr.name as Водитель, cr.name as Машина
from driver as drvr join car as cr on cr.driver_id = drvr.id;

select drvr.name as Водитель, cr.name as "Машина"
from driver as drvr join car as cr on cr.driver_id = drvr.id;
