package com.example.demo.board;

import com.example.demo.Data;
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
    public Data create(Board board) {
        Data d = new Data();
        d.setMessage("add");
        d.setState(200);
        d.setData(boardService.AddBoard(board));
        return d;
    }

    @PostMapping("/delete")
    public Data delete(Board board, String userId) {
        Data d = new Data();
        d.setMessage("delete");
        d.setState(200);
        d.setData(boardService.delete(board,userId));

        return d;
    }
}
