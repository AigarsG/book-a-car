<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<form action="/login.do" method="POST">
		<p>
			<font color="red">${errorMessage}</font>
		</p>
		<fieldset class="form-group">
			<label>Employee ID</label> <input type="text" name="employee_id"
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input type="text" name="password"
				class="form-control" />
		</fieldset>
		<input type="submit" value="Login" class="btn btn-success" />
	</form>
</div>

<%@ include file="../common/footer.jspf"%>