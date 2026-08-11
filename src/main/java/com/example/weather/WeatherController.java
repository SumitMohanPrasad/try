import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/mock")
    public ResponseEntity<String> getMockWeather() {
        String mockWeather = weatherService.getMockWeather();
        log.info("Mock weather data returned");
        return new ResponseEntity<>(mockWeather, HttpStatus.OK);
    }
}