package hello.core.member;

import hello.core.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
