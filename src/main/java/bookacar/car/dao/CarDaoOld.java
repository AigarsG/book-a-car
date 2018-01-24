package bookacar.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bookacar.car.model.Car;
import bookacar.common.database.DatabaseConnectionPool;

public class CarDaoOld {

	private List<Car> find(String query, Object args[]) {
		List<Car> res = new ArrayList<Car>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// handle connection
		try {

			conn = DatabaseConnectionPool.getConnection();

			// handle prepared statement
			try {

				pstmt = conn.prepareStatement(query);
				// set args
				for (int i = 0; i < args.length; i++) {
					Object arg = args[i];
					if (arg instanceof Integer) {
						pstmt.setInt(i + 1, (Integer) arg);
					} else if (arg instanceof String) {
						pstmt.setString(i + 1, (String) arg);
					}
				}
				rs = pstmt.executeQuery();

				// handle result set
				try {
					// while cars exist, add to list
					while (rs.next()) {
						Car c = new Car();
						c.setId(rs.getInt("id"));
						c.setManufacturer(rs.getString("manufacturer"));
						c.setModel(rs.getString("model"));
						c.setYear(rs.getInt("year"));
						res.add(c);
					}
				} catch (Exception e) {
					System.err.println(e);
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (Exception e) {
							System.err.println(e);
						}
					}
				}

			} catch (Exception e) {
				System.err.println(e);
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						System.err.println(e);
					}
				}
			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}

		return res;
	}

	public List<Car> findById(int id) {
		String query = "SELECT * FROM cars WHERE id=?";
		Object[] args = { (Integer) id };
		List<Car> res;
		
		res = find(query, args);
		return res;
	}

}
