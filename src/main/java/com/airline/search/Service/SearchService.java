package com.airline.search.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airline.search.dto.FlightDetailsDto;
import com.airline.search.dto.SearchInputDto;

@Service
public interface SearchService {

	public List<FlightDetailsDto> getFlightDdetails(SearchInputDto searchInput);
	
	public List<List<FlightDetailsDto>> getSearchFlightConnecting(SearchInputDto serchInput);
	
}
