package com.airline.search.dto;

import java.time.OffsetDateTime;
import java.util.Date;

public class SearchInputDto {

	private String departureAirport;
	
	private String arrivalAirport;
	
	//economy or business
	private String seatClass;
	
	private int passenges;
	
	private Date departureDate;
	
	private Date returnDate;

	public SearchInputDto(String departureAirport, String arrivalAirport, String seatClass, int passenges,
			Date departureDate, Date returnDate) {
		super();
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.seatClass = seatClass;
		this.passenges = passenges;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
	}

	public SearchInputDto() {
		super();
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public int getPassenges() {
		return passenges;
	}

	public void setPassenges(int passenges) {
		this.passenges = passenges;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "SearchInputDto [departureAirport=" + departureAirport + ", arrivalAirport=" + arrivalAirport
				+ ", seatClass=" + seatClass + ", passenges=" + passenges + ", departureDate=" + departureDate
				+ ", returnDate=" + returnDate + "]";
	}
	
	
}
