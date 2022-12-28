import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
//index is url 
import javax.sql.*;
public class insert extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        try{
            res.setContentType("text/html");
            PrintWriter output=res.getWriter();
            String pass=req.getParameter("pass");
            String name=req.getParameter("username");
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "harika", "harika");
            PreparedStatement st=con.prepareStatement("insert into internal values(?,?)");
        
            st.setString(1, name);
            st.setString(2, pass);
            st.executeUpdate();
           
           // res.sendRedirect("login.html");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
