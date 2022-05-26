package com.example.demo.board.repository;

import com.example.demo.board.domain.Board;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository {
    Board save();

    Board findById();

    Board update();

    Board delete();
}
