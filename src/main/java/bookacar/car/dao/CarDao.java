package bookacar.car.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bookacar.booking.model.Booking;
import bookacar.car.model.Car;
import bookacar.common.dao.Dao;

public class CarDao extends Dao<Car> {

	@Override
	protected Car rowToObj(ResultSet rs) throws SQLException {
		Car c = new Car();
		c.setId(rs.getInt("id"));
		c.setManufacturer(rs.getString("manufacturer"));
		c.setModel(rs.getString("model"));
		c.setYear(rs.getInt("year"));
		return c;
	}
	
	public List<Car> findById(int id) {
		String query = "SELECT * FROM cars WHERE id=?";
		Object[] args = { (Integer) id };
		List<Car> res;
		
		res = executeQuery(query, args, false);
		return res;
	}

}
