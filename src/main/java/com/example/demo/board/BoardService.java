package com.example.demo.board;

import com.example.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public String AddBoard(Board board) {
        return boardRepository.save(board);
    }


    public Board delete(Board board, String userId) {
        if (userRepository.findByUserId(userId).getUserId() == board.getUser().getUserId()) {
            boardRepository.delete(board);
        }
        return boardRepository.delete(board);
    }
}
