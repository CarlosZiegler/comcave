package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HourContract {

	private Date date;
	private double valuePerHour;
	private int hours;

	public HourContract(String date, double valuePerHour, int hours) {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.date =data.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public HourContract() {
		// TODO Auto-generated constructor stub
	}

	public Date getDate() {
		return date;
	}

	public void setDate(String data) {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");  //HH:mm:ss
		Date recebeDataFormatada = null;  
		try{  
			recebeDataFormatada = dataFormatada.parse(data);  
		}catch(ParseException e) {  
		    e.printStackTrace();  //imprimi a stack trace
		}  
		this.date = recebeDataFormatada;
	}

	public double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double totalValue() {
		double totalContract = 0;
		totalContract = getValuePerHour() * getHours();

		return totalContract;
	}

}
