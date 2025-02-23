package dk.kea.videoprojektmain.controller;

import dk.kea.videoprojektmain.model.Car;
import dk.kea.videoprojektmain.repository.CarRepository;
import dk.kea.videoprojektmain.repository.CarRepositorySTUB;
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

    /*@Autowired
    CarRepositorySTUB carRepo;*/

    @Autowired
    CarService carService;

    @GetMapping("/getCreateCar")
    public String createCar() {
        return "createCar";
    }

    @PostMapping("/saveCreateCar")
    public String postCreateCar(
            @RequestParam("brand") String brand,
            @RequestParam("modelyear") int modelyear,
            @RequestParam("type") String type,
            @RequestParam("colour") String colour,
            @RequestParam("licenseplate") String licenseplate) {

        String img = carService.getImg(brand, colour);

        Car car = new Car(brand, modelyear, type, colour, licenseplate, img);
        carRepo.save(car);
        return "redirect:/";
    }

    @GetMapping("/getUpdateCar")
    public String updateCar(@RequestParam("id") int id, Model model) {
        Car car = carRepo.getCarById(id);
        model.addAttribute(car);
        return "updateCar";
    }

    @PostMapping("/saveUpdateCar")
    public String postupdateCar(
            @RequestParam("id") int id,
            @RequestParam("brand") String brand,
            @RequestParam("modelyear") int modelyear,
            @RequestParam("type") String type,
            @RequestParam("colour") String colour,
            @RequestParam("licenseplate") String licenseplate) {

        String img = carService.getImg(brand, colour);
        Car car = new Car(id, brand, modelyear, type, colour, licenseplate, img);
        carRepo.update(car);
        return "redirect:/";
    }

    @GetMapping("/showCar")
    public String showCar(@RequestParam("id") int id, Model model) {

        Car car = carRepo.getCarById(id);
        model.addAttribute(car);

        return "showCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("id") int id) {

        carRepo.delete(id);

        return "redirect:/";
    }

}
