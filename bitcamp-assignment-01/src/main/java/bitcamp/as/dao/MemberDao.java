package bitcamp.as.dao;

import bitcamp.as.domain.Member;

public interface MemberDao {
    public Member getMember(String id);
    public int insert(Member member);
    public int delete(String id);
}
