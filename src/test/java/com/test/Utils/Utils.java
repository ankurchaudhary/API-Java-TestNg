package com.test.Utils;

import Utilities.ConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.Testdata.POJO.Root;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;

public class Utils {
    public Root expectedData() throws IOException {
        File file = new File("src/test/java/com" +
                "/test/testdata/testdata.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(file,Root.class);

        return root;
    }

    public Response getCall(){
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(ConfigReader.get("URL"));
        return requestSpecification.request(Method.GET,"");
    }
}
