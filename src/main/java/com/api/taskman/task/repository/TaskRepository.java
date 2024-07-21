package com.api.taskman.task.repository;

import com.api.taskman.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, String> {

    @Query("SELECT t FROM Task t WHERE t.epic.epicId = :epicId")
    List<Task> getTasksByEpicID(String epicId);

    @Query("SELECT t FROM Task t WHERE t.epic.epicId=:epicId AND t.taskId=:taskId")
    Task getTaskByID(String epicId, String taskId);
}
