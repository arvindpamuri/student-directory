<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        	h1 {
				    width:100%;
				    /* margin: 10 auto; */
				    text-align: center;
				}
			#students {
			  font-family: Arial, Helvetica, sans-serif;
			  border-collapse: collapse;
			  width: 100%;
			}
			
			#students td, #students th {
			  border: 1px solid #ddd;
			  padding: 8px;
			}
			
			#students tr:nth-child(even){background-color: #f2f2f2;}
			
			#students tr:hover {background-color: #ddd;}
			
			#students th {
			  padding-top: 12px;
			  padding-bottom: 12px;
			  text-align: left;
			  background-color: #04AA6D;
			  color: white;
			}
		</style>
    </head>
    <body>
        <%-- <table id="messages" border="1">
            <tr>
                <th>Message</th>
                
                <th>Type</th>
            </tr>

            <c:forEach var="msg" items="${requestScope.messageList}">
                <tr>
                    <td>${msg[0]}</td>
                    <td>${msg[1]}</td>
                </tr>
            </c:forEach>    
        </table> --%>
        <h1>Student Details</h1>
        
        <table id="students">
        
          <tr>
          	<th>Student ID</th>
          	<th>First Name</th>
          	<th>Last Name</th>
          	<th>Phone Number</th>
          	<th>Email ID</th>
          	<th>Address</th>
          	<th>GPA</th>
          	<th>Graduation Date</th>
          </tr>
		  <c:forEach items="${result}" var="student">
		  	<tr>
		  		<c:forEach items="${student}" var="studentInfo">
		  			<td>${studentInfo}</td>
		  		</c:forEach>
		  	</tr>
		  </c:forEach>
		</table>
        
    </body>
</html>