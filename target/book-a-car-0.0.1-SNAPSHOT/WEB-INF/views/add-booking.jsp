<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<script type="text/javascript">
	var disabledDateRanges = {};

	function DisableSpecificDates(date) {
		var currentTime = new Date();
		var string = jQuery.datepicker.formatDate('yy-mm-dd', date);
		currentTime.setHours(0, 0, 0, 0);
		var show = true;
		console.log(disabledDateRanges);
		for ( var key in disabledDateRanges) {
			if (disabledDateRanges.hasOwnProperty(key)) {
				var value = disabledDateRanges[key];
				var fromDate = new Date(key);
				var toDate = new Date(value);
				var selDate = new Date(string);
				if (selDate.getTime() >= fromDate.getTime()
						&& selDate.getTime() <= toDate.getTime()) {
					show = false;
					break;
				}
			}
		}
		return [ show ];
	}

	$(document).ready(function() {
		
		// TODO Fix date_ranges_excluded not being included
		
		$("#selectedCar").blur(function(event) {
			$.ajax({
				type: 'GET',
				data: {
					selectedCar: $("#selectedCar").val()
				},
				headers: {
					Accept: "application/jsonl charset=utf-8",
					"Content-Type": "application/jsonl charset=utf-8"
				},
				success: function(exclusionRanges) {
					disabledDateRanges = JSON.parse(JSON.stringify(exclusionRanges));
				}
			});
		});
		
		$("#fromDate").datepicker({
			beforeShowDay : DisableSpecificDates,
			minDate : 0,
			onSelect : function(selected) {
				var dateSelected = new Date(selected);
				dateSelected.setHours(0, 0, 0, 0);
				$("#toDate").datepicker("option", "minDate", dateSelected);
			}
		});

		$("#toDate").datepicker({
			beforeShowDay : DisableSpecificDates,
			minDate : 0,
			onSelect : function(selected) {
				var dateSelected = new Date(selected);
				dateSelected.setHours(0, 0, 0, 0);
				$("#fromDate").datepicker("option", "maxDate", dateSelected);
			}
		});
	});
</script>

<div class="container">
	<form action="/add-booking.do" method="POST">
		<fieldset class="form-group">
			<label>Car</label> <select size="5" id="selectedCar" name="selectedCar"
				class="step form-control">
				<c:forEach items="${cars}" var="car">
					<option value="${car.id}">${car.year} ${car.model}</option>
				</c:forEach>
			</select>
		</fieldset>
		<fieldset class="form-group">
			<label>From</label> <input id="fromDate" type="text" name="fromDate"
				class="step form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>To</label> <input id="toDate" type="text" name="toDate"
				class="step form-control" />
		</fieldset>
		<input type="submit" value="Book" class="step btn btn-success" />
	</form>
</div>


<%@ include file="../common/footer.jspf"%>