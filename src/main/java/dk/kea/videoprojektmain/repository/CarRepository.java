package dk.kea.videoprojektmain.repository;

import dk.kea.videoprojektmain.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class CarRepository {

    // Dette repository bruges når databasen er tilkoblet.

    @Autowired
    private DataSource dataSource;
    public ArrayList<Car> getAllCars() {
        ArrayList<Car> bilList = new ArrayList<>();
        String sql = "SELECT * FROM cars";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Car bil = new Car();
                bil.setId(resultSet.getInt("id"));
                bil.setModelyear(resultSet.getInt("modelyear"));
                bil.setBrand(resultSet.getString("brand"));
                bil.setType(resultSet.getString("type"));
                bil.setColour(resultSet.getString("colour"));
                bil.setLicenseplate(resultSet.getString("licenseplate"));
                bil.setImage(resultSet.getString("img"));
                bilList.add(bil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bilList;
    }

    public void save(Car bil) {
        String sql = "INSERT INTO cars (brand, modelyear, type, colour, licenseplate, img) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, bil.getBrand());
            statement.setInt(2, bil.getModelyear());
            statement.setString(3, bil.getType());
            statement.setString(4, bil.getColour());
            statement.setString(5, bil.getLicenseplate());
            statement.setString(6, bil.getImage());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM cars WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car getCarById(int id) {
        Car car = null;
        String sql = "SELECT * FROM cars WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    car = new Car();
                    car.setId(resultSet.getInt("id"));
                    car.setModelyear(resultSet.getInt("modelyear"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setType(resultSet.getString("type"));
                    car.setColour(resultSet.getString("colour"));
                    car.setLicenseplate(resultSet.getString("licenseplate"));
                    car.setImage(resultSet.getString("img"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }

    public void update(Car car) {
        String sql = "UPDATE cars SET brand = ?, modelyear = ?, type = ?, colour = ?, licenseplate = ?, img = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, car.getBrand());
            statement.setInt(2, car.getModelyear());
            statement.setString(3, car.getType());
            statement.setString(4, car.getColour());
            statement.setString(5, car.getLicenseplate());
            statement.setString(6, car.getImage());
            statement.setInt(7, car.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}