package com.juan.exquisiteGame.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juan.exquisiteGame.models.Story;
import com.juan.exquisiteGame.models.User;
import com.juan.exquisiteGame.services.StoryService;
import com.juan.exquisiteGame.services.UserService;
import com.juan.exquisiteGame.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@Autowired
	private StoryService sService;
	
	@GetMapping("/")
	public String index(Model viewModel, @ModelAttribute("user")User user) {
		return "index.jsp";
	}
	@GetMapping("/home")
	public String home(Model viewModel, HttpSession session, @ModelAttribute("Story")Story story) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		return "home.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/stories";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail") String email, @RequestParam("loginPass") String password, RedirectAttributes redirectAttr, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "invalid credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/stories";
	}
	
	@GetMapping("/logout")
	private String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/stories")
	private String storydashboard(Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("user", this.uService.find(userId));
		viewModel.addAttribute("stories", this.sService.getStories());
		return "stories.jsp";
	}
	
	@GetMapping("/story/new")
	private String newStory(@ModelAttribute("story") Story story, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("user", this.uService.find(userId));
		return "newStory.jsp";
	}
	
	@PostMapping("/story/create")
	public String addStory(@Valid @ModelAttribute("story") Story story, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user", this.uService.find(userId));
			return "newStory.jsp";
		}
		this.sService.create(story);
		return "redirect:/stories";
	}
	
	@GetMapping("story/{id}/contribute")
	public String updateStory(@PathVariable("id") Long id, @ModelAttribute("story") Story story, Model viewmodel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewmodel.addAttribute("story", this.sService.getById(id));
		return "contribute.jsp";
	}
	
	@PostMapping("story/{id}/update")
	public String editStory(@Valid @ModelAttribute("story") Story story, BindingResult result, Model viewmodel, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		User thisuser = this.uService.find((Long) session.getAttribute("user__id"));
		if(result.hasErrors()) {
			viewmodel.addAttribute("story", this.sService.getById(id));
			return "contribute.jsp";
		}
		else {
			if(story.getUsers() == null || story.getUsers().contains(thisuser) == false) {
				story.addUser(thisuser);
			}
			else {
				
			}
			this.sService.updateStory(story);
			story.concatSentence();
			this.sService.saveStory(story);

			return "redirect:/stories";
		}
	}
	
	@GetMapping("story/{id}/view")
	public String singleStory(@PathVariable("id") Long id, @ModelAttribute("story") Story story, Model viewmodel, HttpSession session) {
		
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewmodel.addAttribute("story", this.sService.getById(id));
		return "singleStory.jsp";
	}
}
