package com.example.flightSearch.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.flightSearch.business.abstracts.IFlightService;
import com.example.flightSearch.entities.Flight;
import com.example.flightSearch.repository.IFlightRepository;
@Service
public class FlightManager implements IFlightService {
	
	private final IFlightRepository flightRepository;

	public FlightManager(IFlightRepository flightRepository) {
	
		this.flightRepository = flightRepository;
	}

	@Override
	public List<Flight> getAllFlights(Optional<String> departureAirport, Optional<String> arrivalAirport, Optional<LocalDateTime> departureDateTime, Optional<LocalDateTime> returnDateTime) {
		if(departureAirport.isPresent() && arrivalAirport.isPresent() &&  departureDateTime.isPresent() && returnDateTime.isPresent())
		{
			return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTimeAndReturnDateTime(departureAirport.get(),arrivalAirport.get(),departureDateTime.get(),returnDateTime.get());
		}
		else if(departureAirport.isPresent() && arrivalAirport.isPresent() &&  departureDateTime.isPresent() )
		{
			return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTime(departureAirport.get(),arrivalAirport.get(),departureDateTime.get());
		}
		else
			return flightRepository.findAll();


	}

	@Override
	public Flight saveOneFlight(Flight newFlight) {
		// TODO Auto-generated method stub
		return flightRepository.save(newFlight);
	}

	@Override
	public Flight getOneFlightById(Long flightId) {
		// TODO Auto-generated method stub
		return flightRepository.findById(flightId).orElse(null);
	}

	@Override
	public Flight updateOneFlight(Long flightId, Flight newFlight) {
		// TODO Auto-generated method stub
		Optional<Flight> flight=flightRepository.findById(flightId);
		if(flight.isPresent())
		{
			Flight foundFlight=flight.get();
			foundFlight.setArrivalAirport(newFlight.getArrivalAirport());
			foundFlight.setDepartureAirport(newFlight.getDepartureAirport());
			foundFlight.setDepartureDateTime(newFlight.getDepartureDateTime());
			foundFlight.setPrice(newFlight.getPrice());
			foundFlight.setReturnDateTime(newFlight.getReturnDateTime());
			flightRepository.save(foundFlight);
			return foundFlight;
			
			
		}
		return null;
	}

	@Override
	public void deleteById(Long flightId) {
		
		flightRepository.deleteById(flightId);
		
	}




}
