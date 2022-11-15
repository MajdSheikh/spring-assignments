package com.example.demo.authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="projects")
public class Project {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@NotNull
    @Size(min = 3, max = 200 , message="title must be at least 3 characters.")
    private String title;
	
	@NotNull
    @Size(min = 3, max = 200 , message="Description must be at least 3 characters.")
    private String description;
	
	@Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date dueDate;
	
	
	
	@Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	    
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	 
	 @PrePersist
	 protected void onCreate(){
	      this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	      this.updatedAt = new Date();
	 }
	 
	 
	 // many to many relation between user and project (many projects and many team members)
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	      name = "teamMembers_projects", 
	      joinColumns = @JoinColumn(name = "project_id"), 
	      inverseJoinColumns = @JoinColumn(name = "user_id")
	   )
	 private List<User> teamMembers;
	
	// many projects and one team leader for a project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="leader_id")
	private User leader;

	public Project() {
	}
	public Project(String title, String description, Date dueDate, List<User> teamMembers, User leader) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.teamMembers = teamMembers;
		this.leader = leader;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public List<User> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<User> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	
	
	
	
	
	
	
}




