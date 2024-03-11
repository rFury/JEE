package Entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Cars implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Car_Id")
    private Long carID;
    
    @Column(name = "car_Model")
    private String carModel;
    
    @Column(name = "car_Brand")
    private String carBrand;
    
    private double price;

    public Cars() {
        // Empty constructor required by JPA
    }

    public Cars(String carModel, String carBrand, double price) {
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
}
