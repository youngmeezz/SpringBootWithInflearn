package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//스프링 컨테이너에서 스프링 빈(@Controller)이 관리됨 MemberController 라는 객체 만들어줌
@Controller
public class MemberController {

    private final MemberService memberService;

    //생성자를 오토와이어드 스프링이 스프링컨테이너에 있는 memberService에 연결을 해줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //private final MemberService memberService = new MemberService(); // 이렇게 하면 멤버 컨트롤러가 다른 여러 컨트롤러들이 가져다 쓸수 있음
    //주문컨트롤러가 멤버 서비스 쓸수 있고, 객체를 new하면 별 기능이 없음
    //여러개 인스턴스 생성할 필요가 없어 하나만 생성하고 공유하면 됨

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    /**
     * 회원등록
     * @param form
     * @return
     */
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    /**
     * 회원조회
     * @param model
     * @return
     */
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}
