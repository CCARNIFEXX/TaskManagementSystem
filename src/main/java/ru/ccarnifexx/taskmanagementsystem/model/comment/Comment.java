package ru.ccarnifexx.taskmanagementsystem.model.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.ccarnifexx.taskmanagementsystem.model.audit.AuditMetaData;
import ru.ccarnifexx.taskmanagementsystem.model.enums.TaskPriority;
import ru.ccarnifexx.taskmanagementsystem.model.enums.TaskStatus;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "comments", schema = "task_system")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class Comment extends AuditMetaData {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long commentId;

    String content;

    String taskId;

    Long executorId;

}
