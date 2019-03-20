package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank")
public class Bank implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id")
	private Long bank_id;

	@Column
	private String name;

	@Embedded
	@AttributeOverrides(
			{
					@AttributeOverride(name = "addressLine1", column = @Column(name = "bank_address_line1")),
					@AttributeOverride(name = "addressLine2", column = @Column(name = "bank_address_line2")),
					@AttributeOverride(name = "city", column = @Column(name = "bank_city")),
					@AttributeOverride(name = "zipCode", column = @Column(name = "bank_zip_code")),
					@AttributeOverride(name = "state", column = @Column(name = "bank_state")),

			}

	)
	Address address;

	@ElementCollection
	@CollectionTable(name = "contact", joinColumns = @JoinColumn(name = "BANK_ID"))
	@Column(name = "CONTACT")
	List<String> contacts = new ArrayList<>();


	@ElementCollection
	@CollectionTable(name = "contact_mapped", joinColumns = @JoinColumn(name = "BANK_ID"))
	@Column(name = "CONTACT")
	@MapKeyColumn(name = "POSITION_TYPE")
	Map<String, String> contactsMapped = new HashMap<>();
}

