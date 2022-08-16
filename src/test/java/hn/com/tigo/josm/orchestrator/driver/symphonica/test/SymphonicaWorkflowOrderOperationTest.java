package hn.com.tigo.josm.orchestrator.driver.symphonica.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Test;

import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.orchestrator.driver.symphonica.AbstractDriver;
import hn.com.tigo.josm.orchestrator.driver.symphonica.operation.SymphonicaWorkflowOrderTaskOperation;

public class SymphonicaWorkflowOrderOperationTest extends AbstractTest {

	public SymphonicaWorkflowOrderOperationTest() throws AdapterException {

	}

	@Test
	public void test() {
		final SymphonicaWorkflowOrderTaskOperation operation = new SymphonicaWorkflowOrderTaskOperation(getRequest());
		try {
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
			AbstractDriver abstractDriver = null;
			abstractDriver.setGetLastExec(null);
		} catch (AdapterException e) {
			//fail(e.getMessage());
		}
	}
	
	@Test
	public void test2() {
		final SymphonicaWorkflowOrderTaskOperation operation = new SymphonicaWorkflowOrderTaskOperation(getRequestErr());
		try {
			AbstractDriver abstractDriver = null;
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR_OF_DAY, -5);
			abstractDriver.setGetLastExec(calendar.getTime());
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
		} catch (AdapterException e) {
			//fail(e.getMessage());
		}
	}
	
	@Test
	public void testErr() {
		final SymphonicaWorkflowOrderTaskOperation operation = new SymphonicaWorkflowOrderTaskOperation(getRequestErr());
		try {
			AbstractDriver abstractDriver = null;
			abstractDriver.setGetLastExec(null);
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
		} catch (AdapterException e) {
			//fail(e.getMessage());
		}
	}

	public String getRequest() {

		String json = "{\r\n" + 
				"  \"externalId\":\"amz-get-test-002-Query-richy-2\",\r\n" + 
				"  \"priority\": \"4\",\r\n" + 
				"  \"description\":\"OTT Service Getting Information\",\r\n" + 
				"  \"category\":\"OTT\",\r\n" + 
				"  \"workflowOrderSpec\":{\r\n" + 
				"\r\n" + 
				"    \"code\":\"OTT_SERVICE.GET\",\r\n" + 
				"    \"source\":\"SYM-WOM\"\r\n" + 
				"  },\r\n" + 
				"  \"source\":\"SYM-WOM\",\r\n" + 
				"  \"input\":[\r\n" + 
				"    {\r\n" + 
				"      \"name\":\"MSISDN\",\r\n" + 
				"      \"value\":\"50212300005\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\":\"SUPPLIER\",\r\n" + 
				"      \"value\":\"AMAZON_PRIME\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\":\"CUSTOM_INPUT_1\",\r\n" + 
				"      \"value\":\"telco_code:HNTIGO\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\":\"CUSTOM_INPUT_2\",\r\n" + 
				"      \"value\":\"product_name:amazonVideoPrepaid\"\r\n" + 
				"    },{\r\n" + 
				"      \"name\":\"CUSTOM_INPUT_3\",\r\n" + 
				"      \"value\":\"product_retry:0\"\r\n" + 
				"    },{\r\n" + 
				"      \"name\":\"CUSTOM_INPUT_4\",\r\n" + 
				"      \"value\":\"product_sku:1135\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";

		return json;
	}
	
	public String getRequestErr() {

		String json = "";

		return json;
	}
}
