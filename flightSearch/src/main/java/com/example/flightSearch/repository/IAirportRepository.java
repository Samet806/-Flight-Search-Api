package com.example.flightSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightSearch.entities.Airport;

public interface IAirportRepository extends JpaRepository< Airport, Long> {

}
