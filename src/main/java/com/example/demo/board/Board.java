package com.example.demo.board;

import com.example.demo.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
