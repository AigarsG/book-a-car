package bookacar.booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookacar.booking.dao.BookingDaoOld;
import bookacar.booking.dao.BookingDao;
import bookacar.booking.model.Booking;
import bookacar.car.dao.CarDaoOld;
import bookacar.car.dao.CarDao;
import bookacar.car.model.Car;
import bookacar.employee.model.Employee;

@WebServlet(urlPatterns = "/list-bookings.do")
public class ListBookingServlet extends HttpServlet {
	private BookingDao bDao = new BookingDao();
	private CarDao cDao = new CarDao();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Booking> bookings;
		Car[] cars;
		
		// Get employee set as session attibute
		Employee e = (Employee) request.getSession().getAttribute("employee");
		
		// Get list of bookings for the particular employee from database
		bookings = bDao.findByEmployeeId(e.getId());
		
		cars = new Car[bookings.size()];
		// Get all the car details
		for (int i = 0; i < bookings.size(); i++) {
			Booking b = bookings.get(i);
			List<Car> res = cDao.findById(b.getCarId());
			cars[i] = res.get(0);
		}
		
		System.out.println("cars are" + cars);
		
		// set bookings and cars list as variables in request in order to iterate over in JSP page
		request.setAttribute("bookings", bookings);
		request.setAttribute("cars", cars);
		
		// Forward request and response to login JSP page
		request.getRequestDispatcher("/WEB-INF/views/list-bookings.jsp")
				.forward(request, response);
	}

}
