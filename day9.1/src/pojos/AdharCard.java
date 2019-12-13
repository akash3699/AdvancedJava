package pojos;

import java.util.Date;
import javax.persistence.*;

@Embeddable //value type --whose details are to be embedded within owning entity
public class AdharCard {
	private String cardNumber, city;
	private Date createdOn;
	
	public AdharCard() {
		// TODO Auto-generated constructor stub
	}
	public AdharCard(String cardNumber, String city, Date createdOn) {
		super();
		this.cardNumber = cardNumber;
		this.city = city;
		this.createdOn = createdOn;
	}
	@Column(name="adhar_num",length=20,unique=true)
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@Column(length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="created_on")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "AdharCard [cardNumber=" + cardNumber + ", city=" + city + ", createdOn=" + createdOn + "]";
	}
	
	
}
