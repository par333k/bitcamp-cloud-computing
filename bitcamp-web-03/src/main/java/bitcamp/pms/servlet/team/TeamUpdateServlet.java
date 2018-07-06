package bitcamp.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/team/update")
public class TeamUpdateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='Refresh' content='1;url=list'>");
    out.println("<title>팀 변경</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>팀 변경 결과</h1>");
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://18.222.189.84:3306/studydb",
                    "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms2_team set dscrt=?, max_qty=?, sdt=?, edt=? where name=?");) {
            
            stmt.setString(1, request.getParameter("description"));
            stmt.setInt(2, Integer.parseInt(request.getParameter("maxQty")));
            stmt.setString(3, request.getParameter("startDate"));
            stmt.setString(4, request.getParameter("endDate"));
            stmt.setString(5, request.getParameter("name"));
            
            if (stmt.executeUpdate() == 0) {
                out.println("<p>해당 팀이 존재하지 않습니다.</p>");
            } else {
                out.println("<p>변경하였습니다.</p>");
            }
        }
       
    } catch (Exception e) {
        out.println("<p>변경 실패!</p>");
        e.printStackTrace(out);
    }
    out.println("</body>");
    out.println("</html>");
}
}

