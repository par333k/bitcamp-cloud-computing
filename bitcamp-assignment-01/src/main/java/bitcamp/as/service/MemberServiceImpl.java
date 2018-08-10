package bitcamp.as.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.as.dao.MemberDao;
import bitcamp.as.domain.Member;
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    @Override
    public Member getMember(String id) {
        
        return memberDao.getMember(id);
    }

    @Override
    public String loginCheck(String id, String password, HttpSession httpSession) {
        String result ="로그인 성공";
        Member member = memberDao.getMember(id);
        if(member==null) {
            result = "유효하지 않은 아이디입니다";
        }else if(!member.getPassword().equals(password)) {
            result = "비밀번호가 맞지 않습니다";
        }else {
            httpSession.setAttribute("member", member);
            httpSession.setAttribute("id", member.getId());
        }
        return result;
    }

    @Override
    public int insert(Member member) {
        return memberDao.insert(member);
    }

    @Override
    public int delete(String id) {

        return memberDao.delete(id);
    }

}
