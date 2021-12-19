package com.busrayilmaz.cognizanttaskmanagementsystem.controller;

import com.busrayilmaz.cognizanttaskmanagementsystem.model.domain.Task;
import com.busrayilmaz.cognizanttaskmanagementsystem.model.dto.TaskDTO;
import com.busrayilmaz.cognizanttaskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/{taskId}")
    private ResponseEntity<TaskDTO> getTask(@PathVariable("taskId") int taskId) {
        return new ResponseEntity<>(taskService.getTaskById(taskId), HttpStatus.OK);
    }

    @GetMapping()
    private ResponseEntity<List<TaskDTO>> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    private void deleteTask(@PathVariable("taskId") int taskId)
    {
        taskService.delete(taskId);
    }

    @PostMapping()
    private ResponseEntity<Integer> saveTask(@RequestBody Task task)
    {
        taskService.createTask(task);
        return new ResponseEntity<>(task.getId(), HttpStatus.OK);
    }

    @PutMapping()
    private ResponseEntity<Task> update(@RequestBody Task task)
    {
        taskService.update(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
