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
			
			button {
			  background-color: #4CAF50;
			  border: none;
			  color: white;
			  padding: 15px 32px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 16px;
			  margin: 20px 2px;
			  cursor: pointer;
			}
			
			.end {
				display: block;
			    margin-left: auto;
			    margin-right: auto }
			}
			
		</style>
    </head>
    <body>
    
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
		
		
		<div class="end">
			<c:choose>
			    <c:when test="${empty result}">
			      <p>No data found with the provided info.</p>
			    </c:when>
			</c:choose>
			<a href="searchstudent.html">
				<button>Back to Search</button>
			</a>
			<a href="/webproject-orm/addStudent.html">
				<button>Add new student entry</button>
		</div>
		
		
        
    </body>
</html>