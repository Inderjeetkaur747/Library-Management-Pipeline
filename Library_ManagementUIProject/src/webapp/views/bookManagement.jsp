<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% if(session.getAttribute("userId")==null)
		response.sendRedirect("/login");	
%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Library</title>
    <style>
    	thead, td, tr, th{
    		border: 1px solid black;
    	}
    </style>
  </head>
  <body>
  	<div class="Container">
	    <div class="row lib-header m-5 bg-light">
	    	<div class="col-md-6 text-center"><h2>Library Management System</h2></div>
	    	<div class="col-md-4 text-end"><p>Welcome, ${userId}</p></div>
	    	<div class="col-md-2"><a href="/logout"><button>Logout</button></a></div>
	    	
	    </div>
	    <div class="row lib-content m-5">
	    	<div class="row lib-content-header">
		    	<div class="col-md-8 text-center"><h4>Books Listing</h4></div>
		    	<div class="col-md-4">
		    		<a href="/addBook"><button class="btn btn-warning">Add Book</button></a>
		    	</div>
	    	</div>
	    	<p id="errorMessage" style="display:none; color:red" class="text-center p-2">Book Already Exist with this book code !!</p>
	    	<div class="row lib-content-table mt-3">
	    		<table>
	    			<thead>
	    				<th>S. No.</th>
	    				<th>Book Code</th>
	    				<th>Book Name</th>
	    				<th>Author</th>
	    				<th>Data Added</th>
	    				<th>Actions</th>
	    			</thead>
	    			
	    			<tbody>
	    				<% int count=0; %>
			<c:forEach var="book" items="${allBooks}">
				<tr><% count=count+1; %>
					<td><%= count %></td>
					<td>${book.getBookCode()}</td>
					<td>${book.getBookName()}</td>
					<td>${book.getBookAuthor()}</td>
					<td>${book.getBookDate()}</td>
					<td>
						<a href="/editBook/${book.getBookCode()}"><button class="border border-success text-success">Edit</button></a>
						<a href="/deleteBook/${book.getBookCode()}"><button class="border border-danger text-danger">Delete</button></a>
					</td>
				</tr>
			</c:forEach>
				
	    			</tbody>
	    		</table>
	    	</div>
	    </div>
	    <div class="row lib-footer text-center bg-light mt-5">
	    	<h5>"Nothing is pleasanter than exploring a library."</h5>
			<p> Walter Savage Landor</p> 
	    </div>
    </div>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
    
    <% if(session.getAttribute("bookAlreadyExist")=="true"){%>
    	<script type="text/javascript">
    	document.getElementById("errorMessage").style.display="block";
    	console.log("Book already exist");
    	</script>
    	
    	<%}
    	session.setAttribute("bookAlreadyExist", "false");
    	%>
  </body>
</html>