package hn.com.tigo.josm.orchestrator.driver.symphonica;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.ParameterType;
import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.cache.ObjectFactoryCache;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;

/**
 * AbstractDriver This abstract class contains properties and features for DADriver.
 *
 * @author Leonardo Vijil {@literal<mailto:lvijil@hngsystems.com />}
 * @version 1.0.0
 * @since 16/10/2019
 */
public abstract class AbstractDriver<T> {

	/** The Constant LOGGER. */
	protected static final transient Logger LOGGER = Logger.getLogger(AbstractDriver.class);


	/** The object factory cache. */
	protected static ObjectFactoryCache objectFactoryCache = ObjectFactoryCache.getInstance();
	
	/** The httpSymLogin. */
	protected HttpSymphonica httpSymLogin;
	
	/** The httpSymLogin. */
	protected HttpSymphonica httpSymServiceProvLogin;
	
	/** The nexusSymProv. */
	protected static HttpSymphonica httpSymProv;
	
	/** Attribute that determine httpSymServiceProv. */
	protected static HttpSymphonica httpSymServiceProv;
	
	/** Attribute that determine httpEventBrokProv. */
	protected static HttpSymphonica httpEventBrokProv;
	
	/** Attribute that determine endpointProv. */
	protected String endpointProv;
	
	/** Attribute that determine endponintServiceProv. */
	protected String endponintServiceProv;

	/** Attribute that determine endpointEventBrokProv. */
	protected String endpointEventBrokProv;
	
	/** Attribute that determine endpointEventBrokLogin. */
	protected String endpointEventBrokLogin;

	/** Attribute that determine taskType. */
	protected TaskRequestType taskType;

	/** Attribute that determine properties. */
	private Map<String, String> properties;
	
	/** Attribute that determine getLastExec. */
	private static Date getLastExec;
	
	/** Attribute that determine expTime. */
	private static long expTime;
	
    /** Attribute that determine getLastExecEventBroker. */
    private static Date getLastExecEventBroker;
	
	/** Attribute that determine expTimeEventBroker. */
	private static long expTimeEventBroker;
	
	/** Attribute that determine tokenEventBroker. */
	private static String tokenEventBroker;
	
	/** Attribute that determine tokenServiceOrder. */
	protected static String tokenServiceOrder;
	
	/** Attribute that determine clientId. */
	protected String clientId;
	
	/** Attribute that determine clientSecret. */
	protected String clientSecret;

	/**
	 * Instantiates a new abstract driver.
	 */
	public AbstractDriver() {
		this.properties = new HashMap<>();
		properties.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
	}
	


	/**
	 * Validate service response.
	 *
	 * @param responseDriver            the response driver
	 * @return the task response type
	 * @throws AdapterException             the adapter exception
	 */
	protected TaskResponseType validateResponse(final TaskResponseType responseDriver) throws AdapterException {
		if (responseDriver.getResponseCode() != 0) {
			LOGGER.error(responseDriver.getResponseDescription());
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR, responseDriver.getResponseDescription(),
					String.valueOf(responseDriver.getResponseCode()), null);
		}

		return responseDriver;
	}

	/**
	 * Creates the response.
	 *
	 * @param responseCode
	 *            the response code
	 * @param responseDescription
	 *            the response description
	 * @param param
	 *            the param
	 * @return the task response type
	 */
	protected TaskResponseType createDriverToAdapterResponse(final String responseCode,
			final String responseDescription, final ParameterArray param) {
		final TaskResponseType response = new TaskResponseType();
		response.setResponseCode(Integer.parseInt(responseCode));
		response.setResponseDescription(responseDescription);
		response.setParameters(param);
		return response;
	}



	/**
	 * Builds the new parameter for the ParameterArray class.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @return the parameter type
	 */
	protected ParameterType buildNewParameter(final String name, final String value) {
		final ParameterType parameter = new ParameterType();
		parameter.setName(name);
		parameter.setValue(value);
		return parameter;
	}

	/**
	 * Method that allows to execute a specific driver.
	 *
	 * @return the task response type
	 * @throws AdapterException
	 *             the adapter exception
	 */
	public abstract TaskResponseType execute() throws AdapterException;



	/**
	 * Sets the http sym login.
	 *
	 * @param httpSymLogin the new http sym login
	 */
	public final void setHttpSymLogin(HttpSymphonica httpSymLogin) {
		this.httpSymLogin = httpSymLogin;
	}

	

