package pojos;

import javax.persistence.*;

@Embeddable
public class Service {
	private String type;
	private int yrsOfExperience;
	private int noOfCustomersServed;
	public Service() {
		// TODO Auto-generated constructor stub
	}
	
	public Service(String type, int yrsOfExperience, int noOfCustomersServed) {
		super();
		this.type = type;
		this.yrsOfExperience = yrsOfExperience;
		this.noOfCustomersServed = noOfCustomersServed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYrsOfExperience() {
		return yrsOfExperience;
	}

	public void setYrsOfExperience(int yrsOfExperience) {
		this.yrsOfExperience = yrsOfExperience;
	}

	public int getNoOfCustomersServed() {
		return noOfCustomersServed;
	}

	public void setNoOfCustomersServed(int noOfCustomersServed) {
		this.noOfCustomersServed = noOfCustomersServed;
	}
	
}
