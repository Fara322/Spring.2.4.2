package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@GetMapping("/user")
	public String showUsers(Model model) {
//		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("allUsersPage", userService.getAllUsers());
		return "user";
	}

	@GetMapping("/admin")
	public String adminPage(Model model) {
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("allUsersPage", allUsers);
		return "user";
	}

	@GetMapping("/admin/add-new-user")
	public String addNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user_info";
	}

	@PostMapping("/admin/save-user")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}


	@GetMapping("/admin/update-user/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user",user);
		return "/update-user";
	}
	@PostMapping("/admin/update-user")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@GetMapping("/admin/user-delete/{id}")
	public String deleteUser(@PathVariable("id") int id){
		userService.removeUserById(id);
		return "redirect:/user";
	}
}