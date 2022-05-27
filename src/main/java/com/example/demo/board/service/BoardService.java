package com.example.demo.board.service;

import com.example.demo.board.domain.Board;
import com.example.demo.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

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
