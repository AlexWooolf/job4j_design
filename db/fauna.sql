create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('bigfish', 5, '01-01-2020');
insert into fauna (name, avg_age, discovery_date) values ('smallfish', 1, '02-01-2020');
insert into fauna (name, avg_age, discovery_date) values ('cat', 15, '10-01-1000');
insert into fauna (name, avg_age, discovery_date) values ('dog', 10, null);

select * from fauna where name LIKE '%fish%';
select * from fauna where 21000 > avg_age and avg_age > 10000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01-01-1950';