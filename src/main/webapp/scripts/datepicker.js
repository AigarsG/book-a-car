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
	
	$(function() {
		$("#toDate").datepicker({
			beforeShowDay : DisableSpecificDates,
			minDate : 0
		});
	});