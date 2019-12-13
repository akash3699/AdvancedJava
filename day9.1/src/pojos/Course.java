package pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
	private Integer courseId;
	private String name;
	private Date strt, end;
	private int capacity;
	private double fees;
	// one-to-many bi dir associtation between entities
	private List<Student> students = new ArrayList<>();// reco.
	// def constr

	public Course() {
		System.out.println("in course ctor");
	}

	public Course(String name, Date strt, Date end, int capacity, double fees) {
		super();
		this.name = name;
		this.strt = strt;
		this.end = end;
		this.capacity = capacity;
		this.fees = fees;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(length = 20, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "strt_date")
	public Date getStrt() {
		return strt;
	}

	public void setStrt(Date strt) {
		this.strt = strt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@OneToMany(mappedBy = "selectedCourse", cascade = CascadeType.ALL,orphanRemoval=true/*,fetch=FetchType.EAGER*/)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", strt=" + strt + ", end=" + end + ", capacity="
				+ capacity + ", fees=" + fees + "]";
	}

	// convenience method -- helper methods --adding / removing student to/from a
	// course
	// Optional BUT recommended.
	public void addStudent(Student s) {
		// add student info in course
		this.students.add(s);
		// add course info to student
		s.setSelectedCourse(this);
	}

	public void removeStudent(Student s) {
		students.remove(s); // removing student dtls from Course
		s.setSelectedCourse(null);//removing course dtls from student
	}

}
