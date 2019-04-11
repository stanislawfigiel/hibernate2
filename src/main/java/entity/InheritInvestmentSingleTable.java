package entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "investment_type")
@Table(name = "investment")
public abstract class InheritInvestmentSingleTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "investment_id")
	private Long id;




	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "portfolio_id")
	private PortfolioSingleTable portfolio;


	@Column(name = "name")
	protected String name;

	@Column(name = "issuer")
	protected String issuer;

	//	@Column(name = "purchaseDate")
	//    protected Date purchaseDate;

}
