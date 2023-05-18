package com.empresa.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	List<Project> findAllByProjectId(long projectId);
}
