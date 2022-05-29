package com.example.demo.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public String save(Board board) {
        if (board.getId() == null) {
            em.persist(board);
        } else {
            em.merge(board);
        }
        return "Ok";
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board", Board.class).getResultList();
    }

    public void delete(Board board) {
        em.remove(board);
    }
}
