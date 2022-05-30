package com.example.demo.user;

import com.example.demo.Data;
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
    public Data create(@ModelAttribute User user) {
        Data d = new Data();
        d.setMessage("add");
        d.setState(200);
        d.setData(userService.join(user));
        return d;
    }

    @PostMapping("/login")
    public Data login(@ModelAttribute User user) {
        Data d = new Data();
        d.setMessage("login");
        d.setState(200);
        d.setData(userService.login(user.getUserId(),user.getUserPw()));
        return d;
    }
}
