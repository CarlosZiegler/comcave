package application;

import java.text.ParseException;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.WorkrLevel;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Worker worker = new Worker();
		System.out.println("Enter Departament's name: ");
		Departament dp = new Departament(input.nextLine());
		worker.setDepartament(dp);
		
		
		System.out.println("Enter Worker data: ");
		System.out.println("Name: ");
		worker.setName(input.nextLine());
		System.out.println("Level: ");
		worker.setLevel(WorkrLevel.valueOf(input.nextLine()));
		
		System.out.println("Base Salary: ");
		worker.setBaseSalary(input.nextDouble());
		
		System.out.println("How many contracts to this worker?");
		int cont= input.nextInt();
		
		for (int i = 1; i < cont+1; i++) {
			HourContract contract = new HourContract();
			System.out.println("Enter contract #"+i+" data:");
			input.nextLine();
			System.out.println("Date (DD/MM/YYYY): ");
			contract.setDate(input.nextLine());
			System.out.println("Value per hour: ");
			contract.setValuePerHour(input.nextDouble());
			System.out.println("Duration (hours)");
			contract.setHours(input.nextInt());
			worker.addContract(contract);
		}
		System.out.println("Enter month and Year to calculate income (MM/YYYY): " );
		String datefinden = input.next();
		String[] date = datefinden.split("/");
		try {
			System.out.println("Name : "+ worker.getName());
			System.out.println("Departament : "+ worker.getDepartament().getName());
			System.out.println("Income for "+datefinden+": "+worker.income(Integer.parseInt(date[1]), Integer.parseInt(date[0])));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
