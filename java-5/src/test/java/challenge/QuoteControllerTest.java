package challenge;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
    private QuoteService service;

	@Test
	public void getQuote() throws Exception {
		Quote quote = new Quote();
		quote.setId(2);
		quote.setActor("ACTOR_TEST");
		quote.setQuote("QUOTE_TEST");
		
		given(service.getQuote()).willReturn(quote);
		
		mvc.perform(get("/v1/quote")
	               .accept(MediaType.APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$", notNullValue()));
	}
	
	@Test
	public void getQuoteByActor() throws Exception {
		String actor = "ACTOR_TEST";
		
		Quote quote = new Quote();
		quote.setId(1234);
		quote.setActor(actor);
		quote.setQuote("QUOTE_TEST");
		
		given(service.getQuoteByActor(actor)).willReturn(quote);
		
		mvc.perform(get("/v1/quote/" + actor)
	               .accept(MediaType.APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$", notNullValue()));
	}

}
