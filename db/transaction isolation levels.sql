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

	 --Dirty read. Console 1
	 show transaction isolation level;
     begin;
	 update storage
 set name = name || 'one'
 where id = 1;
 select * from storage;
 rollback;

 --Dirty read. Console 1
	  begin;
	  select * from storage;
	  rollback;

	  --Non repeatable read. Console 1
	  begin;
	  update storage
 set name = name || 'one'
 where id = 1;
 select * from storage;
	  commit;
	  begin; --begin after set new isolation level on console 2
	  update storage
 set name = name || 'one'
 where id = 1;
 select * from storage;
	  commit;

	   --Non repeatable read. Console 2
	   begin;
	   select * from storage; --error
	   commit;
	   begin transaction isolation level repeatable read;
	   select * from storage;
	   select * from storage; --select after commit on console 1 is ok
	   commit;
	   select * from storage; --updated

	   --Phantom read. Console 1
	   begin;
	   select * from storage;
	   insert into storage(name) values ('five');
	   commit;
	   begin;
	   select * from storage;
	   insert into storage(name) values ('six');
	   commit;

	   --Phantom read. Console 2
	   begin;
	   select * from storage;
	   select * from storage; --select after insert new item in console 1. ok
	   select * from storage; --select after commit in console 1. not ok
	   commit;
	   begin transaction isolation level serializable;
	   select * from storage;
	   select * from storage; --select after insert new item in console 1. ok
	   select * from storage; --select after commit in console 1. ok
	   commit;
