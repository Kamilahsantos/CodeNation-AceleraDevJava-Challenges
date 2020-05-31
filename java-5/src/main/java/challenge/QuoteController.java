package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

  @Autowired
  private QuoteService service;

  @GetMapping
  public Quote getQuote() {
    return service.getQuote();
  }

  @GetMapping("/{actor}")
  public Quote getQuoteByActor(@PathVariable String actor) {
    return service.getQuoteByActor(actor);
  }

}
