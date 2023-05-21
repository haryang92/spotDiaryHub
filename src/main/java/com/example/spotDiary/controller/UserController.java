package com.example.spotDiary.controller;

import com.example.spotDiary.domain.dto.UserRequestDTO;
import com.example.spotDiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class UserController {

		@Autowired
		private UserService userService;

		// 회원가입 view
		@GetMapping("/views/join")
		public String joinForm() {
			return "/auth/joins";
		}

		//회원가입 action
		@PostMapping("/joins")
		public String join(UserRequestDTO requestDTO) {
				userService.join(requestDTO);
			return "redirect:/auth/views/login";
		}


		// 로그인 view
		@GetMapping("/views/login")
		public String loginForm() {
			return "/auth/logins";
		}

		// 로그아웃
		@GetMapping("/views/logout")
		public String logout() {
		// 로그인 되면 달력 페이지로 가기
			return "redirect:/auth/views/login";
		}
}
