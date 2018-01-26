package bookacar.booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bookacar.booking.model.Booking;
import bookacar.common.dao.Dao;

public class BookingDao extends Dao<Booking> {

	@Override
	protected Booking rowToObj(ResultSet rs) throws SQLException {
		Booking b = new Booking();
		b.setId(rs.getInt("id"));
		b.setEmployeeId(rs.getInt("employee_id"));
		b.setCarId(rs.getInt("car_id"));
		b.setFromDate(rs.getDate("from_date"));
		b.setToDate(rs.getDate("to_date"));
		return b;
	}
	
	public List<Booking> findByEmployeeId(int id) {
		String query = "SELECT * FROM bookings WHERE employee_id=?";
		Object[] args = { (Integer) id };
		List<Booking> res;

		res = executeQuery(query, args, false);

		return res;
	}
	
	public List<Booking> findByCarId(int id) {
		String query = "SELECT * FROM bookings WHERE car_id=?";
		Object[] args = { (Integer) id };
		List<Booking> res;

		res = executeQuery(query, args, false);

		return res;
	}
	
	public List<Booking> findById(int id) {
		String query = "SELECT * FROM bookings WHERE id=?";
		Object[] args = { (Integer) id };
		List<Booking> res;

		res = executeQuery(query, args, false);
		return res;
	}
	
	public void deleteByIdAndEmployeeId(int id, int employeeId) {
		String query = "DELETE FROM bookings WHERE id=? AND employee_id=?";
		Object[] args = { (Integer) id, (Integer) employeeId };
		executeQuery(query, args, true);
	}
	
	public void createBooking(Booking b) {
		String query = "INSERT INTO bookings (employee_id, car_id, from_date, to_date) VALUES (?,?,?,?)";
		Object[] args = {(Integer) b.getEmployeeId(), (Integer) b.getCarId(), b.getFromDate(), b.getToDate()};
		executeQuery(query, args, true);
	}

}
