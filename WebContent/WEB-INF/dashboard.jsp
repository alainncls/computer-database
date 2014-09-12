<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1 id="homeTitle">${noOfRecords} computers found</h1>
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
	<div class="row">
		<div class="col-md-12">
			<div class="text-center">
				<ul class="pagination pagination-sm">
					<c:if test="${currentPage != 1}">
						<li><a href="?page=${currentPage - 1}">Previous</a></li>
					</c:if>

					<c:forEach begin="${(currentPage - 3)<0?1:currentPage-3}"
						end="${(currentPage + 3)>noOfPages?noOfPages:currentPage + 3}"
						var="i">
						<c:choose>
							<c:when test="${currentPage eq i}">
								<li class="active"><a href="">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="?page=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${currentPage lt noOfPages}">
						<li><a href="?page=${currentPage + 1}">Next</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />
