package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Worker {
	private String name;
	private WorkrLevel level;
	private double baseSalary;
	private ArrayList<HourContract> contracts;
	private Departament departament;

	
	
	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public Worker() {
		super();
		contracts= new ArrayList<HourContract>();// TODO Auto-generated constructor stub
	}

	public Worker(String name, WorkrLevel level, double baseSalary) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		contracts= new ArrayList<HourContract>();
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

	public void setContracts(ArrayList<HourContract> contracts) {
		this.contracts = contracts;
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
	
	public double income(int year, int month) throws ParseException {
		String dataInicio = "01/"+month+"/"+year;//se tirar por ex: 21:19:50 dará java.text.ParseException
		String dataFim = "31/"+month+"/"+year;
		SimpleDateFormat dataFormatadaInicio = new SimpleDateFormat("dd/MM/yyyy");  //HH:mm:ss
		Date recebeDataFormatadainicio = null;  
		Date recebeDataFormatadafim = null;  
		double soma = 0;
		try{  
			recebeDataFormatadainicio = dataFormatadaInicio.parse(dataInicio); 
			recebeDataFormatadafim = dataFormatadaInicio.parse(dataFim); 
		}catch(ParseException e) {  
		    e.printStackTrace();  //imprimi a stack trace
		}  
		
		
		for (HourContract hourContract : contracts) {
			//System.out.println(hourContract.getDate());
			//System.out.println(recebeDataFormatadafim);
			//System.out.println(hourContract.getDate().before(recebeDataFormatadafim));
			
			if (hourContract.getDate().before(recebeDataFormatadafim) && hourContract.getDate().after(recebeDataFormatadainicio)) {
				soma+= hourContract.totalValue();
				
				
			}
		}
			
		double income = this.baseSalary + soma;
		
	
		return income;
	}
	
}
