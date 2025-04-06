package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readuser")
public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public Read() {
        super();
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zohodb","root","test");
				
			Statement stt = con.createStatement();
			ResultSet rs = stt.executeQuery("select * from signup");
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("___________________");
		
			}
					
			con.close();
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		}

}
