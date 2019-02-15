package entities;

import java.util.ArrayList;
import java.util.Calendar;

public class Worker {
	private String name;
	private WorkrLevel level;
	private double baseSalary;
	private ArrayList<HourContract> contracts;
	private Departament departament;

	public Worker() {
		super();
		contracts = new ArrayList<HourContract>();// TODO Auto-generated constructor stub
	}

	public Worker(String name, WorkrLevel level, double baseSalary) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		contracts = new ArrayList<HourContract>();
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkrLevel getLevel() {
		return level;
	}

	public void setLevel(WorkrLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public ArrayList<HourContract> getContracts() {
		return contracts;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + "]";
	}

	public void addContract(HourContract contract) {

		this.contracts.add(contract);
		System.out.println("Done");
	}

	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
		System.out.println("Done");

	}

	public double income(int year, int month) {

		double sum = this.baseSalary;
		Calendar cal = Calendar.getInstance(); // Cria um calendario
		for (HourContract c : contracts) {
			cal.setTime(c.getDate()); // Seta no calendaro a data do contrato
			int c_year = cal.get(Calendar.YEAR); // pega o ano do contrato
			int c_month = 1 + cal.get(Calendar.MONTH);// pega o mes do contrato, mes comeca com 0 no Calendar

			if (year == c_year && month == c_month) { // verifica se o ano e mes sao iguais os pedidos
				sum += c.totalValue(); // se sim adiciona o valor do contrato
			}

		}

		return sum;

	}

}
