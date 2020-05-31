  package challenge;

  import java.util.List;

  import org.springframework.data.jpa.repository.JpaRepository;


public interface QuoteRepository extends JpaRepository<Quote, Integer> {
  List<Quote> findQuotesByActor(String actor);


}
