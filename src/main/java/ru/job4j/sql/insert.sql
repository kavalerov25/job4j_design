insert into role(role) values('Admin');
insert into role(role) values('User');

insert into rules(rule) values('Create');
insert into rules(rule) values('delete');
insert into rules(rule) values('edit');
insert into rules(rule) values('update');


insert into role_rules(role_id, rules_id)values ('1', '1');
insert into role_rules(role_id, rules_id)values ('1', '2');
insert into role_rules(role_id, rules_id)values ('1', '3');
insert into role_rules(role_id, rules_id)values ('2', '1');

insert into category(name) values('high');
insert into category(name) values('low');
insert into category(name) values('medium');

insert into state(name) values('new');
insert into state(name) values('in work');
insert into state(name) values('done');


