package com.example.flightSearch.controllers.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import com.example.flightSearch.business.abstracts.IFlightService;
import com.example.flightSearch.entities.Flight;




@RestController
@RequestMapping("/flights")

public class FlightController {
	
	private final IFlightService flightService;

	public FlightController(IFlightService flightService) {
		
		this.flightService = flightService;
	}
	
	@GetMapping
	public  List<Flight> getAllFlights(@RequestParam Optional<String> departureAirport, @RequestParam Optional<String> arrivalAirport,
									   @RequestParam Optional<LocalDateTime> departureDateTime,
									   @RequestParam Optional<LocalDateTime> returnDateTime )

	{
		return flightService.getAllFlights(departureAirport,arrivalAirport,departureDateTime,returnDateTime);
	}


	 @PostMapping
	    public Flight createFlight(@RequestBody Flight newFlight)
	    {
	    	return flightService.saveOneFlight(newFlight);
	    }
	 @GetMapping("/{flightId}")
	  public Flight getOneFlight(@PathVariable Long flightId)
	  { //custom exception
	    	return flightService.getOneFlightById(flightId);
	  }
	  @PutMapping("/{flightId}")
	    public Flight updateOneFlight(@PathVariable Long flightId,@RequestBody Flight newFlight)
	    {
	         return flightService.updateOneFlight(flightId,newFlight);
	    }
	    
	    @DeleteMapping("/{flightId}")
	    public void deleteOneFlight(@PathVariable Long flightId)
	    {
	    	flightService.deleteById(flightId);
	    }
	
	

}
