package com.busrayilmaz.cognizanttaskmanagementsystem.repository;

import com.busrayilmaz.cognizanttaskmanagementsystem.model.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByParentTaskIdAndIsFinishedFalse(int parentTaskId);
    List<Task> findByParentTaskId(int parentTaskId);

    @Query("select t from Task t where t.parentTaskId = 0")
    List<Task> findParentTasks();
}
