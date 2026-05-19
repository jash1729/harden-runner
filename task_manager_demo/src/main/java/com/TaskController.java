package com;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();

    public TaskController() {

        tasks.add(
            new Task(
                1,
                "Learn GitHub Actions",
                false
            )
        );

        tasks.add(
            new Task(
                2,
                "Test Harden Runner",
                false
            )
        );
    }

    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {

        tasks.add(task);

        return task;
    }

}