package com.api.taskman.epic.repository;

import com.api.taskman.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EpicRepository extends JpaRepository<Epic, UUID> {

    @Query("SELECT e FROM Epic e where e.user= :userId")
    List<Epic> findEpicsByUserID(UUID userId);
}
