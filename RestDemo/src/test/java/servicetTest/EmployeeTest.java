/*package servicetTest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;



import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.util.CommonUtil;

import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-applicationcontext.xml" })
@Transactional(propagation = Propagation.NESTED)
@WebAppConfiguration("src/main/webapp/WEB-INF")

public class EmployeeTest extends TestCase {
	
	@Autowired
	private WebApplicationContext wac;

	protected MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testMock() throws Exception {
		assertNotNull("Mock MVC cannot be initialized", mockMvc);
	}

	private MockHttpServletRequestBuilder get(String uri) {
		return MockMvcRequestBuilders.get(uri);
	}

	private MockHttpServletRequestBuilder post(String uri) {
		return MockMvcRequestBuilders.post(uri);
	}

	private StatusResultMatchers status() {
		return MockMvcResultMatchers.status();
	}

	@Test
	public void viewEmployee() throws  Exception {

		
	
		Employee request = new Employee();
		request.setId(3);
		
		String employeeDetails;
		// Group
		employeeDetails = mockMvc
				.perform(
						post("/rest/employee/view")
	
								.accept("application/json")
								.param("json_request",
										CommonUtil
												.convertFromEntityToJsonStr(request)))
				.andExpect(status().is(200)).andReturn().getResponse()
				.getContentAsString();
		System.out
				.println("testViewACConfiguration -- acconfigDetails Group-- "
						+ employeeDetails);

	}

}
*/