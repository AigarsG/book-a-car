package bookacar.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bookacar.employee.model.Employee;
import bookacar.common.database.DatabaseConnectionPool;

public class EmployeeDaoOld {

	private List<Employee> find(String query, String args[]) {
		List<Employee> res = new ArrayList<Employee>();
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
					pstmt.setString(i + 1, args[i]);
				}
				rs = pstmt.executeQuery();

				// handle result set
				try {
					// while employees exist, add to list
					while (rs.next()) {
						Employee e = new Employee();
						e.setId(rs.getInt("id"));
						e.setFirstName(rs.getString("first_name"));
						e.setLastName(rs.getString("last_name"));
						e.setEmployeeId(rs.getString("employee_id"));
						e.setPassword(rs.getString("password"));
						res.add(e);
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

	public List<Employee> findById(int id) {
		String query = "SELECT * FROM employees WHERE id=?";
		String[] args = { Integer.toString(id) };
		List<Employee> res;

		res = find(query, args);

		return res;
	}

	public List<Employee> findByEmployeeIdAndPassword(String employeeId,
			String password) {
		String query = "SELECT * FROM employees WHERE employee_id=? AND password=?";
		String[] args = { employeeId, password };
		List<Employee> res;

		res = find(query, args);

		return res;
	}

}
