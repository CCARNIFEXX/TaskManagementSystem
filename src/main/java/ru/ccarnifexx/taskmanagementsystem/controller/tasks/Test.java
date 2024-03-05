package ru.ccarnifexx.taskmanagementsystem.controller.tasks;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.datafaker.Faker;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.ccarnifexx.taskmanagementsystem.dto.task.TaskPutUpdateDTO;
import ru.ccarnifexx.taskmanagementsystem.model.task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Description("API для тестирования API тасок")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequestMapping(path = "/api/v1/test", produces = APPLICATION_JSON_VALUE)
public class Test {

    private static final Faker faker = new Faker();

    private static HttpEntity<HttpHeaders> getHttpHeadersHttpEntity() {
        TaskPutUpdateDTO updateDTO = new TaskPutUpdateDTO();
        updateDTO.setTaskId(11L);
        updateDTO.setTaskTitle(faker.commerce().brand());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiYWxleG1lbm92QG1haWwucnUiLCJleHAiOjE3MDE4NTg2ODksImlhdCI6MTcwMTg1NTA4OX0.PWTBLsciL3erXUT_b1AwOSoc8naT7uzmHeLfxUjtO8VUfC4sAv_j0c-ft-8ow_2nQSKutE8yGM_42TRBxpJ2iBex1Q-3cP0dfuu7uWU3c49iJQ_3FUQLz3ajL4WYq0k_jHWDOoiCqIYEKSrKIyshPl6cZa0FHowpblmv_BjtKJcXA_BqA0x3JeDaSZoGhtKbvBETi0XfaOdkDMtk2JMCFLeIdg2TqG9oQeOSlYGu9mGCrH8sAS6DSIpUgJ6vAfU-JulNDZqZiOAQECoYSIw4-w_0KpKcmnRpGMmvW06rfDD_owLs6v0inTnhM4OG0hfIpwkwYHOk9zdF35ZjW0GkSQ");
        return new HttpEntity<>(headers);
    }

    @ResponseStatus(OK)
    @GetMapping("/test")
    public void testSelect() throws ExecutionException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        ExecutorService executor = Executors.newFixedThreadPool(16);
        List<Future<?>> futures = new ArrayList<>();
        HttpEntity<HttpHeaders> httpEntity = getHttpHeadersHttpEntity();

        for (int i = 0; i < 10000; i++) {
            Future<?> future = executor.submit(() ->
                    restTemplate.exchange(
                    "http://localhost:8080/api/v1/tasks/11",
                    HttpMethod.PUT,
                    httpEntity,
                    Task.class));
            futures.add(future);
        }
        for (Future<?> future : futures) {
            future.get();
        }
        executor.shutdown();
    }
}
