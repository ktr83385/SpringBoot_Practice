package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /**
     *
    회원가입
    */

    public Long join(Member member) {

        // 같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member);    //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {   // ifPresent <- 값이 있다면 Optional이기 때문에 이 함수를 썼음. Optional로 한번 감싸면
            // Optional 안에 멤버 객체가 있는 느낌.
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

            /*
        위 코드와 같은 코드

        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
