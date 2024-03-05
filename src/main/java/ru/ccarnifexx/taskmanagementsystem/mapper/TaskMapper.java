package ru.ccarnifexx.taskmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.ccarnifexx.taskmanagementsystem.dto.task.TaskPostCreateDTO;
import ru.ccarnifexx.taskmanagementsystem.dto.task.TaskPutUpdateDTO;
import ru.ccarnifexx.taskmanagementsystem.dto.task.TaskResponseDTO;
import ru.ccarnifexx.taskmanagementsystem.model.task.Task;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TaskMapper {

    public abstract Task toEntity(TaskPostCreateDTO dto);

    public abstract TaskResponseDTO toResponse(Task model);

    public abstract void toEntity(TaskPutUpdateDTO dto, @MappingTarget Task model);

}
