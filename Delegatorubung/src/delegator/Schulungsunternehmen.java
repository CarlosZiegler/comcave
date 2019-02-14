package delegator;

import java.util.ArrayList;

public class Schulungsunternehmen {
	ArrayList<Seminarteilnehmer> teilnehmerList;
	ArrayList<Kurse> seminarList;
	ArrayList<Dozenten> dozentenList;
	String name;

	public ArrayList<Seminarteilnehmer> getTeilnehmerList() {
		return teilnehmerList;
	}

	public void setTeilnehmerList(ArrayList<Seminarteilnehmer> teilnehmerList, Seminarteilnehmer teilnehmer) {
		teilnehmerList.add(teilnehmer);
		System.out.println("Teilnehmer added successfully");
	}
	
	public void setTeilnehmerList(ArrayList<Seminarteilnehmer> teilnehmerList) {
		this.teilnehmerList = teilnehmerList;
	}

	public ArrayList<Kurse> getSeminarList() {
		return seminarList;
	}

	public void setSeminarList(ArrayList<Kurse> seminarList) {
		this.seminarList = seminarList;
		}

	public void setSeminarList(ArrayList<Kurse> seminarList, Kurse kurs) {
		seminarList.add(kurs);
		System.out.println("Kurs added successfully");
	}

	public ArrayList<Dozenten> getDozentenList() {
		return dozentenList;
	}

	public void setDozentenList(ArrayList<Dozenten> dozentenList, Dozenten dozent) {
		dozentenList.add(dozent);
		System.out.println("Dozent added successfully");
	}
	public void setDozentenList(ArrayList<Dozenten> dozentenList) {
		this.dozentenList= dozentenList;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
