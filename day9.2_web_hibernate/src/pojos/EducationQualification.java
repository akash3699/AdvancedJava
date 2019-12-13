package pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EducationQualification {
	private String type;
	private int year;
	private double cgpa;
	public EducationQualification() {
		// TODO Auto-generated constructor stub
	}
	public EducationQualification(String type, int year, double cgpa) {
		super();
		this.type = type;
		this.year = year;
		this.cgpa = cgpa;
	}
	@Column(length=20,name="edu_type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	@Override
	public String toString() {
		return "EducationQualification [type=" + type + ", year=" + year + ", cgpa=" + cgpa + "]";
	}
	
	

}
