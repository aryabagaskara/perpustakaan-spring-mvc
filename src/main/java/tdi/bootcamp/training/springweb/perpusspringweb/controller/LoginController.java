package tdi.bootcamp.training.springweb.perpusspringweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/process-sign-in")
    public String redirectLogin() {
        return "redirect:/";
    }
}