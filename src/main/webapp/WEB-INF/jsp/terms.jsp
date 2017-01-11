<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Terms Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-term">New Term</a></li>
					<li><a href="all-terms">All Term</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Term Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_TERMS'}">
			<div class="container text-center" id="termsDiv">
				<h3>My terms</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Type</th>
								<th>Acc</th>
								<th>Obsolete</th>
								<th>Root</th>
								<th>Relation</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="term" items="${terms}">
									<tr>
										<td>${term.id}</td>
										<td>${term.name}</td>
										<td>${term.type}</td>
										<td>${term.acc}</td>
										<td>${term.obsolete}</td>
										<td>${term.root}</td>
										<td>${term.relation}</td>
									
										
										<td>
											<a href="update-term?id=${term.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-term?id=${term.id}">
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
				<h3>Manage Term</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-term">
					<input type="hidden" name="id" value="${term.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Name:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="name" value="${term.name }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Type:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="type" value="${term.type }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Acc:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="acc" value="${term.acc }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Obsolete:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="obsolete" value="${term.obsolete }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Root:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="root" value="${term.root}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Relation:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="relation" value="${term.relation}" />
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