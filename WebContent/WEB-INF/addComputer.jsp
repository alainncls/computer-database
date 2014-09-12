<jsp:include page="../include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1>Add Computer</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form" action="addComputer" method="POST">
				<input type="hidden" name="id" value="${computer.id}"/>
				<div class="form-group">
					<label for="name">Computer name</label>
					<input type="text" class="form-control" value="${computer.name}" id="name" name="name" placeholder="Enter name" required="required" />
					<p class="help-block">Required</p>
				</div>
				<div class="form-group">
					<label for="introduced">Introduced date</label> 
					<input type="date" class="form-control" value="${fn:substring(computer.introduced, 0, 10)}" id="introduced" name="introduced" placeholder="Introduced">
					<span class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="discontinued">Discontinued date</label>
					<input type="date" class="form-control" value="${fn:substring(computer.discontinued, 0, 10)}" id="discontinued" name="discontinued" placeholder="Discontinued" />
					<span class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="company">Company Name:</label>
					<div class="input">
						<select name="company" class="form-control">
							<option value="0">--</option>
							<c:forEach items="${companies}" var="company">
							<option value="${company.id}" ${company.id == computer.company.id ? 'selected' : ''}>${company.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="actions">
				<input type="submit" class="btn btn-success" value="Submit" />
				or <a href="dashboard" class="btn btn-danger">Cancel</a>
			</div>
		</form>
	</div>
</div>
</div>

<jsp:include page="../include/footer.jsp" />