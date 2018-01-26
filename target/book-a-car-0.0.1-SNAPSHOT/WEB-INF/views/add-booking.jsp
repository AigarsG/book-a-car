<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<script type="text/javascript">
	var disabledDateRanges = JSON.parse("${date_ranges_excluded}");

	function DisableSpecificDates(date) {
		var currentTime = new Date();
		var string = jQuery.datepicker.formatDate('yy-mm-dd', date);
		currentTime.setHours(0, 0, 0, 0);
		var show = true;
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

	$(function() {
		$("#fromDate").datepicker({
			beforeShowDay : DisableSpecificDates,
			minDate : 0
		});
	});
</script>

<div class="container">
	<form action="/add-bookings.do" method="POST">
		<p>
			<font color="red">${errorMessage}</font>
		</p>
		<fieldset class="form-group">
			<label>From</label> <input id="fromDate" type="text"
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>To</label> <input id="toDate" type="text" class="form-control" />
		</fieldset>
		<input type="submit" value="Book" class="btn btn-success" />
	</form>
</div>



<%@ include file="../common/footer.jspf"%>