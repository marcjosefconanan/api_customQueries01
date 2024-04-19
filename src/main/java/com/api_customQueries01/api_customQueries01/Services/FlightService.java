package com.api_customQueries01.api_customQueries01.Services;

import com.api_customQueries01.api_customQueries01.Entities.Flight;
import com.api_customQueries01.api_customQueries01.Enum.StatusEnum;
import com.api_customQueries01.api_customQueries01.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    //     C
    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }

    //     R
    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }

    public Optional<Flight> findById(Long id){
        return flightRepository.findById(id);
    }

    //    U

    public Optional<Flight> updateFlight(Flight flight,Long id){
        Optional<Flight> updateFlight = flightRepository.findById(id);
        if(updateFlight.isPresent()){
            updateFlight.get().setDescription(flight.getDescription());
            updateFlight.get().setFromAirport(flight.getFromAirport());
            updateFlight.get().setStatusEnum(flight.getStatusEnum());
            updateFlight.get().setToAirport(flight.getToAirport());
            Flight flightUp = flightRepository.save(updateFlight.get());
            return Optional.of(flightUp);
        }
        return Optional.empty();
    }
    //       D
    public Optional<Flight> deleteFlight(Long id){
        Optional<Flight> delete = flightRepository.findById(id);
        if(delete.isPresent()){
            flightRepository.delete(delete.get());
        } else {
            return Optional.empty();
        }
        return delete;
    }

    public List<Flight> generateFlights() {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + random.nextInt(1000));
            flight.setFromAirport("Airport " + random.nextInt(100));
            flight.setToAirport("Airport " + random.nextInt(100));
            flight.setStatusEnum(StatusEnum.ONTIME);
            flights.add(flight);
            flightRepository.saveAndFlush(flight);
        }
        return flights;
    }
    public List<Flight> findByDescription(String descripton){
        List<Flight> list = flightRepository.findByDescription(descripton);
        for (Flight flight: list) {
            Flight flights = new Flight();
            flights.setDescription(flight.getDescription());
            flights.setToAirport(flight.getToAirport());
            flights.setStatusEnum(flight.getStatusEnum());
            flights.setFromAirport(flight.getFromAirport());
            list.add(flights);

        }
        return list;
    }
    public List<Flight> findByToAirport(String toAirport){
        List<Flight> listToAirport = flightRepository.findByToAirport(toAirport);
        for(Flight flight : listToAirport){
            Flight flights = new Flight();
            flights.setDescription(flight.getDescription());
            flights.setToAirport(flight.getToAirport());
            flights.setStatusEnum(flight.getStatusEnum());
            flights.setFromAirport(flight.getFromAirport());
            listToAirport.add(flights);
        }
        return listToAirport;
    }
    public List<Flight> findByFromAirport(String fromAirport){
        List<Flight> listFromAirport = flightRepository.findByFromAirport(fromAirport);
        for(Flight flight : listFromAirport){
            Flight flights = new Flight();
            flights.setDescription(flight.getDescription());
            flights.setToAirport(flight.getToAirport());
            flights.setStatusEnum(flight.getStatusEnum());
            flights.setFromAirport(flight.getFromAirport());
            listFromAirport.add(flights);
        }
        return listFromAirport;
    }
    public List<Flight> findByEnum(Enum statusEnum){
        List<Flight> liststatusEnum = flightRepository.findByFromAirport(String.valueOf(statusEnum));
        for(Flight flight : liststatusEnum){
            Flight flights = new Flight();
            flights.setDescription(flight.getDescription());
            flights.setToAirport(flight.getToAirport());
            flights.setStatusEnum(flight.getStatusEnum());
            flights.setFromAirport(flight.getFromAirport());
            liststatusEnum.add(flights);
        }
        return liststatusEnum;
    }
}
