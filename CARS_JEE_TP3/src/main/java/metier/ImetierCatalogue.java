package metier;
import java.util.List;
public interface ImetierCatalogue {
public List<Car> getCarParMotCle(String mc);
public void addCar(Car p);
}