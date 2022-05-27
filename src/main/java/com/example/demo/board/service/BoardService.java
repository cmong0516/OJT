package com.example.demo.board.service;

import com.example.demo.board.domain.Board;
import com.example.demo.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public void deleteById(Long id){
        boardRepository.deleteById(id);
    }
}
