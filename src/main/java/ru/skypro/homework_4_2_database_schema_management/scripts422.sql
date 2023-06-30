--спроектировать таблицы, связи между ними и корректно определить типы данных.
create table cars
(
    id    serial primary key,
    brand varchar(15) not null,
    model varchar(15) not null,
    price integer     not null
);

create table persons
(
    id                serial primary key,
    name              varchar(15) not null,
    age               integer     not null,
    has_Driver_Licences boolean     not null,
    car_id            integer references cars (id)
);

insert into cars (brand, model, price)
values ('BMW', 'X5', 5000000),
       ('Lada', '07', 150000),
       ('Volga', '2410', 2000000);

insert into persons (name, age, hasDriver_Licences, car_id)
values ('IVAN IVANOV, 28', true, 1),
       ('ALEKEY ALEKSEEV', 23, true, 2),
       ('SERGEY SERGEEV', 25, true, 3),
       ('SERGEY ALEKSEEV', 20, true, 3)