create table air_company
(
    id           bigint       not null auto_increment,
    name         varchar(75)  not null,
    company_type varchar(255) not null,
    founded      date  not null,
    constraint air_company_pk primary key (id)
);

create table airplane
(
    id                    bigint       not null auto_increment,
    name                  varchar(75)  not null,
    factory_serial_number varchar(255) not null,
    air_company_id        bigint,
    number_of_flights     bigint       not null,
    flight_distance       bigint       not null,
    fuel_capacity         bigint       not null,
    type                  varchar(255) not null,
    created               datetime(6)  not null,
    constraint airplane_pk primary key (id),
    constraint airplane_air_company_id_fk foreign key (air_company_id) references air_company (id),
    constraint airplane_factory_serial_number_uk unique (factory_serial_number)
);

create table flight
(
    id                    bigint       not null auto_increment,
    flight_status         varchar(255) not null,
    air_company_id        bigint       not null,
    airplane_id           bigint       not null,
    departure_country     varchar(255) not null,
    destination_country   varchar(255) not null,
    distance              bigint       not null,
    estimated_flight_time time         not null,
    ended                 datetime(6),
    delay_started         datetime(6),
    started         datetime(6),
    created               datetime(6),
    constraint flight_pk primary key (id),
    constraint flight_air_company_id_fk foreign key (air_company_id) references air_company(id),
    constraint flight_airplane_fk foreign key (airplane_id) references airplane(id)
);
