<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Booking ID</th>
				<th>Car model</th>
				<th>Car year</th>
				<th>From date</th>
				<th>To date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!-- iterate over bookings variable with forEach loop and list all bookings in the table -->
			<c:forEach items="${bookings}" var="booking" varStatus="status">
				<tr>
					<td>${booking.id}</td>
					<td>${cars[status.index].model}</td>
					<td>${cars[status.index].year}</td>
					<td>${booking.fromDate}</td>
					<td>${booking.toDate}</td>
					<td><a href="/delete-booking.do?booking_id=${booking.id}" class="btn btn-danger">Cancel</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/add-booking.do" class="btn btn-success">Add new</a>
</div>

<%@ include file="../common/footer.jspf"%>
