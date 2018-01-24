package bookacar.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bookacar.common.dao.Dao;
import bookacar.employee.model.Employee;

public class EmployeeDao extends Dao<Employee> {

	@Override
	protected Employee rowToObj(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt("id"));
		e.setFirstName(rs.getString("first_name"));
		e.setLastName(rs.getString("last_name"));
		e.setEmployeeId(rs.getString("employee_id"));
		e.setPassword(rs.getString("password"));
		return e;
	}
	
	public List<Employee> findById(int id) {
		String query = "SELECT * FROM employees WHERE id=?";
		String[] args = { Integer.toString(id) };
		List<Employee> res;

		res = executeQuery(query, args, false);

		return res;
	}

	public List<Employee> findByEmployeeIdAndPassword(String employeeId,
			String password) {
		String query = "SELECT * FROM employees WHERE employee_id=? AND password=?";
		String[] args = { employeeId, password };
		List<Employee> res;

		res = executeQuery(query, args, false);

		return res;
	}

}
