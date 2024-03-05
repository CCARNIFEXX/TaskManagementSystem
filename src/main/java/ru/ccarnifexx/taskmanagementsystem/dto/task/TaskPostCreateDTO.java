package ru.ccarnifexx.taskmanagementsystem.dto.task;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.ccarnifexx.taskmanagementsystem.model.task.BaseTask;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = PRIVATE)
public class TaskPostCreateDTO extends BaseTask {
}
