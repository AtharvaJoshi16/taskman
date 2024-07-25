package com.api.taskman.subtask.repository;

import com.api.taskman.entity.Subtask;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubtaskRepository extends JpaRepository<Subtask, String> {

    @Query("SELECT s FROM Subtask s WHERE s.task.taskId = :taskId")
    List<Subtask> getAllSubtasks(String taskId);

    @Query("SELECT s FROM Subtask s WHERE s.task.taskId = :taskId AND s.subtaskId = :subtaskId")
    Subtask getSubtaskByTaskId(String taskId, String subtaskId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Subtask s WHERE s.task.taskId=:taskId AND s.subtaskId=:subtaskId")
    void deleteSubtaskById(String taskId, String subtaskId);
}
