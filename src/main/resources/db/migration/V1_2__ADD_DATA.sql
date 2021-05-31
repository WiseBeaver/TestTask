insert into air_company (name,company_type,founded)
values ('Tiny Airlines','MAJOR','2016-01-25'),
       ('USA Airlines','NATIONAL','2010-08-13'),
       ('Austrian Airlines','REGIONAL','1998-10-18');

insert into airplane(name, factory_serial_number, air_company_id, number_of_flights, flight_distance, fuel_capacity, type, created)
values ('AN-124','H8JK3L',1,34,8018,117,'TRANSPORT_PLANE','2013-01-25 10:05:00'),
       ('Boeing 777','K7L9KI',1,23,9870,120,'PASSENGER_PLANE','2011-02-25 18:55:00'),
       ('Airbus A380','PR5FKL',2,67,10000,114,'PASSENGER_PLANE','2016-01-27 13:00:00'),
       ('Airbus A350-900','PR5FKJ',3,34,14000,150,'PASSENGER_PLANE','2011-04-12 19:00:00');

insert into flight(flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, ended, delay_started, started, created)
values ('PENDING',1,1,'INDIA','ENGLAND',7544,'4:50',null,null,null,CURRENT_DATE),
       ('DELAYED',1,2,'UKRAINE','SPAIN',3750,'3:20',null,'2021-04-12 15:00:00',null,'2021-04-12 13:00:00'),
       ('ACTIVE',2,3,'CHINA','USA',11359,'8:00',null,'2021-05-27 11:00:00','2021-05-27 13:00:00','2021-05-27 10:00:00'),
       ('ACTIVE',3,4,'SWEDEN','ITALY',2600,'2:30',null,'2021-05-26 15:00:00','2021-05-26 18:00:00','2021-05-26 11:00:00'),
       ('COMPLETED',1,1,'JAPAN','FRANCE',9844,'5:00','2021-04-26 17:30:00','2021-04-26 10:00:00','2021-04-26 12:00:00','2021-04-26 9:00:00'),
       ('COMPLETED',2,3,'CANADA','SWEDEN',6236,'4:25','2021-04-26 17:30:00','2021-04-24 10:00:00','2021-04-24 12:00:00','2021-04-24 9:00:00'),
       ('COMPLETED',3,4,'INDIA','BRAZIL',5936,'4:00','2021-04-26 12:01:00','2021-04-19 7:00:00','2021-04-19 8:00:00','2021-04-19 6:00:00');

