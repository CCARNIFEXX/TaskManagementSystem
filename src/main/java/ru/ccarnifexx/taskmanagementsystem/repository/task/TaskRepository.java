package ru.ccarnifexx.taskmanagementsystem.repository.task;

import org.springframework.data.repository.Repository;
import ru.ccarnifexx.taskmanagementsystem.model.task.Task;

import java.util.Optional;

public interface TaskRepository extends Repository<Task, Long> {

    Optional<Task> findTaskByTaskId(long taskId);

    Task save(Task task);

    void deleteTaskByTaskId(long taskId);

}
