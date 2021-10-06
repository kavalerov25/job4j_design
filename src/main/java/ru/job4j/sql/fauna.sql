create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date)
	values('icefish',10000, date '1100-10-02');
insert into fauna (name, avg_age, discovery_date)
	values('milkfish', 15000, date '1200-11-12');
insert into fauna (name, avg_age, discovery_date)
	values('croaker', 20000, date '1300-01-01');
insert into fauna (name, avg_age, discovery_date)
	values('pilchard', 35000, date '1400-02-02');
insert into fauna (name, avg_age, discovery_date)
	values('carp', 40000, date '1500-04-04');
insert into fauna (name, avg_age, discovery_date)
	values('smelt', 45000, null);

select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < date '1950-01-01';