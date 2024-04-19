package com.api_customQueries01.api_customQueries01.Repositories;


import com.api_customQueries01.api_customQueries01.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findByDescription(String description);
    List<Flight> findByFromAirport(String fromAirport);
    List<Flight> findByToAirport(String toAirport);
    List<Flight> findByEnum(Enum statusEnum);

}