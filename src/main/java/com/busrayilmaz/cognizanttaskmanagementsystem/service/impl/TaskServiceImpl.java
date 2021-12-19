package com.busrayilmaz.cognizanttaskmanagementsystem.service.impl;

import com.busrayilmaz.cognizanttaskmanagementsystem.model.domain.Task;
import com.busrayilmaz.cognizanttaskmanagementsystem.model.dto.TaskDTO;
import com.busrayilmaz.cognizanttaskmanagementsystem.repository.TaskRepository;
import com.busrayilmaz.cognizanttaskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<TaskDTO> getTasks() {
        List<TaskDTO> tasks = new ArrayList<TaskDTO>();

        taskRepository.findParentTasks().forEach(task -> tasks.add(convertTaskToTaskDTO(task)));
        return tasks;
    }

    private TaskDTO convertTaskToTaskDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setAssignee(task.getAssignee());
        taskDTO.setDuration(task.getDuration());
        taskDTO.setEndDate(task.getEndDate());
        taskDTO.setFinished(task.isFinished());
        taskDTO.setGroupName(task.getGroupName());
        taskDTO.setStartDate(task.getStartDate());
        taskDTO.setName(task.getName());
        taskDTO.setSubTasks(getSubTasks(task.getId()));
        return taskDTO;
    }

    private List<TaskDTO> getSubTasks(int parentTaskId){
        List<TaskDTO> tasks = new ArrayList<TaskDTO>();
        taskRepository.findByParentTaskId(parentTaskId).forEach(task -> tasks.add(convertTaskToTaskDTO(task)));
        return tasks;
    }

    @Override
    public TaskDTO getTaskById(int id) {
        return convertTaskToTaskDTO(taskRepository.findById(id).get());
    }

    @Override
    public void createTask(Task task) {
        task.setStartDate(LocalDateTime.now());
        task.setFinished(false);
        taskRepository.save(task);
    }

    @Override
    public void delete(int id)
    {
        taskRepository.deleteById(id);
    }

    @Override
    public void update(Task task) {
        if(task.isFinished()){
            List<Task> activeSubTasks = taskRepository.findByParentTaskIdAndIsFinishedFalse(task.getId());
            if(activeSubTasks.size() == 0){
                task.setEndDate(LocalDateTime.now());
            } else {
                //error
            }
        }
        taskRepository.save(task);
    }
}
