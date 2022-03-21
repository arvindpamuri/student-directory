/**
 * @file SimpleFormInsert.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public addStudent() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String fname =  request.getParameter("fname");
	   String lname =  request.getParameter("lname");
	   String phone =  request.getParameter("phone");
	   String email = request.getParameter("email");
	   String address = request.getParameter("address");
	   String gpa = request.getParameter("gpa");
	   String date = request.getParameter("date");
	            
      

      Connection connection = null;
      String insertSql = " INSERT INTO student(SID, FIRSTNAME, LASTNAME, PHONE, EMAIL, ADDRESS, GPA, GRADDATE) values ( default, ?, ?, ?, ?, ?, ?, ?)";

      try {
         DBConnection.getDBConnection(getServletContext());
         connection = DBConnection.connection;
         PreparedStatement preparedStmt = connection.prepareStatement(insertSql);
         preparedStmt.setString(1, fname);
         preparedStmt.setString(2, lname);
         preparedStmt.setString(3, phone);
         preparedStmt.setString(4, email);
         preparedStmt.setString(5, address);
         preparedStmt.setString(6, gpa);
         preparedStmt.setString(7, date);
         preparedStmt.execute();
         connection.close();
         
         request.getRequestDispatcher("/insertResult.jsp").forward(request, response);
         
      } catch (Exception e) {
         
         request.getRequestDispatcher("/insertError.jsp").forward(request, response);
         
      }

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}