import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/searchStudent")
public class searchStudent extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public searchStudent() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String sid =  request.getParameter("sid");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");
      String date = request.getParameter("date");
            
      String msg = "Hello JSP";
      ArrayList<String> list = new ArrayList<String>(); 
      
      if(!sid.isEmpty())
    	  list.add("SID=" + "'" +sid+ "'");
      
      if(!email.isEmpty())
    	  list.add("EMAIL=" + "'" +email+ "'");
      
      if(!phone.isEmpty())
    	  list.add("PHONE=" + "'" + phone+ "'");
      
      if(!date.isEmpty())
    	  list.add("DATE=" + "'" +date+ "'");
      
      ArrayList<ArrayList<String> > result = new ArrayList<ArrayList<String>>();
      
      result =  search(list);
      
      for (int i = 0; i < result.size(); i++)
      {
    	    for (int j = 0; j < result.get(i).size(); j++)
    	    {
    	        System.out.print(result.get(i).get(j));
    	    } 
    	    
    	    System.out.println();
    	}
      
      
      request.setAttribute("result", result);
      request.getRequestDispatcher("/test.jsp").forward(request, response);
      
   }

   ArrayList<ArrayList<String>> search(ArrayList<String> list) throws IOException {
	   

      Connection connection = null;
      PreparedStatement preparedStatement = null;
      
      ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
      
      try {
         DBConnection.getDBConnection(getServletContext());
         connection = DBConnection.connection;
         
         String query = "SELECT * FROM student ";
         
         
         if(!list.isEmpty()) {
        	 
        	 query += "WHERE " + String.join(" AND ", list);
        	 
         }
         
         query += ';' ;
         
         System.out.println(query);
         
                  

         preparedStatement = connection.prepareStatement(query);
         ResultSet rs = preparedStatement.executeQuery();
         
         if (!rs.isBeforeFirst() ) {    
//        	    out.println("No data with given email and phone"); 
        	    return result;
        	}

         while (rs.next()) {
        	 
            ArrayList<String> tmp = new ArrayList<String>();

            tmp.add(rs.getString(1));
            tmp.add(rs.getString(2));
            tmp.add(rs.getString(3));
            tmp.add(rs.getString(4));
            tmp.add(rs.getString(5));
            tmp.add(rs.getString(6));
            tmp.add(rs.getString(7));
            tmp.add(rs.getString(8));
            
            result.add(tmp);
            
         }
         rs.close();
         preparedStatement.close();
         connection.close();
         
         
      } catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (preparedStatement != null)
               preparedStatement.close();
         } catch (SQLException se2) {
         }
         try {
            if (connection != null)
               connection.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }
      }
      

      return result;

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
