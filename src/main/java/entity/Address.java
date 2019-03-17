package entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

	@Column(name = "ADDRESS_LINE1")
	String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	String addressLine2;

	@Column(name = "CITY")
	String city;
	@Column(name = "STATE")
	String state;
	@Column(name = "ZIP_CODE")
	String zipCode;

}
