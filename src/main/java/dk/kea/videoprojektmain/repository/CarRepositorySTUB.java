package dk.kea.videoprojektmain.repository;

import dk.kea.videoprojektmain.config.InitData;
import dk.kea.videoprojektmain.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositorySTUB {

    @Autowired
    InitData initData;

    public List<Car> getAllCars() {
        return initData.getCarList();
    }

    public Car getCarById(int id) {
        return initData.getCarList().stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Car car) {
        List<Car> carList = initData.getCarList();
        int newId = carList.isEmpty() ? 1 : carList.get(carList.size() - 1).getId() + 1;
        car.setId(newId);
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

    public void delete(int id) {
        List<Car> carList = initData.getCarList();
        carList.removeIf(car -> car.getId() == id);
    }
}
