package com.busrayilmaz.cognizanttaskmanagementsystem.service;

import com.busrayilmaz.cognizanttaskmanagementsystem.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTaskById(int id);

    void saveOrUpdate(Task task);

    void delete(int id);

    void update(Task task);
}
