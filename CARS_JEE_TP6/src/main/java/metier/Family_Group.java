package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Family_Group implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long Group_ID;
	private String Group_Name;
	
	@Temporal(TemporalType.DATE)
	private Date DateOfCreation;
	
	@OneToMany (mappedBy="familyGroup")
	private List<Car> Cars;
	
	public Family_Group() {
		super();
	}

	public Family_Group(Long group_ID, String group_Name, Date dateOfCreation) {
		super();
		Group_ID = group_ID;
		Group_Name = group_Name;
		DateOfCreation = dateOfCreation;
	}
	public Family_Group( String group_Name, Date dateOfCreation) {
		super();
		Group_Name = group_Name;
		DateOfCreation = dateOfCreation;
	}

	public Long getGroup_ID() {
		return Group_ID;
	}

	public void setGroup_ID(Long group_ID) {
		Group_ID = group_ID;
	}

	public String getGroup_Name() {
		return Group_Name;
	}

	public void setGroup_Name(String group_Name) {
		Group_Name = group_Name;
	}

	public Date getDateOfCreation() {
		return DateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		DateOfCreation = dateOfCreation;
	}

	public List<Car> getCars() {
		return Cars;
	}

	public void setCars(List<Car> cars) {
		Cars = cars;
	}


	
	
	
}
