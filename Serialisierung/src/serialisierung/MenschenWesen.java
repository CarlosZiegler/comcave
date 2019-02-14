package serialisierung;

import java.io.Serializable;

public class MenschenWesen implements Serializable
{
	private int alter;
	private String name;
	private int lebensEnergie;
	
	public MenschenWesen(String name, int lebensEnergie) {
		super();
		this.alter = 25;
		this.name = name;
		this.lebensEnergie = lebensEnergie;
	}
	
	
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLebensEnergie() {
		return lebensEnergie;
	}
	public void setLebensEnergie(int lebensEnergie) {
		this.lebensEnergie = lebensEnergie;
	}
	
	
	
	
}
