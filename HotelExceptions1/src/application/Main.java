package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.println("Checkin: (dd/MM/yyyy) ");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Checkout: (dd/MM/yyyy) ");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation : " + reservation);
			System.out.println("Enter data to update Reservation: ");
			System.out.println("Checkin: (dd/MM/yyyy) ");
			checkin = sdf.parse(sc.next());
			System.out.println("Checkout: (dd/MM/yyyy) ");
			checkout = sdf.parse(sc.next());

			reservation.updateDate(checkin, checkout);

			System.out.println("Reservation : " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date Format !");
		} catch (DomainException e) {
			System.out.println("Error in Reservation : " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("unexpected error" + e.getMessage());
		}
		sc.close();

	}

}
