package pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {
	private Integer studentId;
	private String name, email;
	// many-to-one bi dir asso between entities
	private Course selectedCourse;
	//one-one bi dir association between student 1----1 address , between entities
	private Address adr;
	//one-to-one uni dir association between enity n value type
	private AdharCard card;
	//one -to-many uni asso between entity n value type
	private List<EducationQualification> qualifications=new ArrayList<>();
	
	public Student() {
		System.out.println("in student ctor");
	}
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stud_id")
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	@Column(length=30,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=30,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ManyToOne
	@JoinColumn(name="c_id")
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	//inverse side
	@OneToOne(mappedBy="stud",cascade=CascadeType.ALL)
	public Address getAdr() {
		return adr;
	}
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + "]";
	}
	//add convenience (helper) method to add/remove address
	public void addAddress(Address a)
	{
		this.adr=a;
		a.setStud(this);
	}
	public void removeAddress(Address a)
	{
		this.adr=null;
		a.setStud(null);
	}
	@Embedded //optional ---to tell hibernate that card dtls ate embedded.
	public AdharCard getCard() {
		return card;
	}
	public void setCard(AdharCard card) {
		this.card = card;
	}
	@ElementCollection //mandatory
	@CollectionTable(name="edu_quals",joinColumns=@JoinColumn(name="s_id"))
	public List<EducationQualification> getQualifications() {
		return qualifications;
	}
	public void setQualifications(List<EducationQualification> qualifications) {
		this.qualifications = qualifications;
	}
}
