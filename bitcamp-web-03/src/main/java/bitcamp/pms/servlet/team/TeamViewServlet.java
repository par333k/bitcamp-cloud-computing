package bitcamp.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/team/view")
public class TeamViewServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>팀 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>팀 보기</h1>");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://18.222.189.84:3306/studydb",
                        "study", "1111");
                PreparedStatement stmt = con.prepareStatement(
                    "select name, dscrt, sdt, edt, max_qty from pms2_team where name=?");) {
                
                stmt.setString(1, name);
                
                try (ResultSet rs = stmt.executeQuery();) {
                    if (!rs.next()) { 
                    out.println("<p>유효하지 않은 팀입니다.</p>");
                }else {

                    out.println("<form action='update' method='post'>");
                    out.println("<table border='1'>");
                    out.println("<tr>");
                    out.printf("    <th>팀명</th><td><input type=\"text\" name=\"name\" value='%s' readonly></td>\n",
                            rs.getString("name"));
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("    <th>설명</th><td><textarea name=\"description\" ");
                    out.printf("        rows=\"6\" cols=\"60\">%s</textarea></td>\n",
                            rs.getString("dscrt"));
                    out.println("</tr>");
                    out.println("<tr>");
                    out.printf("    <th>최대인원</th><td><input type=\"number\" name=\"maxQty\" value='%d'></td>\n",
                            rs.getInt("max_qty"));
                    out.println("</tr>");
                    out.println("<tr>");
                    out.printf("    <th>시작일</th><td><input type=\"string\" name=\"startDate\" value='%s'></td>\n", 
                            rs.getString("sdt"));
                    out.println("</tr>");
                    out.println("<tr>");
                    out.printf("    <th>종료일</th><td><input type=\"string\" name=\"endDate\" value='%s'></td>\n", 
                            rs.getString("edt"));
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("<p>");
                    out.println("<a href='list'>목록</a>");
                    out.println("<button>변경</button>");
                    out.printf("<a href='delete?name=%s'>삭제</a>\n", name);
                    out.printf("<a href='../task/list?teamName=%s'>작업목록</a>\n", name);
                    out.println("</p>");
                    out.println("</form>");
                    }
                } 
            }
       
        } catch (Exception e) {
            out.printf("<p>%s</p>\n", e.getMessage());
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
    }
}