/**
	 * Sets the http sym service prov login.
	 *
	 * @param httpSymServiceProvLogin the new http sym service prov login
	 */
		public final void setHttpSymServiceProvLogin(HttpSymphonica httpSymServiceProvLogin) {
		this.httpSymServiceProvLogin = httpSymServiceProvLogin;
	}


	/**
	 * Gets the gets the last exec.
	 *
	 * @return the gets the last exec
	 */
	public static Date getGetLastExec() {
		return getLastExec;
	}


	/**
	 * Sets the gets the last exec.
	 *
	 * @param getLastExec the new gets the last exec
	 */
	public static void setGetLastExec(Date getLastExec) {
		AbstractDriver.getLastExec = getLastExec;
	}


	/**
	 * Gets the exp time.
	 *
	 * @return the exp time
	 */
	public static long getExpTime() {
		return expTime;
	}


	/**
	 * Sets the exp time.
	 *
	 * @param expTime the new exp time
	 */
	public static void setExpTime(long expTime) {
		AbstractDriver.expTime = expTime;
	}


	/**
	 * Gets the endpoint prov.
	 *
	 * @return the endpoint prov
	 */
	public final String getEndpointProv() {
		return endpointProv;
	}


	/**
	 * Sets the endpoint prov.
	 *
	 * @param endpointProv the new endpoint prov
	 */
	public final void setEndpointProv(String endpointProv) {
		this.endpointProv = endpointProv;
	}



	/**
	 * Sets the endpoint event brok prov.
	 *
	 * @param endpointEventBrokProv the new endpoint event brok prov
	 */
	public void setEndpointEventBrokProv(String endpointEventBrokProv) {
		this.endpointEventBrokProv = endpointEventBrokProv;
	}


	/**
	 * Gets the gets the last exec event broker.
	 *
	 * @return the gets the last exec event broker
	 */
	public static Date getGetLastExecEventBroker() {
		return getLastExecEventBroker;
	}


	/**
	 * Sets the gets the last exec event broker.
	 *
	 * @param getLastExecEventBroker the new gets the last exec event broker
	 */
	public static void setGetLastExecEventBroker(Date getLastExecEventBroker) {
		AbstractDriver.getLastExecEventBroker = getLastExecEventBroker;
	}


	/**
	 * Gets the exp time event broker.
	 *
	 * @return the exp time event broker
	 */
	public static long getExpTimeEventBroker() {
		return expTimeEventBroker;
	}


	/**
	 * Sets the exp time event broker.
	 *
	 * @param expTimeEventBroker the new exp time event broker
	 */
	public static void setExpTimeEventBroker(long expTimeEventBroker) {
		AbstractDriver.expTimeEventBroker = expTimeEventBroker;
	}


	/**
	 * Sets the client id.
	 *
	 * @param clientId the new client id
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	/**
	 * Gets the client secret.
	 *
	 * @return the client secret
	 */
	public String getClientSecret() {
		return clientSecret;
	}


	/**
	 * Sets the client secret.
	 *
	 * @param clientSecret the new client secret
	 */
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}


	/**
	 * Sets the endpoint event brok login.
	 *
	 * @param endpointEventBrokLogin the new endpoint event brok login
	 */
	public void setEndpointEventBrokLogin(String endpointEventBrokLogin) {
		this.endpointEventBrokLogin = endpointEventBrokLogin;
	}


    /**
	 * Gets the token event broker.
	 *
	 * @return the token event broker
	 */
		public static String getTokenEventBroker() {
		return tokenEventBroker;
	}


/**
	 * Sets the token event broker.
	 *
	 * @param tokenEventBroker the new token event broker
	 */
		public static void setTokenEventBroker(String tokenEventBroker) {
		AbstractDriver.tokenEventBroker = tokenEventBroker;
	}
	
/**
	 * Gets the endponint service prov.
	 *
	 * @return the endponint service prov
	 */
		public String getEndponintServiceProv() {
		return endponintServiceProv;
	}


/**
	 * Sets the endponint service prov.
	 *
	 * @param endponintServiceProv the new endponint service prov
	 */
		public void setEndponintServiceProv(String endponintServiceProv) {
		this.endponintServiceProv = endponintServiceProv;
	}	
}
