<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
        <!-- Application  CSS -->
    <link href="<c:url value="/resources/css/application.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/dataTables.bootstrap.css" />" rel="stylesheet">


  </head>

  <body>

 <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand"href="/SpringJdbcBlogWithXmlConfig/">Spring Blog</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Menu <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/SpringJdbcBlogWithXmlConfig/auth/login">Login</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">     
      <h1>Server Side Pagination</h1>
        <a class="btn btn-primary btn-lg" href="/PnP/" role="button">Home</a>
        <a class="btn btn-primary btn-lg" href="/PnP/bookDataTableHome" role="button">Back</a>
      </div>
    </div>

    <div class="container">
    
       <div class="row">
          <div class="col-sm-8 col-md-offset-2">
		   <div class="form-group row">
		      <div class="col-sm-4">
	           <select name="type" id="typeFilter" class="form-control" >
	              <option selected value="all">All</option>
				  <option value="networking">Networking</option>
				  <option value="programming">Programming</option>
				  <option value="other">Other</option>
				</select>
	          </div>
	       </div>
		</div>
       </div>
    
      <div class="row">
      
	    <div class="col-md-8 col-md-offset-2 well">
		    <table class="table" id="serverSidePaginationTable">
			  <thead class="thead-default">
			    <tr>
			      <th>#</th>
			      <th>Book Name</th>
			      <th>Book Type</th>
			    </tr>
			  </thead>
	        </table>
	    </div>
    
      </div>
      
	
    
      
      <hr>
      <footer>
      <div>
         <p class="text-center">&copy; 2016 Company, Inc.</p>
      </div>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="<c:url value="/resources/js/jquery-2.1.3.min.js" />"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>
    <script src="<c:url value="/resources/js/bookDataTableServerSidePagin.js" />"></script>
    <script src="<c:url value="/resources/js/application.js" />"></script>
  </body>
</html>