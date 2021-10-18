create table type(
    id serial primary key,
    name varchar(255)
);
create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
	expired_date date,
    price float
);
insert into type(name) values ('СЫР'), ('МЯСО'), ('КРУПА'), ('ФРУКТЫ'), ('Мороженое');
insert into product(name, type_id, expired_date, price) values
	('Российский сыр', 1, date '24-08-2021', 500.00),
	('Датский сыр', 1, date '12-12-2021', 1000.00),
	('Свинина', 2, date '20-09-2021', 300.00),
	('Говядина', 2, date '29-09-2021', 600.00),
	('Крольчатина', 2, date '27-09-2021', 800.00),
	('Курица', 2, date '05-10-2021', 200),
	('Греча', 3, date '22-05-2022', 100.00),
	('Кукуруза', 3, date '12-07-2022', 90.00),
	('Бананы', 4, date '27-10-2021', 100.00),
	('Апельсины', 4, date '05-10-2021', 150),
	('Мороженое пломбир', 5, date '27-12-2021', 60.00),
	('Мороженое шоколодное', 5, date '05-12-2021', 50),
	('Морожение фисташковое', 5, date '12-12-2021', 100);

select * from product;
/*Написать запрос получение всех продуктов с типом "СЫР"*/
select * from product where type_id = select type.id from type where name = 'СЫР';

/*Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"*/
select * from product where name like '%Мороженое%';

/*Написать запрос, который выводит все продукты, срок годности которых уже истек*/
select * from product where expired_date < current_date;

/*Написать запрос, который выводит самый дорогой продукт.*/
select name, price as max_price from product where price = (select max(price) from product);

/*Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество.*/
select t.name, count(*)
from product
join type t on type_id = t.id
group by t.name;

/*Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО".*/
select * from product
where type_id in (
	select type.id from type where name = 'СЫР' or name = 'МОЛОКО'
);

select *
from product
where type_id in (
		select type.id from type where name in ('СЫР', 'МОЛОКО')
);

/*Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.*/
select t.name, count(*)
from product
join type t on type_id = t.id
group by t.name
having count(t.name) < 10;

/*Вывести все продукты и их тип.*/
select p.name as name, t.name as type from product p join type t on p.type_id = t.id;