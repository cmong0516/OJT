package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/all")
    public String boardAll() {
        return "board";
    }


    @GetMapping("/add")
    public String boardAdd() {
        return "boardAdd";
    }
}
