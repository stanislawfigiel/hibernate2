package entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity
@DiscriminatorValue("BOND")
public class BondSingleTable extends InheritInvestmentSingleTable {


	@Column(name = "value")
	BigDecimal value;

}
