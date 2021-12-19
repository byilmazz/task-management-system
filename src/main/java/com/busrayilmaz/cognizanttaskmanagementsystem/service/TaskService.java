package com.busrayilmaz.cognizanttaskmanagementsystem.service;

import com.busrayilmaz.cognizanttaskmanagementsystem.model.domain.Task;
import com.busrayilmaz.cognizanttaskmanagementsystem.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();

    TaskDTO getTaskById(int id);

    void createTask(Task task);

    void delete(int id);

    void update(Task task);
}
