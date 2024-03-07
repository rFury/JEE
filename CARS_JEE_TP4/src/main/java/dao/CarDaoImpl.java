package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Car;
import metier.SingletonConnection;

public class CarDaoImpl implements ICarDao {

    @Override
    public Car save(Car c) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO CARS(CAR_MODEL, CAR_BRAND, PRICE) VALUES(?, ?, ?)");
            ps.setString(1, c.getCarModel());
            ps.setString(2, c.getCarBrand());
            ps.setDouble(3, c.getPrice());
            ps.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(CAR_ID) as MAX_ID FROM CARS");
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                c.setCarID(rs.getLong("MAX_ID"));
            }
            ps.close();
            ps2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Car> carsByModel(String model) {
        List<Car> cars = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CARS WHERE CAR_BRAND LIKE ?");
            ps.setString(1, "%" + model + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car c = new Car();
                c.setCarID(rs.getLong("CAR_ID"));
                c.setCarModel(rs.getString("CAR_MODEL"));
                c.setCarBrand(rs.getString("CAR_BRAND"));
                c.setPrice(rs.getDouble("PRICE"));
                cars.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car getCar(Long id) {
        Connection conn = SingletonConnection.getConnection();
        Car c = new Car();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CARS WHERE CAR_ID = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c.setCarID(rs.getLong("CAR_ID"));
                c.setCarModel(rs.getString("CAR_MODEL"));
                c.setCarBrand(rs.getString("CAR_BRAND"));
                c.setPrice(rs.getDouble("PRICE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Car updateCar(Car c) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE CARS SET CAR_MODEL=?, CAR_BRAND=?, PRICE=? WHERE CAR_ID=?");
            ps.setString(1, c.getCarModel());
            ps.setString(2, c.getCarBrand());
            ps.setDouble(3, c.getPrice());
            ps.setLong(4, c.getCarID());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public void deleteCar(Long id) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM CARS WHERE CAR_ID = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
