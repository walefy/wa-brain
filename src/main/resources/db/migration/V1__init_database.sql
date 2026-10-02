create table "users"
(
    id         uuid primary key      default uuidv7(),
    username   varchar(20)  not null,
    first_name varchar(20)  not null,
    birth_date date         not null,
    password   varchar(255) not null,
    created_at timestamptz  not null default now(),
    updated_at timestamptz  not null default now(),
    deleted_at timestamptz
)
