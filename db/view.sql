create table car_bodies(
id serial primary key,
name text
);

create table car_engines(
id serial primary key,
name text
);

create table car_transmissions(
id serial primary key,
name text
);

create table cars(
id serial primary key,
name text,
car_bodies_id int references car_bodies(id),
car_engines_id int references car_engines(id),
car_transmissions_id int references car_transmissions(id)
);

insert into car_bodies(name)
values ('седан'),
       ('купе'),
       ('универсал'),
       ('внедорожник'),
       ('пикап'),
       ('минивэн');

insert into car_engines(name)
values ('бензиновый'),
       ('дизельный'),
       ('электрический'),
       ('водородный');

insert into car_transmissions(name)
values ('механическая'),
       ('автоматическая'),
       ('вариатор'),
       ('робот');

insert into cars(name, car_bodies_id, car_engines_id, car_transmissions_id)
values ('Ford Mustang', 2, 1, 2),
       ('Porsche Cayenne', 4, null, 2),
       ('Audi A4 Alldoad', 3, 1, 4);


create view show_cars as
select c.name car, b.name body, e.name engine ,t.name transmission from cars c
left join car_bodies b on c.car_bodies_id = b.id
left join car_engines e on c.car_engines_id = e.id
left join car_transmissions t on c.car_transmissions_id = t.id;

select * from show_cars;