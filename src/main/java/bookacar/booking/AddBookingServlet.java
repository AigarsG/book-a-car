package bookacar.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bookacar.booking.dao.BookingDao;
import bookacar.booking.model.Booking;
import bookacar.car.dao.CarDao;
import bookacar.car.model.Car;
import bookacar.employee.model.Employee;

@WebServlet(urlPatterns = "/add-booking.do")
public class AddBookingServlet extends HttpServlet {
	private CarDao cDao = new CarDao();
	private BookingDao bDao = new BookingDao();
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<Car> cars = cDao.findAll();
		request.setAttribute("cars", cars);
		
		// Create JSON object including date ranges which should be disabled for a particular car
		HashMap<String, String> obj = new HashMap<>();		
		// Check if car id has been passed ( car selected )
		String carId = request.getParameter("selectedCar");
		if (carId != null) {
			Car selectedCar = cDao.findById(Integer.parseInt(carId)).get(0);
			System.out.println("car selected: " + selectedCar.toString());
			// Get all bookings against this car
			List<Booking> bookings = bDao.findByCarId(selectedCar.getId());
			
			// Build a JSON object with date intervals when car is taken
			for (Booking booking : bookings) {
				obj.put(booking.getFromDate().toString(), booking.getToDate().toString());
			}
			
			String jsonObj = new Gson().toJson(obj);
			System.out.println(jsonObj);
			out.print(jsonObj);
			out.flush();
			out.close();
			
		} else {
			//request.setAttribute("date_ranges_excluded", jsonObj);
			request.getRequestDispatcher("/WEB-INF/views/add-booking.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    Date fromDate = null;
	    Date toDate = null;
	    Employee e = (Employee) request.getSession().getAttribute("employee");
		int carId = Integer.parseInt(request.getParameter("selectedCar"));
		String fromDateString = request.getParameter("fromDate");
		String toDateString = request.getParameter("toDate");
		LocalDate fromDD = LocalDate.parse(fromDateString, df);
		LocalDate toDD = LocalDate.parse(toDateString, df);
		System.out.println(fromDD);
		System.out.println(toDD);

		fromDate = Date.valueOf(fromDD);
		toDate = Date.valueOf(toDD);

		Booking b = new Booking();
		b.setEmployeeId(e.getId());
		b.setCarId(carId);
		b.setFromDate(fromDate);
		b.setToDate(toDate);
		bDao.createBooking(b);
		response.sendRedirect("/list-bookings.do");
	}

}
