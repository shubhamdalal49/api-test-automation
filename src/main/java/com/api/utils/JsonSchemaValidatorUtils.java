package com.api.utils;

import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;

public class JsonSchemaValidatorUtils {
    public static void assertSchema(Response response, String schemaFile) {
        response.then().assertThat()
            .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/" + schemaFile)));
    }
}
