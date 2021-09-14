package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired  // 멤버 컨트롤러를 스프링 컨테이너가 생성해주니까, 생성자 호출됨.
    //이때 Autowired 주석이 되어 있으면, 멤버 서비스를 스프링이 스프링 컨테이너에서 가져와서 연결시켜줌.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
