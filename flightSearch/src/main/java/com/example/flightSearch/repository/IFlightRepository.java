package com.example.flightSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightSearch.entities.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeAndReturnDateTime(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime returnDateTime);

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTime(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime);
}
