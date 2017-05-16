<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	

</head>
<body>
<style>
.glyphicon{
padding:5px;
}

   .glyphicon-remove{
   color:#d43d80;} 
</style>

<div class="container-fluid"  style="
    padding-right: 0px;
    padding-left: 0px;">
<nav class="navbar navbar-inverse" >
  <div class="container-fluid" >
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav " style=" padding:0 40%;">
        <li class="active"> <a href="/list">List All Books</a></li>
        <li> <a href="/new">Add New Book</a></li>
      </ul>
      
    </div>
  </div>
</nav>
<div class = "row">
	

   
    <div class="col-md-6 col-md-offset-3" >
        <table class="table table-bordered" >
          
            <tr>
                
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th colspan=2>Action</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                   
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${book.id}' />"><span class="glyphicon  glyphicon-pencil"></span></a>
                        <a href="/delete?id=<c:out value='${book.id}' />"><span class="glyphicon glyphicon-remove"></a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
         </div> 
         </div>  
    </div>   
</body>
</html>