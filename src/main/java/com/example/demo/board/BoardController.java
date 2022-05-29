package com.example.demo.board;

import com.example.demo.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/add")
    public String create(Board board) {
        return boardService.AddBoard(board);
    }

    @PostMapping("/delete")
    public String delete(Board board,String userId) {

        boardService.delete(board,userId);
        return "Ok";
    }
}
