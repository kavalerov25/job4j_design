create table address(
    id serial primary key,
    street varchar(255),
    build int,
	flat int
);

create table people(
    id serial primary key,
    name varchar(255),
    address_id int references address(id)
);

insert into address(street, build, flat) values('Nevskii', 2, 10);
insert into address(street, build, flat) values('Nevskii', 2, 11);
insert into address(street, build, flat) values('Nevskii', 2, 12);
insert into address(street, build, flat) values('Nevskii', 2, 13);
insert into address(street, build, flat) values('Borovaya', 1, 14);

insert into people(name, address_id) values ('Kirill', 1);
insert into people(name, address_id) values ('Denis', 1);
insert into people(name, address_id) values ('Georgii', 2);
insert into people(name, address_id) values ('Sveta', 3);
insert into people(name, address_id) values ('Olya', 4);
insert into people(name, address_id) values ('Ira', 5);
insert into people(name, address_id) values ('Oleg', 5);
insert into people(name, address_id) values ('Igor', 5);

select * from people join address ad on people.address_id = ad.id;

select p.name as Имя, ad.street as Улица
	from people as p join address as ad on p.address_id = ad.id;

select p.name as Имя, ad.build as Номер_дома, ad.flat as Номер_квартиры
	from people as p join address as ad on p.address_id = ad.id and ad.street = 'Nevskii';