package com.perfdog.test;

import com.perfdog.config.TestRunner;
import com.perfdog.model.CreateUserResponseDTO;
import com.perfdog.model.UserDTO;
import com.perfdog.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class CreateUserTest extends TestRunner {

    @Test(testName = "Verify user creation")
    public void createUserTest(){
        UserDTO user = UserDTO.builder()
                .id(1001)
                .username("user15125")
                .firstName("Daniel")
                .lastName("Montezuma")
                .email("daniel@globant.com")
                .password("123456")
                .phone("12345677")
                .userStatus(1)
                .build();

        Response response = RequestBuilder.postRequest(
                getBaseurl(),
                "/user",
                user,
                getApikey()
        );

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match.");
    }
}
