package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();   // 동시성 문제를 일단은 고려 안하고 해쉬맵을 쓰겠다.
    private static long sequence = 0L;  //sequence는 0,1,2 이렇게 키값을 생성해주는 얘.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);  //맵에 저장한다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //null이 일어날 수 있는 경우 Optional로 감싸주면 됨.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    // 위 코드들을 작성하긴 했지만, 이게 돌아가는지 확인해볼려면? 테스트케이스.

    public void clearStore() {
        store.clear();
    }
}
