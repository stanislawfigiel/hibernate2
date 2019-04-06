package entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class SuperInvestment {

	@Column(name = "name")
	protected String name;

	@Column(name = "issuer")
	protected String issuer;

//	@Column(name = "purchaseDate")
//    protected Date purchaseDate;

}
