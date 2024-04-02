package metier;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Car_Id")
    private Long carID;
    
    @Column(name = "car_Model")
    private String carModel;
    
    @Column(name = "car_Brand")
    private String carBrand;
    
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "family_group_group_id")
    private Family_Group familyGroup;

    public Car() {
        // Empty constructor required by JPA
    }

    public Car(Long carID,String carModel, String carBrand, double price,Family_Group fg) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.price = price;
        this.setFamilyGroup(fg);
    }
    public Car(String carModel, String carBrand, double price,Family_Group fg) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.price = price;
        this.setFamilyGroup(fg);
    }
    public Car(String carModel, String carBrand, double price) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.price = price;
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public Family_Group getFamilyGroup() {
        return familyGroup;
    }

    public void setFamilyGroup(Family_Group familyGroup) {
        this.familyGroup = familyGroup;
    }
}
