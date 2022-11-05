create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace procedure delete_data(i_name varchar)
language 'plpgsql'
as $$
    BEGIN
    delete from products where (i_name = name);
    END
$$;

create or replace function f_delete_data(i_name varchar)
returns void
language 'plpgsql'
as
$$
    begin
        delete from products where (i_name = name);
    end;
$$;