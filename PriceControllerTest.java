package com.company.ms_products.controllers_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.test.context.TestPropertySource;

import com.company.ms_products.controllers.PriceController;
import com.company.ms_products.dto.PriceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;


/**
 * Price Service Test. Here is where doing the test of rest interface
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.yml")
public class PriceControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private PriceController controller;
	
	@DisplayName("Test get all prices")
	@Test
	void test_whenValidInput_thenReturns200() throws Exception {
		Integer pageNo = 0;
		Integer pageSize =10;
		String sortBy = "id";
		
//		assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/",
//				String.class)).contains("Hello, World");
		
//		this.restTemplate.getForObject("http://localhost:" + port + "/prices",
//				String.class);
		
		Page<PriceDto> priceResult = controller.getAllEmployees(pageNo, pageSize, sortBy).getBody();
		
//		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyyhh:mm:ss");
		ObjectMapper mapper = new ObjectMapper();
		mapper=mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    // StdDateFormat is ISO8601 since jackson 2.9
	    mapper=mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
//		mapper.setDateFormat(df);
		
		String json = null ;
		try {
            json = mapper.writeValueAsString(priceResult);
//            System.out.println("ResultingJSONstring = " + json);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		
		assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/prices",
				String.class), json );
		
	}
	
	

}
