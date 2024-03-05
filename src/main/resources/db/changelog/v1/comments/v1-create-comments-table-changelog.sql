create table if not exists task_system.comments
(
    comment_id    bigserial primary key,
    content       text,
    task_id       bigserial not null references users (user_id),
    executor_id   bigserial not null references users (user_id),
    created_by_id bigserial not null references users (user_id),
    created_at    timestamp without time zone
);