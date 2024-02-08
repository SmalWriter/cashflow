package tw.shop.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import tw.shop.user.dto.UserDto;

@Controller
public class WebController {

	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, Spring Boot!";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		// 返回login.html模板
		return "front/user/login";
	}

	@PostMapping("/login")
	public String handleLogin(String email, String password) {
		// Implement your login logic here
		// For now, just redirect to the home page as a placeholder
		return "redirect:/";
	}

	@GetMapping("/register")
	public String showRegistrationPage(Model model) {
		// 可以添加模型属性给注册页面
		model.addAttribute("user", new UserDto());
		return "front/user/register";
	}

	// 其他方法...

}
