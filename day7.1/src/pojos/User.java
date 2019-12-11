package pojos;

import java.util.Date;
import javax.persistence.*;//JPA

@Entity // mandatory
@Table(name = "dac_users") // optional BUT reco
public class User {
	// Unique ID property MUST be Serializable --MANDATORY
	private Integer id;
	private String name, email, password, confirmPassword;
	private UserRole role;
	private double regAmount;
	private Date regDate;
	private byte[] image;

	// def constr --Mandatory
	public User() {
		System.out.println("in user constr");
	}

	public User(String name, String email, String password, String confirmPassword, UserRole role, double regAmount,
			Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	

	public User(String name, double regAmount, Date regDate) {
		super();
		this.name = name;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	// supply ALL getters & setters --MANDATORY
	@Id // mandatory --properry level annotation -- id must be supplied by user --PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment constraint
	@Column(name = "user_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient // hib will not create any column for this property
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Enumerated(EnumType.STRING) // enum constant name will be added in DB
	@Column(length = 20)
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Column(name = "reg_amt")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE) // column type =date
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Lob // column = blob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + "]";
	}

}
