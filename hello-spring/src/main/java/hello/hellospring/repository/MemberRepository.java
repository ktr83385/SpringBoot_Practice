package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id); // Optional은 null값을 받는다면 Optional이라는 걸로 감싸서 받기 위해서.

    Optional<Member> findByName(String name);

    List<Member> findAll();
}


