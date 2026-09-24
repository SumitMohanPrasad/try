import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = getQuotes();
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }
}