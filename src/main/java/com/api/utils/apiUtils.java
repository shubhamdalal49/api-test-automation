


package com.api.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.api.config.configReader; // Make sure package name & class match

public class apiUtils {
    public static Response sendRequest(String method, String endpoint, String payload) {
        // Fetch API key from config
        String apiKey = configReader.getProperty("reqres.apiKey"); // Change key name as per your config

        // Always add API key header + Content-Type
        RequestSpecification reqSpec = RestAssured.given()
            .header("Content-Type", "application/json")
            .header("x-api-key", apiKey); // Use proper header name as per ReqRes docs

        if (payload != null)
            reqSpec.body(payload);

        switch (method.toUpperCase()) {
            case "GET": return reqSpec.get(endpoint);
            case "POST": return reqSpec.post(endpoint);
            case "PUT": return reqSpec.put(endpoint);
            case "DELETE": return reqSpec.delete(endpoint);
            default: throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }
    }
}
