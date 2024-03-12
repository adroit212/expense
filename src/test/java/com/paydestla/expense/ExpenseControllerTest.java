package com.paydestla.expense;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paydestla.expense.domain.Expenses;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.time.LocalDate;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class ExpenseControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private final String TEST_USER_ID = "USER11";

    private String mapToJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    private Expenses mapToExpense(String json)
            throws IOException {
        return objectMapper.readValue(json, Expenses.class);
    }

    @Test
    public void createExpenseTest() throws Exception{
        String uri = "/expense";

        Expenses expenses = new Expenses();
        expenses.setExpenseDate(LocalDate.now());
        expenses.setExpenseReason("For testing the service");
        expenses.setExpenseValue(300000.00);
        expenses.setUserId(TEST_USER_ID);

        String jsonExpense = mapToJson(expenses);

        // Perform the POST request
        MvcResult mvcResponse = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, uri)
                .content(jsonExpense)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResponse.getResponse().getStatus();
        //Check that endpoint returns 200 - OK response
        Assert.assertEquals(HttpStatus.OK.value(), status);

        String content = mvcResponse.getResponse().getContentAsString();
        Expenses expenseResponse = mapToExpense(content);
        //check that record was saved and returned an Expense object as expected
        Assert.assertFalse(ObjectUtils.isEmpty(expenseResponse));
    }

    @Test
    public void getExpensesByUserIdTest() throws Exception {
        String uri = "/expense/"+TEST_USER_ID;
        MvcResult mvcResponse = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResponse.getResponse().getStatus();
        //Check that endpoint returns 200 - OK response
        Assert.assertEquals(HttpStatus.OK.value(), status);
    }
}
