package ru.ccarnifexx.taskmanagementsystem.dto.task;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.ccarnifexx.taskmanagementsystem.model.task.BaseTask;

import static lombok.AccessLevel.PRIVATE;

@Setter
@Getter
@FieldDefaults(level = PRIVATE)
public class TaskPutUpdateDTO extends BaseTask {

    Long taskId;

}
