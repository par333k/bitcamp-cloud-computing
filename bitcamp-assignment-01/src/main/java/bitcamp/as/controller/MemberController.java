package bitcamp.as.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.as.domain.Member;
import bitcamp.as.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    
    @RequestMapping("main")
    public String main() {
       return "main/main";
    }
    
    @RequestMapping("insertForm")
    public String memberInsertForm() {
        return "member/insertform";
    }
    
    @RequestMapping("insert")
    public String insert(Member member, Model model, HttpSession httpSession) {
        memberService.insert(member);
        httpSession.setAttribute("id", member.getId());
        return "redirect:main.do";
    }
    
    @RequestMapping("memberlogin")
    public String loginForm() {
        return "member/login";
    }
    
    @RequestMapping("login")
    public String login(String id, String password, HttpSession httpSession, Model model) {
        String result = memberService.loginCheck(id, password, httpSession);
        if(result.equals("로그인 성공")) {
            httpSession.setAttribute("getMember", memberService.getMember(id));
            return "redirect:../html/assignment/list.html";
         }else {
            model.addAttribute("id", id);
            model.addAttribute("password", password);
            model.addAttribute("result", result);
            return "forward:../html/assignment/list.html";
         }        
    }
    
    @RequestMapping("delete")
    public String delete(Member member, String id, Model model, HttpSession httpSession) {
        memberService.delete(id);
        httpSession.setAttribute("id", member.getId());
        return "redirect:member/main.do";
    }
    
    @RequestMapping("Logout")
    public String userLogout(HttpSession httpSession) {
       httpSession.invalidate();
       return "redirect:member/main.do";
    }
}
