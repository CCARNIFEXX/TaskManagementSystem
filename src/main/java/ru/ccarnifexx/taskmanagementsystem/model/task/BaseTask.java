package ru.ccarnifexx.taskmanagementsystem.model.task;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.ccarnifexx.taskmanagementsystem.model.audit.AuditMetaData;
import ru.ccarnifexx.taskmanagementsystem.model.enums.TaskPriority;
import ru.ccarnifexx.taskmanagementsystem.model.enums.TaskStatus;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@FieldDefaults(level = PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class BaseTask extends AuditMetaData {

    String taskTitle;

    String taskDescription;

    @Enumerated(STRING)
    TaskStatus taskStatus;

    @Enumerated(STRING)
    TaskPriority taskPriority;

    @Positive
    Long taskExecutorId;

}
