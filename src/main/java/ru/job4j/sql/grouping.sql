create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);


insert into devices (name, price) values
('Smartphone One', 100000),
('Smartphone Two', 90000),
('Smartphone Tree', 80000),
('Smartphone Four', 70000);


insert into people (name) values
('Kirill'),
('Stas'),
('Denis'),
('Alex');


insert into devices_people (device_id, people_id) values
(1, 1),
(4, 1),
(2, 2),
(2, 3),
(3, 4);


select avg(price) from devices;


select p.name, avg(d.price)
from people as p
join devices_people dp
on p.id = dp.people_id
join devices as d
on d.id = dp.device_id
group by p.name;


select p.name, avg(d.price)
from people as p
join devices_people dp
on p.id = dp.people_id
join devices as d
on d.id = dp.device_id
group by p.name
having avg(d.price) > 5000;