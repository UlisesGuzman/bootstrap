<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Shoes Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/all-shoes">All Shoes</a></li>
					<li><a href="/new-shoe">New Shoe</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Shoe Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_SHOES'}">
			<div class="container text-center" id="shoesDiv">
				<h3>My shoes</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Model</th>
								<th>Description</th>
								<th>Price</th>
								<th>Size</th>

							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="shoe" items="${shoes}">
									<tr>
										<td>${shoe.id}</td>
										<td>${shoe.model}</td>
										<td>${shoe.description}</td>
										<td>${shoe.price}</td>
										<td>${shoe.size}</td>
										
										
										<td>
											<a href="update-shoe?id=${shoe.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-shoe?id=${shoe.id}">
												<span class="glyphicon glyphicon-trash"></span>
											</a>
										</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Shoe</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-shoe">
					<input type="hidden" name="id" value="${shoe.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Model:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="model" value="${shoe.model }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Description:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="description" value="${shoe.description }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Price:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="price" value="${shoe.price }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Size:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="size" value="${shoe.size }" />
							</div>
						</div>

						
						<div class="form-group">
							<input type="submit" class="btn btn-primary" value="Save" />
						</div>
						
				</form>
			</div>
		
		</c:when>
		
		
		
	</c:choose>

	<script type="text/javascript" src="/static/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js">
		
	</script>

</body>
</html>