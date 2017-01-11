<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Pencils Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/all-pencils">All Pencils</a></li>
					<li><a href="/new-pencil">New pencil</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Pencil Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_PENCILS'}">
			<div class="container text-center" id="pencilsDiv">
				<h3>My Pencils</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Description</th>
								<th>Size</th>
								<th>Color</th>

							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="pencil" items="${pencils}">
									<tr>
										<td>${pencil.id}</td>
										<td>${pencil.name}</td>
										<td>${pencil.description}</td>
										<td>${pencil.size}</td>
										<td>${pencil.color}</td>

										<td>
											<a href="update-pencil?id=${pencil.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-pencil?id=${pencil.id}">
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
				<h3>Manage Pencil</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-pencil">
					<input type="hidden" name="id" value="${pencil.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Name:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="name" value="${pencil.name }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Description:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="description" value="${pencil.description }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Size:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="size" value="${pencil.size}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Color:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="color" value="${pencil.color }" />
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