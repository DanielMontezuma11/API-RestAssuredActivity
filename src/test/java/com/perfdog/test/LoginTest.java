package com.perfdog.test;

import com.perfdog.config.TestRunner;
import com.perfdog.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends TestRunner {
    @Test(testName = "Verify login")
    public void loginTest(){
        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "/user/login?username=test&password=12345",
                getApikey()
        );

        assertEquals(response.getStatusCode(), 200);
    }
}
