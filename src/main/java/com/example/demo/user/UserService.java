package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        validateDuplicateUser(user);
        user.setUserPw(passwordEncoding(user.getUserPw()));
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        User findUser =
                userRepository.findByUserId(user.getUserId());
        if (findUser != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다."); }
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public String passwordEncoding(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public Long login(String userId,String userPw) {
        User user = userRepository.findByUserId(userId);
        if (passwordEncoding(userPw).equals(user.getUserPw())) {
            return user.getId();
        }
        return Long.valueOf(-1);
    }
}
