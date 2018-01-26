package bookacar.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookacar.employee.dao.EmployeeDao;
import bookacar.employee.model.Employee;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	private EmployeeDao eDao = new EmployeeDao();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Forward request and response to login JSP page
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employee_id").trim();
		String password = request.getParameter("password").trim();

		List<Employee> e = eDao.findByEmployeeIdAndPassword(employeeId,
				password);

		if (e.size() == 1) {
			// set session attribute to employee object and forward to main page
			request.getSession().setAttribute("employee", e.get(0));
			response.sendRedirect("/list-bookings.do");
		} else {
			// raise error and redirect to login.do page
			request.setAttribute("errorMessage",
					"Invalid username or password!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
					request, response);
		}

	}
}
