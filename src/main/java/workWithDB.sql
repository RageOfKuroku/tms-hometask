
--Создание всех таблиц
create table person(
                       id integer primary key,
                       name varchar,
                       isMale boolean,
                       dateOfBirth date
);

create table hobbyType(
                          id integer primary key,
                          hobbyType varchar
);


create table hobby(
                      id integer primary key,
                      hobbyName varchar,
                      hobbyTypeId integer constraint fk_hobbyType references hobbyType(id)
);

create table info(
                     id integer primary key,
                     personID integer constraint fk_person references person(id),
                     hobbyID integer constraint fk_hobby references hobby(id)
);
--Удаление всех таблиц
drop table info;
drop table hobby;
drop table hobbyType;
drop table person;
--Заполнения всех таблиц
insert into person (id, name, isMale, dateOfBirth) values
                                                       (1, 'John', true, '1999-01-08' ),
                                                       (2, 'Camille', false, '2000-02-03' ),
                                                       (3, 'Jhin', true, '2003-05-23'),
                                                       (4, 'Milio', true, '2010-04-14'),
                                                       (5, 'Ezreal', true, '2004-06-26'),
                                                       (6, 'Irelia', false, '2003-07-31'),
                                                       (7, 'Kayn', true, '2004-09-28'),
                                                       (8, 'Zoe', false, '1500-10-12'),
                                                       (9, 'Lux', false, '2004-12-19'),
                                                       (10, 'Senna', false, '2000-11-11');
insert into hobbyType (id, hobbyType) values
                                          (1, 'active'),
                                          (2, 'passive');
insert into hobby (id, hobbyName, hobbyTypeId) values
                                                   (1, 'supporting for adc <3', 1),
                                                   (2, 'farming minions', 2),
                                                   (3, 'jungle adventure', 1),
                                                   (4, 'poking enemies', 1),
                                                   (5, 'playing league', 2);
insert into info (id, personid, hobbyid) values
                                             (1,1,5),
                                             (2,2,2),
                                             (3,3,2),
                                             (4,4,1),
                                             (5,5,2),
                                             (6,6,2),
                                             (7,7,3),
                                             (8,8,4),
                                             (9,9,4),
                                             (10,10,1),
                                             (11,10,4),
                                             (12,5,4),
                                             (13,9,1);





--Вывести всех людей старше какого-либо возраста
select * from person
where extract(year from age(current_date, dateOfBirth)) > 18;

--Вывести сколько людей каждого пола есть в бд
select p.isMale, count(*) from person p group by p.isMale;

--Вывести информацию о людях и их хобби
select p.name, p.isMale, p.dateOfBirth, h.hobbyName
from person p
         join info i on p.id = i.personID
         join hobby h on h.id = i.hobbyID;

--Вывести список людей у которых более одного хобби
select p.name, count(*)
from person p
         join info i on p.id = i.personID
         join hobby h on h.id = i.hobbyID
group by p.name having count(*) > 1;

--Вывести какое количество активных хобби и пассивных хобби есть в бд
select hT.hobbyType ,count(*)
from hobbyType hT
         join hobby h on hT.id = h.hobbyTypeId
group by hT.hobbyType;

--Вывести информацию какое хобби активное а какое пассивное
select hobbyName, hT.hobbyType
from hobby h
         join hobbyType hT on h.hobbyTypeId = hT.id
















