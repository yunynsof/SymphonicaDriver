package hn.com.tigo.josm.orchestrator.driver.symphonica.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.orchestrator.driver.symphonica.AbstractDriver;
import hn.com.tigo.josm.orchestrator.driver.symphonica.operation.SymphonicaServiceOrderTaskOperation;

public class SymphonicaServiceOrderOperationTest extends AbstractTest {

	public SymphonicaServiceOrderOperationTest() throws AdapterException {

	}

	@Test
	public void test() {
		final SymphonicaServiceOrderTaskOperation operation = new SymphonicaServiceOrderTaskOperation(getRequest());
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
		final SymphonicaServiceOrderTaskOperation operation = new SymphonicaServiceOrderTaskOperation(getRequestErr());
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
		final SymphonicaServiceOrderTaskOperation operation = new SymphonicaServiceOrderTaskOperation(getRequestErr());
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
				"  \"externalId\": \"EXT-9999\",\r\n" + 
				"  \"priority\": \"4\",\r\n" + 
				"  \"description\": \"some description\",\r\n" + 
				"  \"category\": \"OTT_SERVICE\",\r\n" + 
				"  \"region\": \"\",\r\n" + 
				"  \"source\": \"SYM-SOM\",\r\n" + 
				"  \"orderType\": \"PROVIDE\",\r\n" + 
				"  \"notes\": [],\r\n" + 
				"  \"orderItems\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": \"1\",\r\n" + 
				"      \"action\": \"ADD\",\r\n" + 
				"      \"appointments\": [],\r\n" + 
				"      \"orderItemRelationships\": [],\r\n" + 
				"      \"service\": {\r\n" + 
				"        \"serviceSpecification\": {\r\n" + 
				"          \"code\": \"OTT_SERVICE_CFS\",\r\n" + 
				"          \"version\": \"1.0\"\r\n" + 
				"        },\r\n" + 
				"        \"characteristics\": [\r\n" + 
				"          {\r\n" + 
				"            \"name\": \"SUPPLIER\",\r\n" + 
				"            \"value\": \"TEST\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"name\": \"EMAIL\",\r\n" + 
				"            \"value\": \"ott.user.new@ott.com\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"name\": \"USER_ID\",\r\n" + 
				"            \"value\": \"ott.user\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"name\": \"PASSWORD\",\r\n" + 
				"            \"value\": \"ott.password\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"name\": \"SUBS_TYPE\",\r\n" + 
				"            \"value\": \"10\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"name\": \"URN\",\r\n" + 
				"            \"value\": \"tve:hbo\"\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"name\": \"CUSTOM_INFO\",\r\n" + 
				"            \"value\": \"PACKAGE\",\r\n" + 
				"            \"characteristicRelationships\": [\r\n" + 
				"              {\r\n" + 
				"                \"name\": \"VALUE\",\r\n" + 
				"                \"value\": \"Premium\"\r\n" + 
				"              }\r\n" + 
				"            ]\r\n" + 
				"          },\r\n" + 
				"          {\r\n" + 
				"            \"name\": \"CUSTOM_INFO\",\r\n" + 
				"            \"value\": \"FAMILY_PLAN\",\r\n" + 
				"            \"characteristicRelationships\": [\r\n" + 
				"              {\r\n" + 
				"                \"name\": \"VALUE\",\r\n" + 
				"                \"value\": \"true\"\r\n" + 
				"              }\r\n" + 
				"            ]\r\n" + 
				"          }\r\n" + 
				"        ],\r\n" + 
				"        \"places\":[\r\n" + 
				"          {\r\n" + 
				"            \"name\":\"Main Address\",\r\n" + 
				"            \"address\":{\r\n" + 
				"              \"streetName\":\"Wedeking\",\r\n" + 
				"              \"streetNumber\":\"6045\",\r\n" + 
				"              \"streetSuffix\":\"Ave\",\r\n" + 
				"              \"postCode\":\"47715\",\r\n" + 
				"              \"city\":\"Evansville\",\r\n" + 
				"              \"stateOrProvince\":\"IN\",\r\n" + 
				"              \"country\":\"United States\"\r\n" + 
				"            }\r\n" + 
				"          }\r\n" + 
				"        ],\r\n" + 
				"        \"publicIdentifier\": \"HN-TEST_OTT_CUSTOMER_01_SKU_SUPPLIERTEST\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"orderRelationships\": [],\r\n" + 
				"  \"relatedParty\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": \"HN-TEST_OTT_CUSTOMER_01\",\r\n" + 
				"      \"source\": \"BSS\",\r\n" + 
				"      \"name\": \"Juan Perez\",\r\n" + 
				"      \"role\": \"CUSTOMER\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"extraValues\": []\r\n" + 
				"}";

		return json;
	}
	
	public String getRequestErr() {

		String json = "";

		return json;
	}

}
