package com.example.jsonmover.repository;

import com.example.jsonmover.entity.UniversityGroup;
import com.example.jsonmover.service.GroupProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UniversityGroupRepository extends JpaRepository<UniversityGroup, Integer> {
    @Query("SELECT g.name AS name, SIZE(g.students) AS studentCount " +
            "FROM UniversityGroup g")
    List<GroupProjection> findAllGroupsWithStudentCount();
}