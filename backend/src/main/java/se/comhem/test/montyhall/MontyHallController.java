package se.comhem.test.montyhall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MontyHallController {

    private MontyHallService service;

    @Autowired
    public MontyHallController(MontyHallService service) {
        this.service = service;
    }

    @RequestMapping("/simulation")
    public SimulationResult simulation(
            @RequestParam(name="iterations", required = true) Integer iterations,
            @RequestParam(name="switchDoors", required = true, defaultValue = "true") boolean switchDoors) {
        return service.runSimulation(iterations, switchDoors);
    }
}