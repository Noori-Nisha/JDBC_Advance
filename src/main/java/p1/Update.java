package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateuser")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public Update() {
        super();
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zohodb","root","test");
				
			Statement stt = con.createStatement();
			
			stt.executeUpdate("update signup set mobile = '"+mobile+"'  where email = '"+email+"' ");
			
			con.close();
		
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		}

}
