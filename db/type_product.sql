create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type(name) values
('СЫР'),
('МОЛОКО'),
('ПИВО');

insert into product(name, type_id, expired_date, price) values
('ГАУДА', 1, '2020-01-01', 100),
('ЖИРНОЕ', 2, '2020-01-02', 10),
('ПШЕНИЧНОЕ', 3, '2020-01-03', 50),
('ВКУСНОЕМОРОЖЕНОЕ', 3, '2020-01-03', 50);

select *
from product as p
join type as t on p.type_id = t.id
where t.name = 'СЫР';

select *
from product where name LIKE '%МОРОЖЕНОЕ%';

select *
from product where expired_date < current_date;

select *
from product where price =
(select max(price) from product);

select t.name, count(p)
from type as t
join product as p on t.id = p.type_id
group by t.name;

select *
from product as p
join type as t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name
from type as t
join product as p on t.id = p.type_id
group by t.name
having count(p) < 10;

select *
from product p
join type t on p.type_id = t.id;