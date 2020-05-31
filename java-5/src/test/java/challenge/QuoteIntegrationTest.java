package challenge;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuoteIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getQuote() throws Exception {
		ResponseEntity<Quote> response = restTemplate.getForEntity("/v1/quote", Quote.class);
		Quote quote = response.getBody();

		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(quote);
	}

	@Test
	public void getQuoteByActor() throws Exception {
		ResponseEntity<Quote> response = restTemplate.getForEntity("/v1/quote/John Cleese", Quote.class);
		Quote quote = response.getBody();

		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(quote);
	}

}
