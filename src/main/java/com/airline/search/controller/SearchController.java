package com.airline.search.controller;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.airline.search.Service.SearchService;
import com.airline.search.dto.FlightDetailsDto;
import com.airline.search.dto.SearchInputDto;
import com.airline.search.model.FlightBooking;
import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SearchController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SearchService searchService;

	//This function will give the flight details based on search
	
	@PostMapping("/getFlightdetails")
	public List<FlightDetailsDto> getFlightdetails(@RequestBody SearchInputDto searchInput) {

		List<FlightDetailsDto> resultFlights = searchService.getFlightDdetails(searchInput);
		
		return resultFlights;
	}
	
	@PostMapping("/getFlightDetails/sortByEconomyFare")
	public List<FlightDetailsDto> sortSearchFlightByEcoFare(@RequestBody SearchInputDto searchInput){
		
		List<FlightDetailsDto> resultFlights = searchService.getFlightDdetails(searchInput);
		List<FlightDetailsDto> sortedFlight = resultFlights.stream()
				.sorted((f1, f2) -> f1.getFare().geteFare() > f2.getFare().geteFare() ? 1 : -1)
				.collect(Collectors.toList());
		return sortedFlight;
		
	}
	
	@PostMapping("/getFlightDetails/sortByBussinessFare")
	public List<FlightDetailsDto> sortFlightDetailsByBussFare(@RequestBody SearchInputDto searchInput){
		
		List<FlightDetailsDto> resultFlights = searchService.getFlightDdetails(searchInput);
		List<FlightDetailsDto> sortedFlight = resultFlights.stream()
				.sorted((f1, f2) -> f1.getFare().getbFare() > f2.getFare().getbFare() ? 1 : -1)
				.collect(Collectors.toList());
		return sortedFlight;
		
	}
	
	@PostMapping("/getFlightDetails/sortByDepartureTimeAsc")
	public List<FlightDetailsDto> sortFlightDetailsByDeptTimeAsc(@RequestBody SearchInputDto searchInput){
			
			List<FlightDetailsDto> resultFlights = searchService.getFlightDdetails(searchInput);
			List<FlightDetailsDto> sortedFlight = resultFlights.stream()
					.sorted((f1, f2) -> f1.getDepartureDateTime().compareTo(f2.getDepartureDateTime()))
					.collect(Collectors.toList());
			return sortedFlight;
			
		}
	
	@PostMapping("/getFlightDetails/sortByDepartureTimeDsc")
	public List<FlightDetailsDto> sortFlightDetailsByDeptTimeDsc(@RequestBody SearchInputDto searchInput){
			
			List<FlightDetailsDto> resultFlights = searchService.getFlightDdetails(searchInput);
			List<FlightDetailsDto> sortedFlight = resultFlights.stream()
					.sorted((f1, f2) -> f2.getDepartureDateTime().compareTo(f1.getDepartureDateTime()))
					.collect(Collectors.toList());
			return sortedFlight;
			
		}
	
	@PostMapping("/getFlightDetails/sortByArrivalTimeAsc")
	public List<FlightDetailsDto> sortFlightDetailsByArrivTimeAsc(@RequestBody SearchInputDto searchInput){
			
			List<FlightDetailsDto> resultFlights = searchService.getFlightDdetails(searchInput);
			List<FlightDetailsDto> sortedFlight = resultFlights.stream()
					.sorted((f1, f2) -> f1.getArrivalDateTime().compareTo(f2.getArrivalDateTime()))
					.collect(Collectors.toList());
			return sortedFlight;
			
		}
	
	@PostMapping("/getFlightDetails/sortByArrivalTimeDsc")
	public List<FlightDetailsDto> sortFlightDetailsByArrivTimeDsc(@RequestBody SearchInputDto searchInput){
			
			List<FlightDetailsDto> resultFlights = searchService.getFlightDdetails(searchInput);
			List<FlightDetailsDto> sortedFlight = resultFlights.stream()
					.sorted((f1, f2) -> f2.getArrivalDateTime().compareTo(f1.getArrivalDateTime()))
					.collect(Collectors.toList());
			return sortedFlight;
			
		}
		
	
	//Connecting Flights
	
	@PostMapping("/getConnectingFlights")
	public List<List<FlightDetailsDto>> getSearchFlightConnecting(@RequestBody SearchInputDto searchInput){
		
		return searchService.getSearchFlightConnecting(searchInput);
	}
	
	
	
}
