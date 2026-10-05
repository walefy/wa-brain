create table note
(
    id         uuid primary key      default uuidv7(),
    title      varchar(255) not null,
    content    text         not null,
    user_id    uuid         not null,
    created_at timestamptz  not null default now(),
    updated_at timestamptz  not null default now(),
    deleted_at timestamptz,
    foreign key (user_id) references users (id)
)
