package application;

import java.util.Scanner;

import model.domainExceptions.DomainExceptions;
import model.entities.Account;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Account number: ");
		int accountnumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Holder: ");
		String holder=sc.nextLine();
		System.out.println("Deposit: ");
		double deposit = sc.nextDouble();
		sc.nextLine();
		Account account = new Account(accountnumber, holder, deposit,150.0);
		
		System.out.println("Withdraw: ");
		double withdraw = sc.nextDouble();
		try {
			account.witchdraw(withdraw);
			System.out.println("Done!");
		} catch (DomainExceptions e) {
			e.getStackTrace();
			System.out.println("Error : "+e.getMessage());;
		}catch (Exception e) {
			System.out.println("Error : "+e.getMessage());;
		}
		finally {
			System.out.println(account);
		}
		try {
			
		} catch (Exception e) {
			e.getStackTrace();// TODO: handle exception
		}
	}

}
