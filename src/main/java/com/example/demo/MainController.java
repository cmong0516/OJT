package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // 홈화면 회원가입 , 로그인
    @GetMapping("/")
    public String test() {
        return "home";
    }
}
