package com.busrayilmaz.cognizanttaskmanagementsystem.repository;

import com.busrayilmaz.cognizanttaskmanagementsystem.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
}
