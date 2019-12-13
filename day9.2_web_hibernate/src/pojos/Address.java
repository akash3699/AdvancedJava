package pojos;
import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
	private Integer id;
	private String city, state, country, phoneNo;
	// one to one
	private Student stud;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String state, String country, String phoneNo) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=20)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Column(length=20)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Column(length=10,unique=true)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	//owning side --FK col appears here.
	@OneToOne
	@JoinColumn(name="s_id")
	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + ", phoneNo="
				+ phoneNo + "]";
	}

}
