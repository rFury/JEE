package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue {

    @Override
    public List<Car> getCarParMotCle(String mc) {
        List<Car> cars = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CARS WHERE CAR_BRAND LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setCarID(rs.getLong("CAR_ID"));
                car.setCarBrand(rs.getString("CAR_BRAND"));
                car.setCarModel(rs.getString("CAR_MODEL"));
                car.setPrice(rs.getDouble("PRICE"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public void addCar(Car car) {
        // Implement this method if needed
    }
}
