package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("checkIn Date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("checkOut Date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("checIn Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("checkOut Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		
		catch (ParseException e) {
			 System.out.println("Invalid date Format!!");
		}
		
		catch (DomainException e) {
			System.out.println("Error in reservation "+ e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Unexpect Error!");
		}
		
		finally {
			sc.close();
			System.out.println("Program Finish!!");
			}
		
	}
		

}

