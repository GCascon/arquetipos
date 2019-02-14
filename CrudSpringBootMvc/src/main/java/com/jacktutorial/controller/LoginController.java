package com.jacktutorial.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jacktutorial.model.User;
import com.jacktutorial.service.UserService;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("login");
		User user = new User();
		model.addObject("userForm", user);
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView save(HttpSession session, @ModelAttribute("userForm") User user) {
		User userbdd=userService.getUserByAliasAndPassword(user.getAlias(),user.getPassword());
		if(userbdd!=null) {
			session.setAttribute("logedUser", userbdd);
			return new ModelAndView("redirect:/article/list");	
		}else {
			System.err.println("Usuario no encontrado....");
			ModelAndView model = new ModelAndView("redirect:/");
			model.addObject("msgError", "Usuario no encontrado!!");
			return model;
		}		
	}
	
}
