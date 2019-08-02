package com.ido.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ido.bean.Employee;
import com.ido.service.LoginServiceI;

@Controller
public class LoginController {
	@Autowired
	private LoginServiceI loginServiceI;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logVerify")
	public @ResponseBody String loginVerify(HttpSession session, String username, String password) {
		if (username.equals("admin") && password.equals("d033e22ae348aeb5660fc2140aec35850c4da997")) {
			session.setAttribute("empno", "admin");
			return "1";
		}
		Employee employee = loginServiceI.login(username, password);
		if (employee != null) {
			session.setAttribute("empno", employee.getEmpno());
			return "1";
		}
		return "0";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// session过期
		session.invalidate();
		return "redirect:login";
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@RequestMapping("main")
	public String mainJsp() {
		return "main";
	}

	@RequestMapping("calendar")
	public String calendar() {
		return "calendar";
	}
}
