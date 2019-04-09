package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;

	@Column(name = "name")
	String name;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
	List<InheritInvestmentTablePerClass> investment = new ArrayList<>();

}
