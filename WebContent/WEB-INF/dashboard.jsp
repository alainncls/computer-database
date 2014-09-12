<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1 id="homeTitle">${fn:length(computers)} Computers found</h1>
		</div>
	</div>
	<div class="row" id="actions">
		<div class="col-md-10">
			<form action="" method="GET" class="form-inline" role="form">
				<input type="search" id="searchbox" name="search"
					class="form-control" value="" placeholder="Search name"> <input
					type="submit" id="searchsubmit" value="Filter by name"
					class="btn btn-primary">
			</form>
		</div>
		<div class="col-md-2">
			<a id="add" href="addComputer" role="button"
				class="btn btn-success pull-right">Add Computer</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="computers table table-striped table-bordered">
				<thead>
					<tr>
						<!-- Variable declarations for passing labels as parameters -->
						<!-- Table header for Computer Name -->
						<th>Computer Name</th>
						<th>Introduced Date</th>
						<!-- Table header for Discontinued Date -->
						<th>Discontinued Date</th>
						<!-- Table header for Company -->
						<th>Company</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${computers}" var="computer">
						<tr>
							<td><a href="#" onclick="">${computer.name}</a></td>
							<td>${computer.introduced}</td>
							<td>${computer.discontinued}</td>
							<td>${computer.company.name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />
