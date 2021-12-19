package com.busrayilmaz.cognizanttaskmanagementsystem.controller;

import com.busrayilmaz.cognizanttaskmanagementsystem.model.Task;
import com.busrayilmaz.cognizanttaskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/{taskId}")
    private Task getTask(@PathVariable("taskId") int taskId)
    {
        return taskService.getTaskById(taskId);
    }

    @DeleteMapping("/{taskId}")
    private void deleteTask(@PathVariable("taskId") int taskId)
    {
        taskService.delete(taskId);
    }

    @PostMapping()
    private int saveTask(@RequestBody Task task)
    {
        taskService.saveOrUpdate(task);
        return task.getId();
    }

    @PutMapping()
    private Task update(@RequestBody Task task)
    {
        taskService.saveOrUpdate(task);
        return task;
    }
}
