insert into role(name) values ('Velikiy Kombinator')
insert into users(name, role_id) values ('Ostap Bender', 1);
insert into rules(name) values ('Main hero');
insert into role_rules(role_id, rule_id) values (1, 1);
insert into category(name) values ('WTF');
insert into state(name) values ('in progress');
insert into item(name, user_id, category_id, state_id) values ('12 chairs', 1, 1, 1);
insert into comments(name, item_id) values ('the ice is started', 1);
insert into attachs(name, item_id) values ('Kisa', 1);
