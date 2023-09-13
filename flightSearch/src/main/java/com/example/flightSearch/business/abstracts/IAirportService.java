package com.example.flightSearch.business.abstracts;

import java.util.List;

import com.example.flightSearch.entities.Airport;


public interface IAirportService {

	List<Airport> getAllAirports();

	

	Airport getOneAirportById(Long airportId);

	Airport updateOneAirport(Long airportId, Airport newAirport);

	void deleteById(Long airportId);



	Airport saveOneAirport(Airport newAirport);



	

	

}
