package dk.kea.videoprojektmain.controller;

import dk.kea.videoprojektmain.model.Car;
import dk.kea.videoprojektmain.repository.CarRepository;
import dk.kea.videoprojektmain.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    CarRepository carRepo;

    CarService carService = new CarService();

    @GetMapping("/createCar")
    public String createCar() {
        return "createCar";
    }

    @PostMapping("/createCar")
    public String createCar(
            @RequestParam("brand") String brand,
            @RequestParam("age") int age,
            @RequestParam("type") String type,
            @RequestParam("colour") String colour,
            @RequestParam("licenseplate") String licenseplate) {

        String img = carService.getImg(brand, colour);

        Car car = new Car(brand, age, type, colour, licenseplate, img);
        carRepo.save(car);
        return "redirect:/";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("id") int id) {
        carRepo.delete(id);
        return "redirect:/";
    }

    @GetMapping("/updateCar")
    public String updateCar(@RequestParam("id") int id, Model model) {
        Car car = carRepo.getCarById(id);
        model.addAttribute(car);
        return "updateCar";
    }

    @PostMapping("/updateCar")
    public String postupdateCar(
        @RequestParam("id") int id,
        @RequestParam("brand") String brand,
        @RequestParam("age") int age,
        @RequestParam("type") String type,
        @RequestParam("colour") String colour,
        @RequestParam("licenseplate") String licenseplate) {

        String img = carService.getImg(brand, colour);
        Car car = new Car(id, brand, age, type, colour, licenseplate, img);
        carRepo.update(car);
        return "redirect:/";
    }

    @GetMapping("/showCar")
    public String showCar(@RequestParam("id") int id, Model model) {

        Car car = carRepo.getCarById(id);
        model.addAttribute(car);
        return "showCar";
    }

}
