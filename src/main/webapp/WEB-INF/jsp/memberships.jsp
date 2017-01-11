<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Membership Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-membership">New Membership</a></li>
					<li><a href="all-memberships">All Membership</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Membership Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_MEMBERSHIPS'}">
			<div class="container text-center" id="membershipsDiv">
				<h3>My membership</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Last Renewal Date</th>
								<th>Member Since</th>
								<th>Membership Type</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="membership" items="${memberships}">
									<tr>
										<td>${membership.id}</td>
										<td>${membership.lastRenewalDate}</td>
										<td>${membership.memberSince}</td>
										<td>${membership.membershipType}</td>
																				
										<td>
											<a href="update-membership?id=${membership.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-membership?id=${membership.id}">
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
				<h3>Manage Membership</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-membership">
					<input type="hidden" name="id" value="${membership.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Last Renewal Date:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="lastRenewalDate" value="${membership.lastRenewalDate}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Member Since:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="memberSince" value="${membership.memberSince }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Membership Type:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="membershipType" value="${membership.membershipType}" />
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