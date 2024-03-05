package ru.ccarnifexx.taskmanagementsystem.controller.tasks;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Description;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.ccarnifexx.taskmanagementsystem.dto.task.TaskPostCreateDTO;
import ru.ccarnifexx.taskmanagementsystem.dto.task.TaskPutUpdateDTO;
import ru.ccarnifexx.taskmanagementsystem.dto.task.TaskResponseDTO;
import ru.ccarnifexx.taskmanagementsystem.service.task.TaskService;

import java.util.concurrent.CompletableFuture;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Description("API для работы с тасками")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequestMapping(path = "/api/v1/tasks", produces = APPLICATION_JSON_VALUE)
public class TaskController {

    TaskService taskService;

    @Async
    @ResponseStatus(OK)
    @GetMapping("/{taskId}")
    public CompletableFuture<TaskResponseDTO> findTaskById(@PathVariable long taskId) {
        return CompletableFuture.completedFuture(taskService.findTaskById(taskId));
    }

    @Async
    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public CompletableFuture<TaskResponseDTO> createTask(@RequestBody @Valid TaskPostCreateDTO createDTO) {
        return CompletableFuture.completedFuture(taskService.createTask(createDTO));
    }

    @Async
    @ResponseStatus(OK)
    @PutMapping(value = {"/{taskId}", "/{taskId}/status", "/{taskId}/executor"},
                consumes = APPLICATION_JSON_VALUE)
    public CompletableFuture<TaskResponseDTO> updateTask(@PathVariable long taskId,
                                                         @RequestBody @Valid TaskPutUpdateDTO updateDTO) {
        return CompletableFuture.completedFuture(taskService.updateTask(taskId, updateDTO));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "/{taskId}")
    public void deleteTaskById(@PathVariable long taskId) {
        taskService.deleteTaskById(taskId);
    }

}
