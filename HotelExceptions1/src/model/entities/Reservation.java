package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private int roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {

		long diff = checkOut.getTime() - checkIn.getTime();// converte o checkout e checkin do formato data para
															// milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// converte o resultado diff de milisegundos em dias

	}

	public String updateDate(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "Checkout dates for update must be future dates";
		}
		if (!checkout.after(checkin)) {
			return "Checkout date must be after check-in date";

		}

		this.checkIn = checkin;
		this.checkOut = checkout;
		return null;
	}

	@Override
	public String toString() {
		return "Reservation:  Room" + roomNumber + ", CheckIn: " + sdf.format(checkIn) + ", CheckOut: "
				+ sdf.format(checkOut) + " Duration: " + duration() + " night";

	}

}
