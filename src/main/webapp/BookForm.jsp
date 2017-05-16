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
        <li > <a href="/list">List All Books</a></li>
        <li class="active"> <a href="/new"><c:if test="${book != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${book == null}">
                        Add New Book
                    </c:if></a></li>
      </ul>
      
    </div>
  </div>
</nav>
<div class = "row">
    <div class="col-md-6 col-md-offset-3">
        <c:if test="${book != null}">
            <form class="form-horizontal" action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form class="form-horizontal" action="insert" method="post">
        </c:if>
        
        <div class="form-group">
        <label class="control-label col-sm-2" for="title">Title:</label>
	    <div class="col-sm-10">
	      <input name="title" size="45" class="form-control" id="title" placeholder="Enter title"   value="<c:out value='${book.title}' />">
	    </div>
        </div>
        
        <div class="form-group">
        <label class="control-label col-sm-2" for="author">Author:</label>
	    <div class="col-sm-10">
	      <input name="author" size="45" class="form-control" id="author" placeholder="Enter author"   value="<c:out value='${book.author}' />">
	    </div>
        </div>
        
        <div class="form-group">
        <label class="control-label col-sm-2" for="price">Price: </label>
	    <div class="col-sm-10">
	      <input name="price" size="5" class="form-control" id="price" placeholder="Enter price"   value="<c:out value='${book.price}' />">
	    </div>
        </div>
        <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
      
        </form>
    </div>   
    </div>
</body>
</html>