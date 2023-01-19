
package com.airline.search.model;

import java.time.LocalDateTime;

public class Booking {

	private int bookingId;

	private String pnrNo;

	private LocalDateTime bookingDate;

	private String seatClass;

	private FlightBooking flightBooking;

	public Booking(int bookingId, String pnrNo, LocalDateTime bookingDate, String seatClass,
			FlightBooking flightBooking) {
		super();
		this.bookingId = bookingId;
		this.pnrNo = pnrNo;
		this.bookingDate = bookingDate;
		this.seatClass = seatClass;
		this.flightBooking = flightBooking;
	}



	public int getBookingId() {
		return bookingId;
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public FlightBooking getFlightBooking() {
		return flightBooking;
	}

	public void setFlightBooking(FlightBooking flightBooking) {
		this.flightBooking = flightBooking;
	}
}
