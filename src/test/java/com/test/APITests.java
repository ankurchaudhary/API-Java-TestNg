package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testdata.Root;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import com.test.requests.Request;
import com.test.responses.Resp;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class APITests {

    @BeforeTest
    public void settestdata() throws IOException {
        ConfigReader.initialize();
    }

    @Test
    public void verfiyStatusCode200() throws IOException {
        int status = getCall().getStatusCode();
        Assert.assertEquals(status,200);
    }

    @Test
    public void testGetCall() throws IOException {
        SoftAssert softAssert = new SoftAssert();

        Response response = getCall();

        Resp resp = response.body().as(Resp.class);

        softAssert.assertEquals(expectedData().getPage(),
                resp.getPage());

        softAssert.assertEquals(expectedData().getPer_page(),
                resp.getPer_page());

        softAssert.assertEquals(expectedData().getTotal(),
                resp.getTotal());

        softAssert.assertEquals(expectedData().getTotal_pages(),
                resp.getTotal_pages());

        softAssert.assertEquals(expectedData().getData().get(0).getId(),
                resp.getData().get(0).getId());

        softAssert.assertEquals(expectedData().getData().get(0).getEmail(),
                resp.getData().get(0).getEmail());

        softAssert.assertEquals(expectedData().getData().get(0).getFirst_name(),
                resp.getData().get(0).getFirst_name());

        softAssert.assertEquals(expectedData().getData().get(0).getLast_name(),
                resp.getData().get(0).getLast_name());

        softAssert.assertEquals(expectedData().getData().get(0).getAvatar(),
                resp.getData().get(0).getAvatar());

        softAssert.assertAll();
    }

    @Test
    public void testPostCall() throws IOException {
        Request request = new Request();
        request.setName("morpheus");
        request.setJob("leader");

        Response response = RestAssured.given()
                .header("Content-Type",
                        "application/json")
                .baseUri(ConfigReader.get("baseUrl"))
                .body(request).post();
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void testBadRequest400(){
        Response response = RestAssured.given()
                .header("Content-Type",
                        "application/json")
                .baseUri(ConfigReader.get("postUrl"))
                .body("").post();

        Assert.assertEquals(response.statusCode(), 400);
    }

    @Test
    public void testNotFound404(){

        String badUrl = "https://reqres.in/ai/users";
        Response response = RestAssured.given()
                .header("Content-Type",
                        "application/json")
                .baseUri(badUrl).get();

        Assert.assertEquals(response.statusCode(), 404);
    }

    public Response getCall(){
        return RestAssured
                .given().baseUri(ConfigReader.get("baseUrl"))
                .queryParam("page",1).get();
    }

    public Root expectedData() throws IOException {
        File file = new File("src/test" +
                "/resources/json/testdata.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(file,Root.class);

        return root;
    }
}
