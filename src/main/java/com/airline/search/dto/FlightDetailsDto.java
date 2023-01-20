package com.airline.search.dto;

import java.time.OffsetDateTime;
import java.util.Set;

import com.airline.search.model.Fare;
import com.airline.search.model.Route;

public class FlightDetailsDto {

	private int flightBookingId;
	
	private int flightNo;
	
	private Set<String> flightWeekDays;

	private Fare fare;
	
	private OffsetDateTime departureDateTime;
	
	private OffsetDateTime arrivalDateTime;
	
	private long totalTime;
	
	private Route route;
	
	private int busSeatAvailable;
	
	private int ecoSeatAvailable;

	public FlightDetailsDto() {
		super();
	}

	public FlightDetailsDto(int flightBookingId, int flightNo, Set<String> flightWeekDays, Fare fare,
			OffsetDateTime departureDateTime, OffsetDateTime arrivalDateTime, long totalTime, Route route,
			int busSeatAvailable, int ecoSeatAvailable) {
		super();
		this.flightBookingId = flightBookingId;
		this.flightNo = flightNo;
		this.flightWeekDays = flightWeekDays;
		this.fare = fare;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.totalTime = totalTime;
		this.route = route;
		this.busSeatAvailable = busSeatAvailable;
		this.ecoSeatAvailable = ecoSeatAvailable;
	}

	public int getFlightBookingId() {
		return flightBookingId;
	}

	public void setFlightBookingId(int flightBookingId) {
		this.flightBookingId = flightBookingId;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public Set<String> getFlightWeekDays() {
		return flightWeekDays;
	}

	public void setFlightWeekDays(Set<String> flightWeekDays) {
		this.flightWeekDays = flightWeekDays;
	}

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public OffsetDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(OffsetDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public OffsetDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(OffsetDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public int getBusSeatAvailable() {
		return busSeatAvailable;
	}

	public void setBusSeatAvailable(int busSeatAvailable) {
		this.busSeatAvailable = busSeatAvailable;
	}

	public int getEcoSeatAvailable() {
		return ecoSeatAvailable;
	}

	public void setEcoSeatAvailable(int ecoSeatAvailable) {
		this.ecoSeatAvailable = ecoSeatAvailable;
	}
	
	

}
