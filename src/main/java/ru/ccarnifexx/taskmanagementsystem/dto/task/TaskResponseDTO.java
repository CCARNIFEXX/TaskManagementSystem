package ru.ccarnifexx.taskmanagementsystem.dto.task;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.ccarnifexx.taskmanagementsystem.model.task.BaseTask;

import static lombok.AccessLevel.PRIVATE;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@JsonPropertyOrder(alphabetic = true)
public class TaskResponseDTO extends BaseTask {

    Long taskId;

}
