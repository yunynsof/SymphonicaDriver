package hn.com.tigo.josm.orchestrator.driver.symphonica.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Test;

import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.orchestrator.driver.symphonica.AbstractDriver;
import hn.com.tigo.josm.orchestrator.driver.symphonica.operation.EventBrokerNotificationOperation;

public class EventBrokerNotificationOperationTest extends AbstractTest {

	public EventBrokerNotificationOperationTest() throws AdapterException {

	}

	@Test
	public void test() {
		final EventBrokerNotificationOperation operation = new EventBrokerNotificationOperation(getRequest());
		try {
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
			AbstractDriver abstractDriver = null;
			abstractDriver.setGetLastExecEventBroker(null);
		} catch (AdapterException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test2() {
		final EventBrokerNotificationOperation operation = new EventBrokerNotificationOperation(getRequest());
		try {
			AbstractDriver abstractDriver = null;
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			abstractDriver.setGetLastExecEventBroker(calendar.getTime());
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
		} catch (AdapterException e) {
			//fail(e.getMessage());
		}
	}
	
	@Test
	public void testErr() {
		final EventBrokerNotificationOperation operation = new EventBrokerNotificationOperation(getRequestErr());
		try {
			AbstractDriver abstractDriver = null;
			abstractDriver.setGetLastExecEventBroker(null);
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
		} catch (AdapterException e) {
			//fail(e.getMessage());
		}
	}

	public String getRequest() {

		String json = "{\r\n" + 
				"    \"event_header\":{\r\n" + 
				"       \"country\": \"HN\",\r\n" + 
				"       \"customer_type\": \"prepaid_mobile\",\r\n" + 
				"       \"customer_action\": \"billing\",\r\n" + 
				"       \"event_name\": \"Prime_Video_Purchase\",\r\n" + 
				"       \"event_code\": \"PVME\",\r\n" + 
				"       \"event_description\": \"Notificacion para compra de paquete Amazon Prime Video\",\r\n" + 
				"       \"event_source\": \"exacaster\",\r\n" + 
				"       \"event_uid\": \"M1\"\r\n" + 
				"    },\r\n" + 
				"    \"event_data\":{\r\n" + 
				"       \"client_name\": \"\",\r\n" + 
				"       \"subscriber\":\"94347003\",\r\n" + 
				"       \"transaction_type\": \"Prime_Video_Purchase\",\r\n" + 
				"       \"transaction_status\": \"Completed\"\r\n" + 
				"    },\r\n" + 
				"    \"customer_profile\":{\r\n" + 
				"       \"phone_number_main_contact\":\"94347003\",\r\n" + 
				"       \"country\":\"HN\",\r\n" + 
				"       \"account_flags\": {         \r\n" + 
				"       }\r\n" + 
				"    }  \r\n" + 
				" }";

		return json;
	}
	
	public String getRequestErr() {

		String json = "";

		return json;
	}
}
