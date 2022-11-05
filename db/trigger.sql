create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function nologi()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create or replace function nologi_now()
    returns trigger as
$$
    BEGIN
        update products
        new.price = new.price + new.price * 0.2
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create or replace function history()
    returns trigger as
$$
    BEGIN
        insert into price_history(name, price, date)
		values (new.name, new.price, current_date);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';



create trigger ploti_nologi_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure nologi();



create trigger ploti_nologi_now_trigger
    before insert
    on products
    for each row
    execute procedure nologi_now();

create trigger price_history
    after insert
    on products
    for each row
    execute procedure history();


