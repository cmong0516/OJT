package com.example.demo.user;

import com.example.demo.board.Board;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String userPw;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();
}
