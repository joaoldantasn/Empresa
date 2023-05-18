package com.empresa.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.empresa.entities.Project;
import com.empresa.empresa.services.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping
	public ResponseEntity createProject(@RequestBody Project projectObj) {
        projectService.saveProject(projectObj);
        return new ResponseEntity(HttpStatus.CREATED);
    }
	
	@GetMapping(value = { "/{projectId}"})
	 public List<Project> getProjects(@PathVariable(required = false) Long projectId) {
        return projectService.getProjectDetails(projectId);
    }
	
	 @DeleteMapping("/{projectId}")
	    public ResponseEntity removeProject(@PathVariable Long projectId) {
	        projectService.deleteProject(projectId);
	        return new ResponseEntity(HttpStatus.OK);
	    }
}
