package com.calc.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.assertEquals;


public class TestCalcController extends  AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    /**
     * Method to Test the add method with valid numbers*/
    @Test
    public void testadd() throws Exception {
        double num1 =4.0;
        double num2 =5.0;
        String uri = "/api/add";
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("num1", Double.toString(num1));
        params.add("num2", Double.toString(num2));

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .params(params)).andReturn();
        int status = mvcResult.getResponse().getStatus();

        //Expecting http 200
        assertEquals(200, status);
        assertEquals("9.0",mvcResult.getResponse().getContentAsString());
    }
    /**
     * Test method with empty values*/
    @Test
    public void testaddempty(){
        String uri = "/api/add";
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("num1", "");
        params.add("num2", "Double.toString(num2)");

        MvcResult mvcResult = null;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .params(params)).andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int status = mvcResult.getResponse().getStatus();

        // Expecting http status 400 error
        assertEquals(400, status);
    }
}
