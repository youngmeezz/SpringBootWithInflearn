package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     * @param member
     * @return
     */
    public long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDulplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDulplicateMember(Member member) {
        memberRepository.findByName(member.getName())//control option V 앞에 변수 생성해줌 여기 결과가 optional Member니까 바로 ifPresent 가능
            .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
