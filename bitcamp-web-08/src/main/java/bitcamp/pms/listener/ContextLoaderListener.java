package bitcamp.pms.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.controller.BoardAddController;
import bitcamp.pms.controller.BoardDeleteController;
import bitcamp.pms.controller.BoardListController;
import bitcamp.pms.controller.BoardUpdateController;
import bitcamp.pms.controller.BoardViewController;
import bitcamp.pms.controller.MemberAddController;
import bitcamp.pms.controller.MemberDeleteController;
import bitcamp.pms.controller.MemberListController;
import bitcamp.pms.controller.MemberUpdateController;
import bitcamp.pms.controller.MemberViewController;
import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.dao.MemberDao;

@WebListener
public class ContextLoaderListener 
    implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener 실행!");
        try {
        String resource = "bitcamp/pms/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        MemberDao memberDao = new MemberDao(sqlSessionFactory);

        
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("/member/list",  new MemberListController(memberDao));
        sc.setAttribute("/member/view",  new MemberViewController(memberDao));
        sc.setAttribute("/member/update",  new MemberUpdateController(memberDao));
        sc.setAttribute("/member/delete",  new MemberDeleteController(memberDao));
        sc.setAttribute("/member/add",  new MemberAddController(memberDao));
        BoardDao boardDao = new BoardDao(sqlSessionFactory);
        
        ServletContext sc2 = sce.getServletContext();
        sc2.setAttribute("/board/list",  new BoardListController(boardDao));
        sc2.setAttribute("/board/view",  new BoardViewController(boardDao));
        sc2.setAttribute("/board/update",  new BoardUpdateController(boardDao));
        sc2.setAttribute("/board/delete",  new BoardDeleteController(boardDao));
        sc2.setAttribute("/board/add",  new BoardAddController(boardDao));
        sc2.setAttribute("boardDao", boardDao);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}



