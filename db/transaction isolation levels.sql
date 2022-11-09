create table new_storage(
id serial primary key,
name text,
weight int
);

insert into new_storage(name, weight)
values ('one', 1),
       ('two', 2),
       ('three', 3),
	   ('four', 4);
	   select * from new_storage;

	 --Dirty read. Console 1
	 show transaction isolation level;
     begin;
	 update new_storage
 set name = name || 'one'
 where id = 1;
 select * from new_storage;
 rollback;

 --Dirty read. Console 1
	  begin;
	  select * from new_storage;
	  rollback;

	  --Non repeatable read. Console 1
	  begin;
	  update new_storage
 set name = name || 'one'
 where id = 1;
 select * from new_storage;
	  commit;
	  begin; --begin after set new isolation level on console 2
	  update new_storage
 set name = name || 'one'
 where id = 1;
 select * from new_storage;
	  commit;

	   --Non repeatable read. Console 2
	   begin;
	   select * from new_storage; --error
	   commit;
	   begin transaction isolation level repeatable read;
	   select * from new_storage;
	   select * from new_storage; --select after commit on console 1 is ok
	   commit;
	   select * from new_storage; --updated

	   --Phantom read. Console 1
	   begin transaction isolation level serializable;
	   select avg(weight) from new_storage;
	   update new_storage set weight = 10 where id = 1;
	   commit;


	   --Phantom read. Console 2
	   begin transaction isolation level serializable;
	   select avg(weight) from new_storage;
	   update new_storage set weight = 100 where id = 2;
	   commit;
