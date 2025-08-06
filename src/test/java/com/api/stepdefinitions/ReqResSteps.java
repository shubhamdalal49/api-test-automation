package com.api.stepdefinitions;

import com.api.config.configReader;
// import com.api.utils.*;
import com.api.utils.apiUtils;
import com.api.utils.JsonUtil;
import com.api.utils.JsonSchemaValidatorUtils;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import io.cucumber.java.en.*;

public class ReqResSteps {
    private Response response;
    private String endpoint;
    private String payload;

    @Given("I set {word} endpoint for {string} in ReqRes API")
    public void i_set_endpoint(String method, String resource) {
        endpoint = configReader.getProperty("reqres.baseUri") + "/" + resource;
    }

    @And("I provide JSON payload from {string}")
    public void i_provide_payload(String dataFile) {
        payload = JsonUtil.readJsonFile("data/" + dataFile);
    }

    @When("I send a GET HTTP request")
    public void i_send_get_request() { response = apiUtils.sendRequest("GET", endpoint, null); }

    @When("I send a POST HTTP request")
    public void i_send_post_request() { response = apiUtils.sendRequest("POST", endpoint, payload); }

    @When("I send a PUT HTTP request")
    public void i_send_put_request() { response = apiUtils.sendRequest("PUT", endpoint, payload); }

    @When("I send a DELETE HTTP request")
    public void i_send_delete_request() { response = apiUtils.sendRequest("DELETE", endpoint, null); }

    // @Then("the response status code should be {int}")
    // public void the_status_code_should_be(int statusCode) { assertEquals(response.getStatusCode(), statusCode); }

    @Then("the response status code should be {int}")
public void the_status_code_should_be(int expectedStatus) {
    assertEquals(response.getStatusCode(), expectedStatus,
        "Wrong status code for " + endpoint + ". Response body:\n" + response.asString());
}


    @Then("response should match JSON schema {string}")
    public void response_schema_check(String schemaFile) {
        JsonSchemaValidatorUtils.assertSchema(response, "schemas/" + schemaFile);
    }
}
