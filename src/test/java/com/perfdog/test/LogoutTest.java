package com.perfdog.test;

import com.perfdog.config.TestRunner;
import com.perfdog.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends TestRunner {

    @Test(testName = "Verify logout")
    public void logoutTest(){
        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "user/logout",
                getApikey()
        );

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match.");
    }
}
