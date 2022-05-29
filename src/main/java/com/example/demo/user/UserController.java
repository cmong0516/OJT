package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public Long create(@ModelAttribute User user) {
        return userService.join(user);
    }

    @PostMapping("/login")
    public Long login(@ModelAttribute User user) {
        return userService.login(user.getUserId(),user.getUserPw());
    }
}
