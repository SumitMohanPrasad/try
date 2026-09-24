import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QuoteController {

    @GetMapping("/quotes")
    public String getQuotes() {
        // existing implementation
    }

    @GetMapping("/random-quote")
    public String getRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(10); // assuming 10 quotes in the database
        return getQuotes(); // for now, just return the existing quotes endpoint
    }
}