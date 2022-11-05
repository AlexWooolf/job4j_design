create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values
('iphone', 100500),
('samsung', 100499),
('lg', 500),
('nokia', 100);


insert into people(name) values
('Oleg'),
('Petr'),
('Vasya');

insert into devices_people(device_id, people_id) values
(1, 1),
(2, 2),
(3, 3),
(4,1);

select avg(price) from devices as d;

select p.name, avg(d.price)
from devices_people as dp
join devices as d on dp.device_id = d.id
join people as p on dp.people_id = p.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
join devices as d on dp.device_id = d.id
join people as p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000;