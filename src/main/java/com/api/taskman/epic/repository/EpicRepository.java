package com.api.taskman.epic.repository;

import com.api.taskman.entity.Epic;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpicRepository extends JpaRepository<Epic, String> {

    @Query("SELECT e FROM Epic e WHERE e.user.userId = :userId")
    List<Epic> findEpicsByUserID(String userId);

    @Query("SELECT e from Epic e WHERE e.epicId=:epicId AND e.user.userId=:userId")
    Epic findEpicByUserID(String userId, String epicId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Epic e WHERE e.epicId=:epicId AND e.user.userId=:userId")
    void deleteEpic(String userId, String epicId);
}
