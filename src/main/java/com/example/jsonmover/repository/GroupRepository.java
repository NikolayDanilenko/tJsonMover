package com.example.jsonmover.repository;

import com.example.jsonmover.entity.UniversityGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<UniversityGroup, Integer> {
}
