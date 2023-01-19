package com.airline.search.model;

public class airline {

	private long id;
	private String flightId;

	private String flightdepartureDate;

	private String flightArrivalDate;

	private String flightArrivalTime;

	private String flightDepartureTime;

	private String totalTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightdepartureDate() {
		return flightdepartureDate;
	}

	public void setFlightdepartureDate(String flightdepartureDate) {
		this.flightdepartureDate = flightdepartureDate;
	}

	public String getFlightArrivalDate() {
		return flightArrivalDate;
	}

	public void setFlightArrivalDate(String flightArrivalDate) {
		this.flightArrivalDate = flightArrivalDate;
	}

	public String getFlightArrivalTime() {
		return flightArrivalTime;
	}

	public void setFlightArrivalTime(String flightArrivalTime) {
		this.flightArrivalTime = flightArrivalTime;
	}

	public String getFlightDepartureTime() {
		return flightDepartureTime;
	}

	public void setFlightDepartureTime(String flightDepartureTime) {
		this.flightDepartureTime = flightDepartureTime;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

}
