create table "users"
(
    id         uuid primary key default uuidv7(),
    first_name varchar(20)  not null,
    birth_date date         not null,
    password   varchar(255) not null
)