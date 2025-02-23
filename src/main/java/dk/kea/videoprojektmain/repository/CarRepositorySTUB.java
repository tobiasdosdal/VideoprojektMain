package dk.kea.videoprojektmain.repository;

import dk.kea.videoprojektmain.config.InitData;
import dk.kea.videoprojektmain.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositorySTUB {

    // Dette repository bruges før databasen tilføjes, til at arbejde med InitData.

    @Autowired
    InitData initData;

    public List<Car> getAllCars() {
        return initData.getCarList();
    }

    public Car getCarById(int id) {
        for (Car car : initData.getCarList()) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public void save(Car car) {
        List<Car> carList = initData.getCarList();
        int newID;

        if (carList.isEmpty()) {
            newID = 1;
        } else {
            newID = carList.getLast().getId() + 1;
        }

        car.setId(newID);
        carList.add(car);
    }

    public void update(Car updatedCar) {
        List<Car> carList = initData.getCarList();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getId() == updatedCar.getId()) {
                carList.set(i, updatedCar);
                return;
            }
        }
    }

    public void deleteCar (int id) {
        Car car = getCarById(id);
        initData.getCarList().remove(car);

    }
}
