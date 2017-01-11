<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Lions Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-lion">New Lion</a></li>
					<li><a href="all-lions">All Lion</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Lion Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_LIONS'}">
			<div class="container text-center" id="lionsDiv">
				<h3>My lions</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Color</th>
								<th>Birth Date</th>
								<th>Alive</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="lion" items="${lions}">
									<tr>
										<td>${lion.id}</td>
										<td>${lion.name}</td>
										<td>${lion.color}</td>
										<td>
											<fmt:formatDate pattern="dd-MM-yyyy" value="${lion.birthdate}"/>
										</td>
										<td>${lion.alive==true?"YES":"NO"}</td>
										
										<td>
											<a href="update-lion?id=${lion.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-lion?id=${lion.id}">
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
				<h3>Manage Lion</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-lion">
					<input type="hidden" name="id" value="${lion.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Name:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="name" value="${lion.name }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Color:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="color" value="${lion.color }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Alive:</label>
							<div class="col-sm-7">
								<input type="radio" class="col-sm-1" name="alive" value="true"/>
								<div class="col-sm-1">YES</div>
									<input type="radio" class="col-sm-1" name="alive" value="false"checked="checked"/>
								<div class="col-sm-1">No</div>
							</div>
						</div>
						
						<div class="form-group">
							<input type="submit" class="btn btn-primary" value="Save" />
						</div>
						
				</form>
			</div>
		
		</c:when>
		
		
		
	</c:choose>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	
</body>
</html>