<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Result Page</title>
        <style>
        	h1 {
				    width:100%;
				    /* margin: 10 auto; */
				    text-align: center;
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
    
        <h1>Student details added to repository</h1>
		
		<div class="end">
		
			<a href="searchstudent.html">
				<button>Search for a student</button>
			</a>
			<a href="addStudent.html">
				<button>Add another student entry</button>
			</a>
		</div>
		
		
        
    </body>
</html>