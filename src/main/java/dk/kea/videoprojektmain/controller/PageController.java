package dk.kea.videoprojektmain.controller;

import dk.kea.videoprojektmain.model.Car;
import dk.kea.videoprojektmain.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class PageController {

    @Autowired
    CarRepository carRepo;

    @GetMapping("/")
    public String mainPage(Model model) {
        ArrayList<Car> carList;
        carList = carRepo.getAllCars();
        model.addAttribute("carList", carList);
        return "index";
    }
}
