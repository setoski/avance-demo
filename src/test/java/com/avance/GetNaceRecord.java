package com.avance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class GetNaceRecord {
    private final ObjectMapper mapper = new ObjectMapper();
    public RestTemplate restTemplate;
    private ResponseEntity<String> response;
    private HttpHeaders headers;
    private String url;

    @Given("^Retrieve a Nace recorde with correct OrderId$")
    public void setAddNaceEndpoint() {
        this.url = "http://localhost:8084/add-nace";
    }

    @When("^I set request headers$")
    public void setAddNaceRequestBody() {
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
    }

    @When("^Send a GET HTTP request with existing OrderId$")
    public void sendPostRequestWithBody() throws JsonProcessingException {
        Map<String, Object> naceBody = new HashMap<String, Object>() {
            {
                put("orderId", -1);
            }
        };
        String naceBodyAsString = mapper.writeValueAsString(naceBody);
        HttpEntity<String> httpEntity = new HttpEntity<>(naceBodyAsString, headers);
        this.restTemplate = new RestTemplate();
        this.response = restTemplate.getForEntity(this.url,String.class);

    }

    @Then("^I get a response code$")
    public void verifyGetResponse() {
        int responseCode = this.response.getStatusCodeValue();
        Assert.assertEquals(200, responseCode);
    }
}
