package demoHiber;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="student_Address")
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id will be auto Increment 
	@Column(name="address_id") // column name should be address_id instead of addressId
	private int addressId;
	
	@Column(length= 50, name= "STREET")
	private String street;
	
	@Column(length = 100, name= "CITY")
	private String city;
	private boolean isOpen;
	
	@Transient        // THIS COLUMN WILL NOT CREATE IN TABLE
	private double x;
	
	@Temporal(TemporalType.DATE)  // formate should be date only for this column
	private Date addedDate;
	
	@Lob 					// Image size can be large
	private byte[] image;
	
	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressEntity(int addressId, String street, String city, boolean isOpen, double x, Date addedDate,
			byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
