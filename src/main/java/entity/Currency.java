package entity;

import entity.ids.CurrencyId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@IdClass(CurrencyId.class)
@Table(name = "currency")
public class Currency {

	@Id
	@Column
	private String name;
	
	@Id
	@Column(name = "country_name")
	private  String countryName;
	@Column
	private  String symbol;



}
