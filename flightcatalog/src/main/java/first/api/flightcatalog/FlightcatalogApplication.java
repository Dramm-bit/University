package first.api.flightcatalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import first.api.flightcatalog.model.Booking;
import first.api.flightcatalog.model.BookingStatus;
import first.api.flightcatalog.model.Flight;
import first.api.flightcatalog.model.Gender;
import first.api.flightcatalog.model.PaymentInfo;
import first.api.flightcatalog.model.User;
import first.api.flightcatalog.repositories.BookingRepository;
import first.api.flightcatalog.repositories.EmployeeRepository;
import first.api.flightcatalog.repositories.FlightRepository;
import first.api.flightcatalog.repositories.PaymentInfoRepository;
import first.api.flightcatalog.repositories.UserRepository;

@SpringBootApplication
public class FlightcatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightcatalogApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookingRepository bookingRepository, EmployeeRepository employeeRepository,
			FlightRepository flightRepository, PaymentInfoRepository paymentInfoRepository,
			UserRepository userRepository) {

		return args -> {

			PaymentInfo paymentInfo = new PaymentInfo();
			paymentInfo.setPaymentMethod("jcb");
			paymentInfo.setCardNumber(356395063);
			paymentInfo.setPostalCode(1888368721);
			paymentInfo.setCountry("Kebonkaret");
			paymentInfo.setState("haud");
			paymentInfoRepository.save(paymentInfo);

			paymentInfo = new PaymentInfo();
			paymentInfo.setPaymentMethod("laser");
			paymentInfo.setCardNumber(126876370);
			paymentInfo.setPostalCode(296678548);
			paymentInfo.setCountry("Arrentela");
			paymentInfo.setState("Setúbal");
			paymentInfoRepository.save(paymentInfo);

			paymentInfo = new PaymentInfo();
			paymentInfo.setPaymentMethod("diners-club-enroute");
			paymentInfo.setCardNumber(20159094);
			paymentInfo.setPostalCode(5875022);
			paymentInfo.setCountry("Yoichi");
			paymentInfo.setState("saitama");
			paymentInfoRepository.save(paymentInfo);

		

			User customer = new User();
			customer.setFullName("rocio");
			customer.setGender(Gender.FEMALE);
			customer.setBirthday("22-01-2002");
			//customer.setPaymentInfo(paymentInfo);
			userRepository.save(customer);

			customer = new User();
			customer.setFullName("arturo");
			customer.setGender(Gender.MALE);
			customer.setBirthday("24-03-2000");
			//customer.setPaymentInfo(paymentInfo);
			userRepository.save(customer);

			customer = new User();
			customer.setFullName("Stevan");
			customer.setGender(Gender.MALE);
			customer.setBirthday("24-03-1980");
			// customer.setPaymentInfo(paymentInfo);
			userRepository.save(customer);

			Flight flight = new Flight();
			flight.setDepartureDate("11/9/2021");
			flight.setArrivalAirportCode("49035-236");
			flight.setDepartureAirportName("Osinski and Sons");
			flight.setDepartureCity("São José de Mipibu");
			flight.setDepartureLocale("Hangu");
			flight.setArrivalDate("8/26/2022");
			flight.setArrivalAirportCode("66993-056");
			flight.setArrivalAirportName("Parker-Gutkowski");
			flight.setArrivalCity("Shalazhi");
			flight.setArrivalLocale("Jubaoshan");
			flight.setTicketPrice(34263.43);
			flight.setTicketCurrency("Real");
			flight.setFlightNumber(534596825);
			flight.setSeatCapacity(33);
			flightRepository.save(flight);

			flight = new Flight();
			flight.setDepartureDate("2/21/2022");
			flight.setArrivalAirportCode("68745-1070");
			flight.setDepartureAirportName("Hessel LLC");
			flight.setDepartureCity("San Martin");
			flight.setDepartureLocale("San Martin");
			flight.setArrivalDate("9/14/2021");
			flight.setArrivalAirportCode("0121-0788");
			flight.setArrivalAirportName("Hammes LLC");
			flight.setDepartureAirportCode("aijsdoasiojaiofjodfjwoe");
			flight.setArrivalCity("Cikalong");
			flight.setArrivalLocale("Vila Franca do Campo");
			flight.setTicketPrice(45497.81);
			flight.setTicketCurrency("Peso");
			flight.setFlightNumber(802589642);
			flight.setSeatCapacity(28);
			flightRepository.save(flight);

			Booking booking = new Booking();
			booking.setPaymentToken("RO34 ENQC 5BS6 8RCH ZWVN PKLE");
			booking.setCheckedIn(true);
			booking.setCreatedAt("11/1/2021");
			//booking.setOutboundflight(flight);
			//booking.setCustomer(customer);
			booking.setBookingReference("170.87.26.46");
			booking.setStatus(BookingStatus.CONFIRMED);
			bookingRepository.save(booking);
			
			/*  */

		};

	}

}
