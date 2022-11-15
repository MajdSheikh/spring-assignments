package com.example.demo.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.authentication.models.Project;
import com.example.demo.authentication.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	List<Project> findAll();
	List<Project> findByTeamMembersNotContains(User x);
	List<Project> findAllByTeamMembers(User x);
	List<Project> findAllByLeader(User x);
//	List<Project> findByLeaderNotContains(User x);


}
