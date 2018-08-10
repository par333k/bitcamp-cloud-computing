package bitcamp.as.service;

import javax.servlet.http.HttpSession;

import bitcamp.as.domain.Member;

public interface MemberService {
    public Member getMember(String id);
    public String loginCheck(String id, String password, HttpSession httpSession);
    public int insert(Member member);
    public int delete(String id);
}
