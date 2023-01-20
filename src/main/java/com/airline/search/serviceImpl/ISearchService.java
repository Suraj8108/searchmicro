package com.airline.search.serviceImpl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.airline.search.Service.SearchService;
import com.airline.search.dto.FlightDetailsDto;
import com.airline.search.dto.SearchInputDto;

@Service
public class ISearchService implements SearchService{

	@Autowired
	private RestTemplate restTemplate;
	
	String bookUrl = "http://ec2-3-110-171-177.ap-south-1.compute.amazonaws.com:9900";
//	String bookUrl = "http://localhost:9969";
	@Override
	public List<FlightDetailsDto> getFlightDdetails(SearchInputDto searchInput) {
		// TODO Auto-generated method stub
		
		List<FlightDetailsDto> bookableFlights = restTemplate
				.exchange(bookUrl + "/flightBooking/getSearchFlights", HttpMethod.GET, null, 
						new ParameterizedTypeReference<List<FlightDetailsDto>>() {
						}).getBody();
		
		
		List<FlightDetailsDto> resultFlights = new ArrayList<>();
		
		String departureAirport = searchInput.getDepartureAirport().toLowerCase();
		String arrivalAirport = searchInput.getArrivalAirport().toLowerCase();
		LocalDate searchDate = LocalDate.ofInstant(searchInput.getDepartureDate().toInstant(), ZoneId.systemDefault());
		
//		System.out.println(bookableFlights.get(0).getDepartureDateTime());
		for(FlightDetailsDto flights : bookableFlights) {
			
			OffsetDateTime flightDepartureTime = flights.getDepartureDateTime();
			if(flights.getRoute().getDepartureAirport().toLowerCase().equals(departureAirport) 
					&& 
				flights.getRoute().getArrivalAirport().toLowerCase().equals(arrivalAirport) 
				&&
				flightDepartureTime.toLocalDate().compareTo(searchDate) == 0
				)
				{
					int ecoSeats = flights.getEcoSeatAvailable();
					int busSeats = flights.getBusSeatAvailable();
					int passengers = searchInput.getPassenges();
					
					if(ecoSeats - passengers > 0) {
						resultFlights.add(flights);
					}
					else if(busSeats - passengers > 0){
						resultFlights.add(flights);
					}
					else if(ecoSeats + busSeats - passengers > 0) {
						resultFlights.add(flights);
					}
					
				}
		}
		
		
		
//		System.out.println(OffsetDateTime.now());
//		System.out.println(userDate.compareTo(Date.from(OffsetDateTime.now().toInstant())));
		return resultFlights;
	}

	@Override
	public List<List<FlightDetailsDto>> getSearchFlightConnecting(SearchInputDto searchInput) {
		// TODO Auto-generated method stub
		
		String departureAirport = searchInput.getDepartureAirport();
		String arrivalAirport = searchInput.getArrivalAirport();
		
		List<FlightDetailsDto> resultFlights = new ArrayList<>();
		
		//Get all Flights that have departure Airport as user departure
		Set<String> departureArrivalFlights = restTemplate
				.exchange(bookUrl + "/flightBooking/getSearchFlightsByDeparture/" + departureAirport,
						HttpMethod.GET, null, 
						new ParameterizedTypeReference<Set<String>>() {
						}).getBody();
		//Get all Flights that have arrival Airport as user arrival
		Set<String> arrivalDepartureFlights = restTemplate
				.exchange(bookUrl + "/flightBooking/getSearchFlightsByArrival/" + arrivalAirport,
						HttpMethod.GET, null, 
						new ParameterizedTypeReference<Set<String>>() {
						}).getBody();
		
		//Find out commonstop between those can be have validation for distance
		Set<String> commonStop = new HashSet<>(departureArrivalFlights);
		
		commonStop.retainAll(arrivalDepartureFlights);
		
		
		
		
		List<FlightDetailsDto> departureFlights = new ArrayList<>();
		List<FlightDetailsDto> arrivalFlights = new ArrayList<>();
		
		for(String common : commonStop) {
			
			SearchInputDto search = new SearchInputDto(
					departureAirport, common,
					searchInput.getSeatClass(), searchInput.getPassenges(), searchInput.getDepartureDate(),
					searchInput.getReturnDate());
			System.out.println(search);
			//Find all flights that have departure as user departure and arrival as common stop
			departureFlights.addAll(this.getFlightDdetails(search));
			
			search.setDepartureAirport(common);
			search.setArrivalAirport(arrivalAirport);
			
//			System.out.println(search);
			//Find all flights that have arrival as user arrival and departure as common stop
			arrivalFlights.addAll(this.getFlightDdetails(search));
			
		}
		
		List<List<FlightDetailsDto>> connectFlights = new ArrayList<>();
		
		//From the all flights get the common arrival and departure for connecting and validation for the 
		//long hour not to wait
		System.out.println(departureFlights);
		System.out.println(arrivalFlights);
		for(FlightDetailsDto departure : departureFlights) {
			
			for(FlightDetailsDto arrival : arrivalFlights) {
				String arriv1 = departure.getRoute().getArrivalAirport().toLowerCase();
				String dep2 = arrival.getRoute().getDepartureAirport().toLowerCase();
				
				OffsetDateTime arriv1Time = departure.getArrivalDateTime();
				OffsetDateTime dept2Time = arrival.getDepartureDateTime();
				//Check Common Stations
				if(arriv1.equals(dep2)) {
					
					if(arriv1Time.compareTo(dept2Time) < 0) {
						long durationMins = Duration.between(arriv1Time, dept2Time).toMinutes();
						if(durationMins > 15 && durationMins < 180 ) {
							List<FlightDetailsDto> fly = new ArrayList<>();
							fly.add(departure);
							fly.add(arrival);
							
							connectFlights.add(fly);
						}
						
					}
					
				}
				
			}
		}
		
		return connectFlights;
	}

}
