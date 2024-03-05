create table if not exists task_system.tasks
(
    task_id          bigserial primary key,
    task_title       varchar(255) not null,
    task_description text,
    version          bigserial,
    task_status      varchar(56)  not null,
    task_priority    varchar(56)  not null,
    task_executor_id bigserial    not null references users (user_id),
    created_by_id    bigserial    not null references users (user_id),
    created_at       timestamp without time zone
);

