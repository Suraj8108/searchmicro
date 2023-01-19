package com.airline.search.model;

import java.time.OffsetDateTime;
import java.util.Set;

public class FlightBooking {

	private int id;

	private OffsetDateTime departureDateTime;

	private OffsetDateTime arrivalDateTime;

	private long totalTime;

	private Flight flight;

	private Set<Booking> booking;
	private Fare fare;

	///////

	public FlightBooking(OffsetDateTime departureDateTime, OffsetDateTime arrivalDateTime, long totalTime,
			Flight flight, Set<Booking> booking, Fare fare) {
		super();
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.totalTime = totalTime;
		this.flight = flight;
		this.booking = booking;
		this.fare = fare;
	}

	public int getId() {
		return id;
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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public FlightBooking() {
		super();
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

}
