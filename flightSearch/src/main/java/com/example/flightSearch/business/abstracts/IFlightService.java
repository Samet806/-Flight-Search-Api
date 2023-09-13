package com.example.flightSearch.business.abstracts;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.flightSearch.entities.Flight;

public interface IFlightService {



	Flight saveOneFlight(Flight newFlight);

	Flight getOneFlightById(Long flightId);

	Flight updateOneFlight(Long flightId, Flight newFlight);

	void deleteById(Long flightId);

	List<Flight> getAllFlights(Optional<String> departureAirport, Optional<String> arrivalAirport, Optional<LocalDateTime> departureDateTime, Optional<LocalDateTime> returnDateTime);
}
