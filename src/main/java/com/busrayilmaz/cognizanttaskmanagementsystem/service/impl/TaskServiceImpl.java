package com.busrayilmaz.cognizanttaskmanagementsystem.service.impl;

import com.busrayilmaz.cognizanttaskmanagementsystem.model.Task;
import com.busrayilmaz.cognizanttaskmanagementsystem.repository.TaskRepository;
import com.busrayilmaz.cognizanttaskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<Task>();
        taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }

    @Override
    public Task getTaskById(int id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void delete(int id)
    {
        taskRepository.deleteById(id);
    }

    @Override
    public void update(Task task) {
        taskRepository.save(task);
    }
}
