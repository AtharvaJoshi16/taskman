package com.api.taskman.epic.repository;

import com.api.taskman.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpicRepository extends JpaRepository<Epic, String> {

    @Query("SELECT e FROM Epic e JOIN e.user u")
    List<Epic> findEpicsByUserID(String userId);
}
