package com.example.demo.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.authentication.models.Project;
import com.example.demo.authentication.models.User;
import com.example.demo.authentication.repositories.ProjectRepository;



@Service
public class ProjectService {
	
//private final ProjectRepository projectRepository;
//	
//	public ProjectService(ProjectRepository projectRepository) {
//		this.projectRepository = projectRepository;
//	}
//	
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> allProjects(){
		return projectRepository.findAll();
	}
	
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		} else {
			return null;
		}
	}
	
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
	
	public void deleteProject(Long id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		if(optionalProject.isPresent()) {
			projectRepository.deleteById(id);
		}
	}
	
	
	// get the list of projects that the logged in user in not a team member in them
	public List<Project> findByTeamMemberNotContains(User user){
		return projectRepository.findByTeamMembersNotContains(user);
	}
	
	
	// get the list of projects that the logged in user is not a leader in them in them
//	public List<Project> findByLeaderNotContains(User user){
//		return projectRepository.findByLeaderNotContains(user);
//	}
	
	
	// get the list of projects that the logged in user is a team member in them
	public List<Project> findAllByTeamMembers(User user){
		return projectRepository.findAllByTeamMembers(user);
	}
	
	// get all the projects that this user is the leader in these projects
	public List<Project> findAllByLeader(User user){
		return projectRepository.findAllByLeader(user);
		
		
	}
	
	
	

	
	
}
