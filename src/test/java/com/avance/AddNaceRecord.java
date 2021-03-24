package com.avance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class AddNaceRecord {
    private final ObjectMapper mapper = new ObjectMapper();
    public RestTemplate restTemplate;
    private ResponseEntity<String> response;
    private HttpHeaders headers;
    private String url;


    @Given("^I set POST nace for 'addNace' endpoint$")
    public void setAddNaceEndpoint() {
        this.url = "http://localhost:8084/add-nace";
    }

    @When("^I set request headers$")
    public void setAddNaceRequestBody() {
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
    }

    @When("^Send a POST HTTP request with body$")
    public void sendPostRequestWithBody() throws JsonProcessingException {
        Map<String, Object> naceBody = new HashMap<String, Object>() {
            {
                put("order", 398481);
                put("level", 1);
                put("code", "A");
                put("parent", "");
                put("description", "AGRICULTURE,FORESTRY,AND FISHING");
                put("thisItemAlsoIncludes", "");
                put("thisItemIncludes", "multiline string");
                put("rulings", "");
                put("thisItemExcludes", "");
                put("referenceToISICRev4", "A");
            }
        };
        String naceBodyAsString = mapper.writeValueAsString(naceBody);
        HttpEntity<String> httpEntity = new HttpEntity<>(naceBodyAsString, headers);
        this.restTemplate = new RestTemplate();
        this.response = restTemplate.postForEntity(url, httpEntity, String.class);
    }

    @Then("^I get a response code 200$")
    public void verifyPostResponse() {
        int responseCode = this.response.getStatusCodeValue();
        Assert.assertEquals(200, responseCode);
    }
}
