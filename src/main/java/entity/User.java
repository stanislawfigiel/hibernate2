package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

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

//	private Date birthDate;
	private String email;

	@Column(name="birth_date")
	private Date birthDate;


	@Formula("lower(datediff(curdate(), birth_date)/365)")
	private int age;
//	private Date lastUpdatedDate;
//	private String lastUpdatedBy;
//	private Date createdDate;
//	private String createdBy;

}
