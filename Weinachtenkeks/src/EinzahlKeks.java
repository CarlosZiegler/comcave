import java.util.ArrayList;

public class EinzahlKeks {
	private static int einzahlKeks;
	private static ArrayList<Boolean> full;
	private static boolean is100;
	
	
	public static boolean isIs100() {
		if (getEinzahlKeks()>100) {
			is100=true;
		}
		
		return is100;
	}

	public static void setIs100(boolean is100) {
		EinzahlKeks.is100 = is100;
	}

	public static int getEinzahlKeks() {
		return einzahlKeks;
	}

	public static void setEinzahlKeks(int einzahlKeks) {
		EinzahlKeks.einzahlKeks = einzahlKeks;
	}

	public static void saldoKeks(int keks) {
		einzahlKeks += keks;
	}
	
	public static void setAllesnichtFull() {
		full.set(0, false);
		full.set(1, false);
		full.set(2, false);
		full.set(3, false);

	}
	
	public static void setKinderFull(int i) {
		full.set(i, true);

	}

	public static ArrayList<Boolean> getListFull() {
		return full;
	}
	
	public static void setFull(ArrayList<Boolean> full) {
		EinzahlKeks.full = full;
		EinzahlKeks.full.add(0, false);
		EinzahlKeks.full.add(1, false);
		EinzahlKeks.full.add(2, false);
		EinzahlKeks.full.add(3, false);
	}

	



}
