create table tb_city (
    id bigint not null primary key,
    name varchar(50) not null,
    population bigint
);

insert into tb_city
    (id, name, population)
values
    (1, 'Recife', 21394),
    (2, 'Olinda', 49585),
    (3, 'Porto Alegre', 49593);