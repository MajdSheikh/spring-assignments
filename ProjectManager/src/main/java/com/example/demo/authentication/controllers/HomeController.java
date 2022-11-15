package com.example.demo.authentication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.authentication.models.LoginUser;
import com.example.demo.authentication.models.Project;
import com.example.demo.authentication.models.User;
import com.example.demo.authentication.services.ProjectService;
import com.example.demo.authentication.services.UserService;

@Controller
public class HomeController {
 
 // Add once service is implemented:
  @Autowired
   UserService userServ;
  
  @Autowired
   ProjectService projectService;
 
 @GetMapping("/")
 public String index(Model model , HttpSession session) {
	 
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
	 
	 if (session.getAttribute("user_id") != null) {		
 		return "redirect:/";					
 	}
 	
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "loginAndReg.jsp";
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {

	  userServ.register(newUser, result);
     if(result.hasErrors()) {

         model.addAttribute("newLogin", new LoginUser());
         return "loginAndReg.jsp";
     }
     
     // TO-DO Later: Store their ID from the DB in session, 
     session.setAttribute("user_id", newUser.getId());
     return "redirect:/success";
 }
 
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     // Add once service is implemented:
     // User user = userServ.login(newLogin, result);
	 	User user = userServ.login(newLogin, result);
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "loginAndReg.jsp";
     }

     // Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("user_id", user.getId());
     return "redirect:/success";
 }
 
 
 

 
 
 @GetMapping("/success")
 public String home(Model model, HttpSession session) {
     if (session.getAttribute("user_id") != null) {
     Long user_id = (Long) session.getAttribute("user_id");
     
     User thisUser = userServ.findUserById(user_id);
     model.addAttribute("thisUser", thisUser);
     
     
     List<Project> projects = projectService.allProjects();
 	 model.addAttribute("projects", projects);
 	 
 	 
 	 // this method gets all projects that the user is nor part of (not a team leader or team member)
 	 List<Project> allProjects = projectService.findByTeamMemberNotContains(thisUser);
 	 model.addAttribute("allProjects", allProjects);
 	 
// 	 List<Project> LProjects = projectService.findByLeaderNotContains(thisUser);
// 	 model.addAttribute("LProjects", LProjects);
// 	 

 	 
 	 List<Project> yourProjects = projectService.findAllByTeamMembers(thisUser);
 	 model.addAttribute("yourProjects", yourProjects);
 	 
 	 List<Project> myProjects = projectService.findAllByLeader(thisUser);
 	 model.addAttribute("myProjects", myProjects);
 	 
     return "success.jsp";

 }
     else {
         return "redirect:/";
     }
 }


 
 @GetMapping("/logout")
 public String logout(HttpSession session) { 
         session.invalidate();
         return "redirect:/";

 }
 
 @GetMapping("/projects/new")
 public String newProject(Model model, HttpSession session) {
 	model.addAttribute("project", new Project());

 	User user = userServ.findUserById((Long)session.getAttribute("user_id"));

 	model.addAttribute("user", user);
 	return "NewProject.jsp";
 }
 
 
 @PostMapping("/projects/create")
 public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result) {
 	if(result.hasErrors()) {
 		return "NewProject.jsp";
 	} else {
 		projectService.createProject(project);
 		return "redirect:/success";
 	}
 }
 
 
 @GetMapping("/projects/{id}/view")
 public String showProject(Model model, HttpSession session, @PathVariable("id") Long id) {
	 Project project = projectService.findProject(id);
 	model.addAttribute("project", project);
 	
 	User user = userServ.findUserById((Long)session.getAttribute("user_id"));
 	model.addAttribute("user", user);
 	return "ViewProject.jsp";
	 
 }

 @GetMapping("/projects/{id}/edit")
 public String editProject(Model model, HttpSession session, @PathVariable("id") Long id) {
	 Project project = projectService.findProject(id);
	 model.addAttribute("project", project);
	 User user = userServ.findUserById((Long)session.getAttribute("user_id"));
	 model.addAttribute("user", user);
	 return "editProject.jsp";
	 
 }


 @PutMapping("/projects/{id}/update")
 public String updateProject(@PathVariable("id") Long id, HttpSession session, Model model,
		 @Valid @ModelAttribute("project") Project project, BindingResult result) {
	 	if(result.hasErrors()) {
	 		return "editProject.jsp";
	 	}
	 	else {
	 		projectService.updateProject(project);
	 		
	 		return "redirect:/success";
	 	}
 }
 
 
 
 
 @DeleteMapping("/projects/{id}/delete")
 public String deleteProject(@PathVariable("id") Long id) {
	 projectService.deleteProject(id);
	 return "redirect:/success";
 }
 
 
 
 
 @GetMapping("/projects/{id}/join")
public String joinTeam(@PathVariable("id") Long id, HttpSession session) {
	 if (session.getAttribute("user_id") != null) {
		 Long user_id = (Long) session.getAttribute("user_id");
		 
		 Project joinedTeam = projectService.findProject(id);
		 
		 User user = userServ.findUserById(user_id);
		 List<User> users = joinedTeam.getTeamMembers();
		 
		 users.add(user);
		 joinedTeam.setTeamMembers(users);
		 
 		 projectService.updateProject(joinedTeam);
		 return "redirect:/success";
	 }
	 else {
 		 return "redirect:/";
 }
 }
 

 @GetMapping("/projects/{id}/leave")
 public String leaveTeam(@PathVariable("id") Long id, HttpSession session) {
	  if (session.getAttribute("user_id")!=null) {
		  Long user_id = (Long) session.getAttribute("user_id");
			Project joinedTeam = projectService.findProject(id);
		 	
			User user = userServ.findUserById(user_id);
			List<User> users = joinedTeam.getTeamMembers();
			users.remove(user);
			projectService.updateProject(joinedTeam);
	       return "redirect:/success";
	  }
	  else {
		  return "redirect:/";
	  }

   }
 
}
