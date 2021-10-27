--1. Создать структур данных в базе.
create table body(
    id serial primary key,
    name varchar(255)
);

create table engine(
	id serial primary key,
    name varchar(255)
);

create table gearbox(
	id serial primary key,
    name varchar(255)
);

--2. Создать структуру Машина. Машина не может существовать без данных из п.1.
create table car(
    id serial primary key,
    name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
    gearbox_id int references gearbox(id)
);

--2. Заполнить таблицы через insert.
insert into body (name) values
	('sedan'), ('coupe'), ('crossover'), ('roadster'), ('cabriolet'), ('jeep');
insert into engine (name) values
	('engine-1'), ('engine-2'), ('engine-3'), ('engine-4'), ('engine-5');
insert into gearbox (name) values
	('gearbox-1'), ('gearbox-2'), ('gearbox-3'), ('gearbox-4'), ('gearbox-5');

insert into car (name, body_id, engine_id, gearbox_id) values
	('Car-1', 2, 3, 1),
	('Car-2', 3, 1, 4),
	('Car-3', 4, 4, 3),
	('Car-4', 1, 2, 5);

--1) Вывести список всех машин и все привязанные к ним детали.
select
	car.name as car, b.name as body, e.name as engine, g.name as gearbox
from
	car
join body b on car.body_id = b.id
join engine e on car.engine_id = e.id
join gearbox g on car.gearbox_id = g.id
group by car.name, b.name, e.name, g.name
order by car.name;

--2) Вывести отдельно детали (1 деталь - 1 запрос),
--которые не используются НИ в одной машине, кузова, двигатели, коробки передач.
select b.name as not_used
from body b
left join car c on c.body_id = b.id where c.body_id is null;

select e.name as not_used
from engine e
left join car c on c.engine_id = e.id where c.engine_id is null;

select g.name as not_used
from gearbox g
left join car c on c.gearbox_id = g.id where c.gearbox_id is null;