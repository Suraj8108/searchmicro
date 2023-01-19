package com.airline.search.model;

import java.util.Set;

import org.springframework.util.RouteMatcher.Route;

public class Flight {

	private int flightId;
	private int flightNo;

	private int businessFare;
	private int economyFare;

	private Set<String> flightWeekDays;

	private Route route;

	private Set<FlightBooking> flightBooking;

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNo=" + flightNo + ", flightWeekDays=" + flightWeekDays
				+ ", route=" + route + ", business fare = " + businessFare + ", economy fare" + economyFare + "]";
	}

	public Flight(int flightNo, int businessFare, int economyFare, Set<String> flightWeekDays, Route route,
			Set<FlightBooking> flightBooking) {
		super();

		this.flightNo = flightNo;
		this.businessFare = businessFare;
		this.economyFare = economyFare;
		this.flightWeekDays = flightWeekDays;
		this.route = route;
		this.flightBooking = flightBooking;
	}

	public Flight() {
		super();
	}

	public int getFlightId() {
		return flightId;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public int getBusinessFare() {
		return businessFare;
	}

	public void setBusinessFare(int businessFare) {
		this.businessFare = businessFare;
	}

	public int getEconomyFare() {
		return economyFare;
	}

	public void setEconomyFare(int economyFare) {
		this.economyFare = economyFare;
	}

	public Set<String> getFlightWeekDays() {
		return flightWeekDays;
	}

	public void setFlightWeekDays(Set<String> flightWeekDays) {
		this.flightWeekDays = flightWeekDays;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Set<FlightBooking> getFlightBooking() {
		return flightBooking;
	}

	public void setFlightBooking(Set<FlightBooking> flightBooking) {
		this.flightBooking = flightBooking;
	}

}
