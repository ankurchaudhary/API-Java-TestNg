package com.test;

import Utilities.ConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.Responses.pojo.Base;
import com.test.Testdata.POJO.Root;
import com.test.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class APITests {

    Utils utils = new Utils();

    @BeforeTest
    public void settestdata() throws IOException {
        ConfigReader.initialize();
    }

    @Test
    public void verfiyStatusCode200() throws IOException {
        int status = utils.getCall().getStatusCode();
        Assert.assertEquals(status,200);

    }

    @Test
    public void verifyDataForGetCall() throws IOException {
        Response response = utils.getCall();

        Base base = response.body().as(Base.class);

        Assert.assertEquals(base.getName(), utils.expectedData().getName());
    }





    
}
