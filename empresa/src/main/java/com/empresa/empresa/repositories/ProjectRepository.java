package com.empresa.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.empresa.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	List<Project> findAllByProjectId(long projectId);
}
