package entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "bond_per_class")
public class BondTablePerClass extends InheritInvestmentTablePerClass {


	@Column(name = "value")
	BigDecimal value;

}
