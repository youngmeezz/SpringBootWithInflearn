package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //memeber set할때 시퀀스 값 하나 올려줌 여기서 아이디 세팅
        store.put(member.getId(), member); //store에 저장함
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //isNullToString
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();// 하나라도 찾아서 겹치는게 있으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //member들 반환
    }

    //Map 안쓰고 List로 실무에서 많이 사용 for 돌리기 쉬워서
    public void clearStore(){
        store.clear();
    }
}
