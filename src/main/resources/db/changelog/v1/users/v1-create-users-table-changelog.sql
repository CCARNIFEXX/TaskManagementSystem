create table if not exists task_system.users
(
    user_id            bigserial primary key,
    version            bigserial,
    user_email         varchar(255) unique not null,
    user_password_hash varchar(255)        not null,
    name               varchar(128)
);

