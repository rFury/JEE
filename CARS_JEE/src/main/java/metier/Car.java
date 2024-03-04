package metier;
import java.io.Serializable;
public class Car implements Serializable{
private Long CarID;
private String CarModel;
private String CarBrand;
private double Price;

public Car() {
	super();
}
public Car(Long carID, String carModel, String carBrand, double price) {
	super();
	CarID = carID;
	CarModel = carModel;
	CarBrand = carBrand;
	Price = price;
}
public Long getCarID() {
	return CarID;
}
public void setCarID(Long carID) {
	CarID = carID;
}
public String getCarModel() {
	return CarModel;
}
public void setCarModel(String carModel) {
	CarModel = carModel;
}
public String getCarBrand() {
	return CarBrand;
}
public void setCarBrand(String carBrand) {
	CarBrand = carBrand;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}

}