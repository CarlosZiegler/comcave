import javax.swing.border.EtchedBorder;

public class AutoConfigMitKonstruktoren {

	private EAusstattung ausstattung;
	private EMotor motor;// PURETEC_168 nur für SElection, PURETEC_E nür mit ECOTEC, STANDART MOTOR ist
							// HDI_70
	private EFarbe farbe;// Standart farbe WEISS
	private ETyp typ; // Standart Kompakt
	private boolean automatik; // Bei Geleandewagen verboten
	private boolean panoramadach; // nur bei Exclusive oder Attraktion

	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	private AutoConfigMitKonstruktoren(EAusstattung ausstattung) {
		super();
		this.ausstattung = ausstattung;
	}

	public static class AutoBuilder {

		private AutoConfigMitKonstruktoren auto;

		public AutoBuilder(EAusstattung ausstattung) {

			auto = new AutoConfigMitKonstruktoren(ausstattung);
			auto.motor = EMotor.HDI_70;
			auto.farbe = EFarbe.WEISS;
			auto.typ = ETyp.KOMPAKT;
			auto.automatik = false;
			auto.panoramadach = false;

		}

		public AutoBuilder mitMotor(EMotor motor) {

			auto.motor = motor;
			return this;
		}

		public AutoBuilder inFarbe(EFarbe farbe) {

			auto.farbe = farbe;
			return this;
		}

		public AutoBuilder vomTyp(ETyp typ) {

			auto.typ = typ;
			return this;
		}

		public AutoBuilder mitAutomatik() {

			auto.automatik = true;
			return this;
		}

		public AutoBuilder mitPanoramadach() {

			auto.panoramadach = true;
			return this;
		}

		public AutoConfigMitKonstruktoren konstruire() {

			if (auto.panoramadach) {
				if (!auto.ausstattung.equals(EAusstattung.EXCLUSIVE)
						|| !auto.ausstattung.equals(EAusstattung.SELECTION)) {

					throw new IllegalStateException("Fehler: Panorami");

				}
			}
			if (auto.motor.equals(EMotor.PURETEC_168) && !auto.ausstattung.equals(EAusstattung.SELECTION)) {

				throw new IllegalStateException("Fehler: Motor");

			}

			if (auto.motor.equals(EMotor.PURETEC_E) && !auto.ausstattung.equals(EAusstattung.ECOTEC)) {

				throw new IllegalStateException("Fehler: Motor ECO");

			}
			if (auto.automatik && auto.typ.equals(ETyp.GELEANDEWAGEN)) {
				throw new IllegalStateException("Fehler: Automatik");

				
			}

			return auto;
		}

	}

}
