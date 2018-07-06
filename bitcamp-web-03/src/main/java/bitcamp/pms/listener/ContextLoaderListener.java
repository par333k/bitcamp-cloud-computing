package bitcamp.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.dao.MemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener 실행!");
        MemberDao memberDao = new MemberDao("jdbc:mysql://18.222.189.84:3306/studydb",
                "study", "1111");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("memberDao", memberDao);
        BoardDao boardDao = new BoardDao("jdbc:mysql://18.222.189.84:3306/studydb",
                "study", "1111");
        ServletContext sc2 = sce.getServletContext();
        sc2.setAttribute("boardDao", boardDao);

    }
}
