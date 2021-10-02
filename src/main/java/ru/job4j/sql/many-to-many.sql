create table cars(
     id serial primary key,
     name varchar(255)
);

create table types(
     id serial primary key,
     name varchar(255)
);

create table cars_types(
     id serial primary key,
     car_id int references types(id),
     type_id int references models(id)
);

insert into cars(name) values ('BMW');
insert into cars(name) values ('AUDI');
insert into cars(name) values ('MERCEDES');

insert into types(name) values ('Sedan');
insert into types(name) values ('Coupe');
insert into types(name) values ('Jeep');


insert into cars_types(cars_id, types_id) values (2, 1);
insert into cars_types(cars_id, types_id) values (2, 4);
insert into cars_types(cars_id, types_id) values (2, 2);
insert into cars_types(cars_id, types_id) values (1, 2);
insert into cars_types(cars_id, types_id) values (1, 3);
insert into cars_types(cars_id, types_id) values (1, 4);
insert into cars_types(cars_id, types_id) values (3, 1);
insert into cars_types(cars_id, types_id) values (3, 3);