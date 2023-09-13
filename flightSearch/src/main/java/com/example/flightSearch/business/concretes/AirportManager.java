package com.example.flightSearch.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.flightSearch.business.abstracts.IAirportService;
import com.example.flightSearch.entities.Airport;

import com.example.flightSearch.repository.IAirportRepository;
@Service
public class AirportManager implements IAirportService {
	
	private IAirportRepository airportRepository;

	public AirportManager(IAirportRepository airportRepository) {
		
		this.airportRepository = airportRepository;
	}

	@Override
	public List<Airport> getAllAirports() {

		return airportRepository.findAll();
	}

	@Override
	public Airport getOneAirportById(Long airportId) {

		return airportRepository.findById(airportId).orElse(null);
	}

	@Override
	public Airport updateOneAirport(Long airportId, Airport newAirport) {
		Optional<Airport> airport=airportRepository.findById(airportId);
		if(airport.isPresent())
		{
			Airport foundAirport=airport.get();
			foundAirport.setCity(newAirport.getCity());
			airportRepository.save(foundAirport);
	
			return foundAirport;
			
			
		}
		return null;
	}

	@Override
	public void deleteById(Long airportId) {
		
		airportRepository.deleteById(airportId);
		
	}

	@Override
	public Airport saveOneAirport(Airport newAirport) {

		return airportRepository.save(newAirport);
	}
	

}
