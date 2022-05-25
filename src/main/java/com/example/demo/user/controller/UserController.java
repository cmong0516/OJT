package com.example.demo.user.controller;

import com.example.demo.user.domain.Member;
import com.example.demo.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String memberAdd(@ModelAttribute("member") Member member) {
        return "signin";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Member member) {
        memberService.joinUser(member);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("member") Member member) {
        return "login";
    }

    @PostMapping("/login")
    public String loginCheck(@Valid @ModelAttribute Member member, BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirectURL, HttpServletRequest request){

        Member loginMember = memberService.login(member.getUserId(), member.getUserPw());

        log.info(String.valueOf(loginMember));

        if (bindingResult.hasErrors()) {
            return "login";
        }


        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login";
        }

        HttpSession session = request.getSession();

        session.setAttribute("loginMember", loginMember);

        return "/loginHome";
    }
}
