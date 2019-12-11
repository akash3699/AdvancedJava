package pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity 
@Table(name = "dac_users")
public class Vendors {
	private Integer id;
	private String name, email, password;
	private Double reg_amount;
	private Date reg_date;
	private UserRole role;
	public Vendors() {
		// TODO Auto-generated constructor stub
	}
	
	public Vendors(String name, String email, String password, Double reg_amount, Date reg_date, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.reg_amount = reg_amount;
		this.reg_date = reg_date;
		this.role = role;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
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

	public Double getReg_amount() {
		return reg_amount;
	}

	public void setReg_amount(Double reg_amount) {
		this.reg_amount = reg_amount;
	}
	@Temporal(TemporalType.DATE) // column type =date
	@Column(name = "reg_date")
	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Enumerated(EnumType.STRING) // enum constant name will be added in DB
	@Column(length = 20)
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Vendors [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", reg_amount="
				+ reg_amount + ", reg_date=" + reg_date + ", role=" + role + "]";
	}
	
	

}
