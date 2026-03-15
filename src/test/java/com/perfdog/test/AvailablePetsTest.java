package com.perfdog.test;

import com.perfdog.config.TestRunner;
import com.perfdog.model.PetDTO;
import com.perfdog.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AvailablePetsTest extends TestRunner {

    @Test(testName = "Verify pets available")
    public void getAvailableTest(){
        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "/pet/findByStatus?status=available",
                getApikey()
        );
        PetDTO[] pets = response.as(PetDTO[].class);

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match.");

        for(PetDTO pet : pets){
            assertNotNull(pet.getId(), "The id is empty.");
            assertEquals(pet.getStatus(), "available", "The status doesn't match.");
        }

    }
}
