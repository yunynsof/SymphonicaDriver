package hn.com.tigo.josm.orchestrator.driver.symphonica;

import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;

import java.util.HashMap;
import java.util.Map;

import javax.xml.soap.SOAPException;

import org.apache.log4j.Logger;


/**
 * The Class SymphonicaDriver is a Driver Project which contains objects based on
 * service rest objects and is used to create an object to invoke.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 * @since 24/02/2022
 */
public class SymphonicaDriver{
	
	/** Attribute that determine a Constant of LOGGER. */
	private static final transient Logger LOGGER = Logger.getLogger(SymphonicaDriver.class);
	
	/** the httpSymLogin. */
	private HttpSymphonica httpSymLogin;
	
	/** the httpSymServiceProvLogin. */
	private HttpSymphonica httpSymServiceProvLogin;
	
	/** The nexusSymProv. */
	private String httpSymProv;
	
	/** Attribute that determine httpSymServiceProv. */
	private String httpSymServiceProv;
	
	/** Attribute that determine httpEventBrokProv. */
	private String endpointEventBrokProv;
	
	/** Attribute that determine endpointEventBrokLogin. */
	private String endpointEventBrokLogin;
		
	/** Attribute that determine client_id. */
	private String client_id;
	
	/** Attribute that determine client_secret. */
	private String client_secret;
	

	/**
	 * Instantiates a new symphonica driver.
	 *
	 * @param endpointSymLogin the endpoint sym login
	 * @param endpointSymProv the endpoint sym prov
	 * @param endpointSymServiceProv the endpoint sym service prov
	 * @param userName the user name
	 * @param password the password
	 * @param endpointEventBrokLogin the endpoint event brok login
	 * @param endpointEventBrokProv the endpoint event brok prov
	 * @param client_id the client id
	 * @param client_secret the client secret
	 * @throws AdapterException the adapter exception
	 */
	public SymphonicaDriver(final String endpointSymLogin, final String endpointSymProv, final String endpointSymServiceProv,
			final String userName, final String password, final String endpointEventBrokLogin, 
			final String endpointEventBrokProv, final String client_id, 
			final String client_secret) throws AdapterException {
		super();
		final Map<String, String> httpProperties = new HashMap<String, String>();
		httpProperties.put("Content-Type", "application/x-www-form-urlencoded");
		httpProperties.put("Accept-Language", "es-ES,es;q=0.9");
		httpProperties.put("Connection", "Keep-Alive");

		try {
			this.httpSymLogin = new HttpSymphonica(String.format(endpointSymLogin, userName, password), httpProperties);
			this.httpSymServiceProvLogin = new HttpSymphonica(String.format(endpointSymLogin, userName, password), httpProperties);
			this.httpSymProv = endpointSymProv;
			this.httpSymServiceProv = endpointSymServiceProv;
			this.endpointEventBrokProv = endpointEventBrokProv;
			this.endpointEventBrokLogin = endpointEventBrokLogin;
			this.client_id = client_id;
			this.client_secret = client_secret;
		} catch (SOAPException e) {
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR, e.getMessage(), e);
		}
	}

	/**
	 * Execute driver.
	 *
	 * @param abstractDriver
	 *            the abstract driver
	 * @return the task response type
	 * @throws AdapterException
	 *             the adapter exception
	 */
	public TaskResponseType executeDriver(final AbstractDriver<?> abstractDriver) throws AdapterException {
		abstractDriver.setHttpSymLogin(httpSymLogin);
		abstractDriver.setHttpSymServiceProvLogin(httpSymServiceProvLogin);
		abstractDriver.setEndpointProv(httpSymProv);
		abstractDriver.setEndponintServiceProv(httpSymServiceProv);
		abstractDriver.setEndpointEventBrokProv(endpointEventBrokProv);
		abstractDriver.setEndpointEventBrokLogin(endpointEventBrokLogin);
		abstractDriver.setClientId(client_id);
		abstractDriver.setClientSecret(client_secret);
		return abstractDriver.execute();
	}
	
}
