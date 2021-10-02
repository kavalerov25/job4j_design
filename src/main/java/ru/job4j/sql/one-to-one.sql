create table drive_license(
    id serial primary key,
    seria: int,
    numver:int
);

create table people(
    id serial primary key,
    number varchar(255),
    drive_license_id int references drive_license(id) unique
);