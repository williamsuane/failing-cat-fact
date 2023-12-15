package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

@RestClientTest({CatFactService.class})
class CatFactServiceTest {

  @Autowired
  private MockRestServiceServer server;
  @Autowired
  private CatFactService catFactService;

  @Test
  void test() {
    server.expect(MockRestRequestMatchers.requestTo("http://localhost:8080/fact"))
        .andRespond(MockRestResponseCreators.withSuccess("""
            	{"fact":"In 1987 cats overtook dogs as the number one pet in America."}
            """, MediaType.APPLICATION_JSON));

    var catFact = catFactService.getFact();
    assertEquals("In 1987 cats overtook dogs as the number one pet in America.", catFact.fact());
  }
}