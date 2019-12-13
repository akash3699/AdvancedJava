package beans;

import java.text.SimpleDateFormat;

import dao.StudentDaoImpl;
import pojos.Address;
import pojos.AdharCard;
import pojos.EducationQualification;
import pojos.Student;

public class StudentBean {
	private StudentDaoImpl studentDao;
	// core student details
	private String name, email, courseNm, cardNum, cardCity, cardDate;
	// address details
	private String city, state, country, phoneNo;
	// edu qualification details
	private String type;
	private int year;
	private double gpa;

	private Student details;
	private SimpleDateFormat sdf;

	public StudentBean() {
		System.out.println("in stud bean ctor");
		studentDao = new StudentDaoImpl();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public Student getDetails() {
		return details;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCourseNm(String courseNm) {
		this.courseNm = courseNm;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public void setCardCity(String cardCity) {
		this.cardCity = cardCity;
	}

	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	// B.L method to store partial details of student
	public String addPartialDetails() throws Exception {
		details = new Student(name, email);
		// link adhar card dtls
		details.setCard(new AdharCard(cardNum, cardCity, sdf.parse(cardDate)));
		System.out.println(details + " " + details.getCard());
		return "details added";
	}

	// B.L method to link address details to student
	public String linkAddressDetails() {
		Address a = new Address(city, state, country, phoneNo);
		// link address
		details.addAddress(a);// sets up bi-dir association.
		System.out.println(details + " " + details.getCard());
		System.out.println("Address "+details.getAdr());
		return "addr details added";
	}

	// B.L method to link edu qualifications details to student
	public String addEduQuals() {
		EducationQualification e = new EducationQualification(type, year, gpa);
		details.getQualifications().add(e);
		System.out.println("Student "+details + " \n Adhar Card " + details.getCard());
		System.out.println("Address "+details.getAdr());
		System.out.println("Edu quals ");
		details.getQualifications().forEach(System.out::println);
		return "edu qualificatios added";
	}
	//B.L method to reister student
	public String registerStudent() {
		System.out.println("in reg student "+courseNm);
		return studentDao.admitNewStudent(courseNm, details);
	}

}
