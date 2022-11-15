package com.example.demo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	@RequestMapping("/gold")
	public String gold(HttpSession session) {
		if (session.getAttribute("score")==null) {
			session.setAttribute("score", 0);
			ArrayList<String> messages = new ArrayList<String>();
			session.setAttribute("messages", messages);
		}
		return "gold.jsp";
	}
	@PostMapping("/process_money")
	public String process_money(HttpSession session,
			@RequestParam(value="gold") String location) {
		Date date = new Date();
		SimpleDateFormat newDate = new SimpleDateFormat("MMMM dd ,yyyy hh:mm a");
		String actionDate = newDate.format(date);
		
		Random rand = new Random();
		int intRandom = 0;
		int currentScore = (int) session.getAttribute("score"); 
		
		if (location.equals("farm")) {
			intRandom = rand.nextInt(10,20);
			currentScore += intRandom;
		}
		else if (location.equals("cave")) {
			intRandom = rand.nextInt(5,10);
			currentScore += intRandom;
		}
		else if (location.equals("house")) {
			intRandom = rand.nextInt(2,5);
			currentScore += intRandom;
		}
		else if (location.equals("quest")) {
			intRandom = rand.nextInt(-50,50);
			currentScore += intRandom;
		}
		if (intRandom > 0) {
			String message = "You entered a "+ location+" and earned "+intRandom+" gold. ("+actionDate+")";
			@SuppressWarnings("unchecked")
			ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
			messages.add(0, message);
			session.setAttribute("messages", messages);
		}
		else {
			String message = "You failed a "+ location+" and lost "+intRandom+" gold. Ouch! ("+actionDate+")";
			@SuppressWarnings("unchecked")
			ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
			messages.add(0, message);
			session.setAttribute("messages", messages);
		}
		session.setAttribute("score", currentScore);
		return "redirect:/gold";
	}
}