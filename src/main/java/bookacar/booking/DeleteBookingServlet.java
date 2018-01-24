package bookacar.booking;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookacar.booking.dao.BookingDaoOld;
import bookacar.employee.model.Employee;

@WebServlet(urlPatterns="/delete-booking.do")
public class DeleteBookingServlet extends HttpServlet {
	private BookingDaoOld bDao = new BookingDaoOld();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Employee e = (Employee) request.getSession().getAttribute("employee");
		// Get id of booking
		int bookingId = Integer.parseInt(request.getParameter("booking_id"));
				
		// delete booking for a particular employee
		bDao.deleteByIdAndEmployeeId(bookingId, e.getId());
		
		// Forward request and response to login JSP page
		request.getRequestDispatcher("/WEB-INF/views/list-bookings.jsp")
				.forward(request, response);
	}
}
