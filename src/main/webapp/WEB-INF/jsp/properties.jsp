<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Properties Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-property">New Property</a></li>
					<li><a href="all-properties">All Property</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Property Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_PROPERTIES'}">
			<div class="container text-center" id="propertiesDiv">
				<h3>My properties</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>ExamTalk</th>
								<th>Question</th>
								<th>Alternative</th>
								<th>Checkk</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="property" items="${properties}">
									<tr>
										<td>${property.id}</td>
										<td>${property.examTalk}</td>
										<td>${property.question}</td>
										<td>${property.alternative}</td>
										<td>${property.checkk}</td>

										
										<td>
											<a href="update-property?id=${property.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-property?id=${property.id}">
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
				<h3>Manage Property</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-property">
					<input type="hidden" name="id" value="${property.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Exam Talk:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="examTalk" value="${property.examTalk }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Question:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="question" value="${property.question }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Alternative:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="alternative" value="${property.alternative }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Checkk:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="checkk" value="${property.checkk}" />
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