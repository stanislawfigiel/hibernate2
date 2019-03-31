package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

    @Column(name="email")
	private String email;

	@Column(name="birth_date")
	private Date birthDate;


	@Formula("lower(datediff(curdate(), birth_date)/365)")
	private int age;

	@Embedded
	private Address address = new Address();


	@ElementCollection
	@CollectionTable(name = "address", joinColumns = @JoinColumn(name = "user_id"))
	@AttributeOverrides(
			{
					@AttributeOverride(name = "addressLine1", column = @Column(name = "user_address_line1")),
					@AttributeOverride(name = "addressLine2", column = @Column(name = "user_address_line2")),
					@AttributeOverride(name = "city", column = @Column(name = "user_city")),
					@AttributeOverride(name = "zipCode", column = @Column(name = "user_zip_code")),
					@AttributeOverride(name = "state", column = @Column(name = "user_state")),

			}

	)
	private List<Address> addresses = new ArrayList<>();


//	private Date lastUpdatedDate;
//	private String lastUpdatedBy;
//	private Date createdDate;
//	private String createdBy;

}
