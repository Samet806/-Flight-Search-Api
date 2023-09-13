package com.example.flightSearch.controllers.concretes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.flightSearch.business.abstracts.IAirportService;
import com.example.flightSearch.entities.Airport;



@RestController
@RequestMapping("/airports")

public class AirportController {
	private IAirportService airportService;
	public AirportController(IAirportService airportService)
	{
		this.airportService=airportService;
	}
	
	@GetMapping
	public List<Airport> getAllAirports()
	{
		return airportService.getAllAirports();
	}
	
	@PostMapping
    public Airport createAirport(@RequestBody Airport newAirport)
    {
    	return airportService.saveOneAirport(newAirport);
    }
 @GetMapping("/{airportId}")
  public Airport getOneAirport(@PathVariable Long airportId)
  { //custom exception
    	return airportService.getOneAirportById(airportId);
  }
  @PutMapping("/{airportId}")
    public Airport updateOneAirport(@PathVariable Long airportId,@RequestBody Airport newAirport)
    {
         return airportService.updateOneAirport(airportId,newAirport);
    }
    
    @DeleteMapping("/{airportId}")
    public void deleteOneAirport(@PathVariable Long airportId)
    {
    	airportService.deleteById(airportId);
    }

}
