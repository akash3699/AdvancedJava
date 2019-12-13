package pojos;

import javax.persistence.*;

@Entity
@Table(name = "location_dtls")
public class Location {

	private Integer id;
	private String   adrLine1, adrLine2 , zipCode, phone;
	private Vendor vendor;
	

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public Location(String adrLine1, String adrLine2, String zipCode, String phone) {
		super();
		this.adrLine1 = adrLine1;
		this.adrLine2 = adrLine2;
		this.zipCode = zipCode;
		this.phone = phone;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdrLine1() {
		return adrLine1;
	}

	public void setAdrLine1(String adrLine1) {
		this.adrLine1 = adrLine1;
	}

	public String getAdrLine2() {
		return adrLine2;
	}

	public void setAdrLine2(String adrLine2) {
		this.adrLine2 = adrLine2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", adrLine1=" + adrLine1 + ", adrLine2=" + adrLine2 + ", zipCode=" + zipCode
				+ ", phone=" + phone + "]";
	}
	@OneToOne
	@JoinColumn(name = "Vendor_Id")
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
}
