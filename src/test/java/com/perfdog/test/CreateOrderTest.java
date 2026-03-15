package com.perfdog.test;

import com.perfdog.config.TestRunner;
import com.perfdog.model.OrderDTO;
import com.perfdog.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateOrderTest extends TestRunner {

    @Test(testName = "Verify create order")
    public void createOrderTest(){

        OrderDTO order = OrderDTO.builder()
                .id(1)
                .petId(811990)
                .quantity(1)
                .shipDate("2024-01-01T00:00:00.00Z")
                .status("placed")
                .complete(true)
                .build();

        Response response = RequestBuilder.postRequest(
                getBaseurl(),
                "store/order",
                order,
                getApikey()
        );

        OrderDTO createOrderDto = response.as(OrderDTO.class);

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match.");
        assertEquals(createOrderDto.getId(), order.getId(), "The id code doesn't match.");
        assertEquals(createOrderDto.getPetId(), order.getPetId(), "The pet id code doesn't match.");
    }
}
