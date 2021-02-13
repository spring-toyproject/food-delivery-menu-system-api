package com.fooddelivery;

import com.fooddelivery.base.AbstractControllerTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class HealthCheckControllerTest extends AbstractControllerTest {
    @Autowired
    private HealthCheckController healthCheckController;

    @Override
    protected Object controller() {
        return healthCheckController;
    }

    @Test
    @DisplayName("GET /")
    public void 헬스체크가_정상적으로_동작합니다() throws Exception {
        //given
        String healthCheckURL = "/";
        String healthCheckResult = "{}";

        //when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(healthCheckURL))
                .andExpect(status().isOk())
                .andReturn();

        //then
        String resultResponseString = result.getResponse().getContentAsString();
        assertEquals(resultResponseString, healthCheckResult);
    }
}
