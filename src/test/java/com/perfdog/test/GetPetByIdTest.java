package com.perfdog.test;

import com.perfdog.config.TestRunner;
import com.perfdog.model.PetDTO;
import com.perfdog.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetPetByIdTest extends TestRunner {

    @Test(testName = "Verify get pet by id")
    public void getPetById(){
        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "/pet/811990",
                getApikey()
        );
        PetDTO pet = response.as(PetDTO.class);

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match.");
        assertEquals(pet.getName(), "doggie", "The name doesn't match.");
        assertEquals(pet.getStatus(), "available", "The status doesn't match.");
    }
}
