create table storage(
id serial primary key,
name text
);

insert into storage(name)
values ('one'),
       ('two'),
       ('three'),
	   ('four');
	   select * from storage;

begin;
	   delete from storage;
	   select * from storage;
	   rollback;
	   select * from storage;
	    insert into storage(name) values ('seven');
		select * from storage;
		savepoint point_one;
		insert into storage(name) values ('eight');
		select * from storage;
		rollback to point_one;
		select * from storage;
	  commit;

