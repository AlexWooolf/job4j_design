create table sports(
	id serial primary key,
	name varchar(255),
	olympic boolean,
	season text
);
insert into sports(name, olympic, season) values('Snowboarding', true, 'winter');
update sports set season = 'summer';
delete from sports;