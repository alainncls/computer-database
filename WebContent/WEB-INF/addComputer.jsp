<jsp:include page="../include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1>Add Computer</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form" action="addComputer.jsp" method="POST">
				<div class="form-group">
					<label for="name">Computer name</label> <input type="text"
						class="form-control" id="name" placeholder="Enter name"
						required="required" />
					<p class="help-block">Required</p>
				</div>
				<div class="form-group">
					<label for="introduced">Introduced date</label> <input type="date"
						class="form-control" id="introduced" pattern="YY-MM-dd"
						placeholder="Introduced"> <span class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="discontinued">Discontinued date</label> <input
						type="date" class="form-control" id="discontinued"
						pattern="YY-MM-dd" placeholder="Discontinued" /> <span
						class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="company">Company Name:</label>
					<div class="input">
						<select name="company" class="form-control">
							<option value="0">--</option>
							<c:forEach items="${companies}" var="company">
								<option value="${company.id}">${company.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="actions">
					<button type="submit" class="btn btn-success">Submit</button>
					or <a href="dashboard" class="btn btn-danger">Cancel</a>
				</div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="../include/footer.jsp" />