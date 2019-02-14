
public class Tuersteher {
	public boolean checkEntry(Person p, int tagesStunde) {
		boolean status = false;
		if (tagesStunde < 22) {
			if (p.getGeschlecht() == 'M' && p.getAlter() < 14) {
				status = false;
			} else if (p.getGeschlecht() == 'M' && p.getAlter() >= 14) {
				status = true;
			} else if (p.getGeschlecht() == 'F' && p.getAlter() < 12) {
				status = false;
			} else if (p.getGeschlecht() == 'F' && p.getAlter() > 12) {
				status = true;
			}
		}
		if (tagesStunde >= 22) {
			if (p.getGeschlecht() == 'M' && (p.getAlter() >= 16 && p.getAlter()<=18)) {
				status = false;
			} else if (p.getGeschlecht() == 'M' && (p.getAlter() < 16 || p.getAlter()>18)) {
				status = true;
			} else if (p.getGeschlecht() == 'F' && (p.getAlter() >= 14 && p.getAlter()<=20)) {
				status = false;
			} else if (p.getGeschlecht() == 'F' && (p.getAlter() < 14 || p.getAlter() >20)) {
				status = true;
			}

		}

		return status;

	}

}
