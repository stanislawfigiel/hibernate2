package entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "bond_single_class")
public class BondSingleTable extends InheritInvestmentSingleTable {


	@Column(name = "value")
	BigDecimal value;

}
