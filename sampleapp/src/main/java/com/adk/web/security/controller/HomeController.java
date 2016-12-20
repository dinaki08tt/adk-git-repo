package com.adk.web.security.controller;


import java.security.Principal;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HomeController {
 
    // http://localhost:8080/SpringSecurity/home
    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
 
        modelMap.addAttribute("topic", "Welcome to the Spring Security Learning");
        modelMap.addAttribute("description", "This is HOME Page");
        return "home";
    }
 
    // http://localhost:8080/SpringSecurity/admin
    @RequestMapping(value = "/admin.htm", method = RequestMethod.GET)
    public ModelAndView adminPage() {
 
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("topic", "Welcome to the Spring Security Learning");
        modelAndView.addObject("description", "This is ADMIN page");
        return modelAndView;
    }
 
    // to display customized login page to user
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public ModelAndView loginPage() {
 
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        model.addObject("message", "Login with Username and Password");
        return model;
    }
 
    // on successful logout
    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public ModelAndView logoutPage() {
 
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        model.addObject("message", "Logout successful");
        return model;
    }
 
    // for invalid username or password
    @RequestMapping(value = "/error.htm", method = RequestMethod.GET)
    public ModelAndView errorPage() {
 
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        model.addObject("message", "Invalid Username or Password");
        return model;
    }
 
    // for 403 access denied page
    @RequestMapping(value = "/403.htm", method = RequestMethod.GET)
    public String accesssDenied(Principal user, ModelMap modelMap) {
 
        if (user != null) {
            modelMap.addAttribute("topic", "Access denied");
            modelMap.addAttribute("description", "Sorry " + user.getName() + ", you don't have permission to access this page");
        }
        else {
            modelMap.addAttribute("topic", "Access denied");
            modelMap.addAttribute("description", "Sorry, you don't have permission to access this page");
        }
        return "accessdenied";
    }
}