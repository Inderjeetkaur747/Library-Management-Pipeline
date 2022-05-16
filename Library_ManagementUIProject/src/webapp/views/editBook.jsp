<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.LocalDate" %> 

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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Add Book</title>
</head>
<body>

	<div class="Container">
		<div class="row lib-header m-5 bg-light">
			<div class="col-md-6 text-center">
				<h2>Library Management System</h2>
			</div>
			<div class="col-md-4 text-end">
				<p>Welcome, ${userId}</p>
			</div>
			<div class="col-md-2">
				<a href="/logout"><button>Logout</button></a>
			</div>

		</div>
		<div class="row lib-content m-5">
		<h3 class="text-center">Edit Book</h3>
			<form action="/editBookForm" method="post">
				<div class="row mb-3">
					<label for="bookcode" class="col-sm-2 col-form-label">Book
						Code</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="bookcode" name="bookCode" value="${oldBook.getBookCode() }" readonly="readonly">
					</div>
				</div>
				<div class="row mb-3">
					<label for="bookname" class="col-sm-2 col-form-label">Book
						Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="bookname" name="bookName" value="${oldBook.getBookName() }" required="required">
					</div>
				</div>
				<div class="row mb-3">
					<label for="bookname" class="col-sm-2 col-form-label">Author
						Name</label>
						<div class="col-sm-10">
						<select class="form-control" id="authors" name="bookAuthor">
							<c:forEach var="author" items="${allAuthors}">
								<option value="${author.getFirstName()}  ${author.getLastName()}">${author.getFirstName()}  ${author.getLastName()}</option>
								
							</c:forEach>
						</select>
					</div>
					
				</div>
				
				<div class="row mb-3">
					<label for="addedOn" class="col-sm-2 col-form-label">Book
						Date</label>
					<div class="col-sm-10">
					<% LocalDate date=LocalDate.now();%>
						<input class="form-control" type="text" value="<%= date %>" name="bookDate" disabled="disabled">
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
				
			</form>
			<div class="text-end">
				<a href="/bookManagement"><button class="btn btn-danger">Cancel</button></a>
			</div>
			
		</div>
		<div class="row lib-footer"></div>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>