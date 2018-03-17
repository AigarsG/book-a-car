package bookacar.booking.model;

import bookacar.common.model.Model;

import java.sql.Date;

public class Booking extends Model {
	private int employeeId;
	private int carId;
	private Date fromDate;
	private Date toDate;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return String
				.format("Booking [id=%s, employeeId=%s, carId=%s, fromDate=%s, toDate=%s]",
						getId(), employeeId, carId, fromDate, toDate);
	}

}
