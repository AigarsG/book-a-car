package bookacar.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bookacar.booking.model.Booking;
import bookacar.common.database.DatabaseConnectionPool;

public class BookingDaoOld {

	private List<Booking> find(String query, Object args[]) {
		List<Booking> res = new ArrayList<Booking>();
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
					// while bookings exist, add to list
					while (rs.next()) {
						Booking b = new Booking();
						b.setId(rs.getInt("id"));
						b.setEmployeeId(rs.getInt("employee_id"));
						b.setCarId(rs.getInt("car_id"));
						b.setFromDate(rs.getDate("from_date"));
						b.setToDate(rs.getDate("to_date"));
						res.add(b);
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

	public List<Booking> findById(int id) {
		String query = "SELECT * FROM bookings WHERE id=?";
		Object[] args = { (Integer) id };
		List<Booking> res;

		res = find(query, args);
		return res;
	}

	public List<Booking> findByEmployeeId(int id) {
		String query = "SELECT * FROM bookings WHERE employee_id=?";
		Object[] args = { (Integer) id };
		List<Booking> res;

		res = find(query, args);

		return res;
	}
	
	public void deleteByIdAndEmployeeId(int id, int employeeId) {
		String query = "DELETE FROM bookings WHERE id=? AND employee_id=?";
		Object[] args = { (Integer) id, (Integer) employeeId };
		delete(query, args);
	}

	private void delete(String query, Object[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		// handle connection
		try {

			conn = DatabaseConnectionPool.getConnection();

			// handle prepared statement
			try {
				pstmt = conn.prepareStatement(query);
				for (int i = 0; i < args.length; i++) {
					Object arg = args[i];
					if (arg instanceof Integer) {
						pstmt.setInt(i + 1, (Integer) arg);
					} else if (arg instanceof String) {
						pstmt.setString(i + 1, (String) arg);
					}
				}
				pstmt.executeQuery();
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
	
	}
}
