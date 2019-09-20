package org.virtusa.expenseTracker.test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.virtusa.expenseTracker.expModel.ExpCategory;
import org.virtusa.expenseTracker.expService.CategoryService;

import com.polaris.expenseTracker.ExpenseTrackerApplicationTests;

@WebAppConfiguration
public class UnitTest extends ExpenseTrackerApplicationTests{
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void expenseCategory() throws Exception {
		mockMvc.perform(get("/expense/category")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
				
	}
	@Test
	public void shopping() throws Exception
	{
		mockMvc.perform(get("/expense/shopping")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	@Test
	public void traveling() throws Exception
	{
		mockMvc.perform(get("/expense/traveling")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	@Test
	public void entertainment() throws Exception
	{
		mockMvc.perform(get("/expense/entertainment")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	@Test
	public void food() throws Exception
	{
		mockMvc.perform(get("/expense/food")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	@Test
	public void others() throws Exception
	{
		mockMvc.perform(get("/expense/others")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void budget() throws Exception
	{
		mockMvc.perform(get("/expense/budget")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	
}
