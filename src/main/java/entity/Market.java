package entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "market")
public class Market {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "market_name")
	private String MarketName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({
			@JoinColumn(name = "CURRENCY_NAME", referencedColumnName = "NAME"),
			@JoinColumn(name = "COUNTRY_NAME", referencedColumnName = "COUNTRY_NAME")
	})
	private Currency currency;


}
