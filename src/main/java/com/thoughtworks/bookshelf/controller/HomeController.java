package com.thoughtworks.bookshelf.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("userName")
@RequestMapping("/")
public class HomeController {
    private static final String EMPTY_STR = "";

    @RequestMapping("home")
    public String loadHomePage(Model model) {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model, Principal principal) {
        if (null == principal) {
            return "login";
        }
        loadHomePage(model);
        return "home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap model, HttpSession session) {
//        String userName = (String) session.getAttribute("userName");
//        if (userName == null || EMPTY_STR.equals(userName)) {
//            return "login";
//        }
//        return "redirect:/home";
        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpSession session) {
        if (session != null) {
            session.removeAttribute("userName");
//            session.invalidate();
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginValidation(HttpServletRequest request, Principal principal, ModelMap model) {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");

        if (userName.equals("Tingpeng") && passWord.equals("123456")) {

            request.getSession().setAttribute("userName", userName);
            return "redirect:/home";
        }
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value = "test-response", method = RequestMethod.GET)
    public String testResponse(ModelMap model) {
        return "response-body";
    }

}
