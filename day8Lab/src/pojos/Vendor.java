package pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "vendor")
public class Vendor {
	private Integer vendorId;
	private List<BankAccount> bankAccounts = new ArrayList<>();
	private String name, email, password;
	private Double reg_amount;
	private Date reg_date;
	private UserRole role;
	public Vendor() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 * @param email
	 * @param reg_amount
	 */
	public Vendor(String name, String email, Double reg_amount) {
		super();
		this.name = name;
		this.email = email;
		this.reg_amount = reg_amount;
	}

	public Vendor(String name, String email, String password, Double reg_amount, Date reg_date, UserRole role) {
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
	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer id) {
		this.vendorId = id;
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

	@OneToMany(mappedBy = "owner",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", reg_amount=" + reg_amount + ", reg_date=" + reg_date + ", role=" + role + "]";
	}

	public void addAcoount(BankAccount s) {
		
		this.bankAccounts.add(s);
		s.setOwner(this);
	}

	public void removeAcoount(BankAccount s) {
		this.bankAccounts.remove(s);
		s.setOwner(null);
	}
	
	

}