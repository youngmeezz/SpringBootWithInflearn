package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//구현체에 @Repository 넣기

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id); //null값일 경우를 대비해서 사용 isNullToString

    Optional<Member> findByName(String name);

    List<Member> findAll(); //지금까지 저장된 모든 리스트 반환
}