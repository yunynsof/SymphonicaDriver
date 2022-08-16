package hn.com.tigo.josm.orchestrator.driver.symphonica.test;

import javax.ejb.embeddable.EJBContainer;

import org.apache.log4j.Logger;

import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.orchestrator.driver.symphonica.SymphonicaDriver;


public class AbstractTest {

	/** Attribute that determine container. */
	protected static EJBContainer container;

	/** Attribute that determine driver. */
	protected static SymphonicaDriver driver;

	/** Attribute that determine a Constant of LOGGER. */
	protected static final transient Logger LOGGER = Logger.getLogger(AbstractTest.class);
	
	/** Attribute that determine endpoint. */
	final String ip = "http://192.168.159.46:7004/ApisDA/da/";
	
	final String endpointSymLogin = "https://hn.qasymphonica.tigo.com/sso_rest/authentication/login?username=%s&password=%s";
	final String endpointSymProv = "https://hn.qasymphonica.tigo.com:443/workflow-order-manager/api/workflow-orders";
	final String endpointSymServiceProv = "https://hn.qasymphonica.tigo.com/service-order-manager/api/service-orders";
	final String userName = "tigohnapi";
	final String password = "4zjuDE33";
	
	final String endpointEventBrokLogin = "https://qa.api.tigo.com/oauth/client_credential/accesstoken?grant_type=client_credentials";
	final String endpointEventBrokProv = "https://qa.api.tigo.com/v1/tigo/eventbroker/events";
	final String client_id = "kGsJphMTFZDFrj50uZgqqxN9oYYYcVnp";
	final String client_secret = "S7zRsRqAAwphLX8x";
	

	/**
	 * Instantiates a new abstract test.
	 *
	 * @throws AdapterException the adapter exception
	 */
	public AbstractTest() throws AdapterException {
		container = EjbContainerContext.INSTANCE.getContainer();
		driver = new SymphonicaDriver(endpointSymLogin,endpointSymProv,endpointSymServiceProv,userName,password, 
				endpointEventBrokLogin, endpointEventBrokProv, client_id, client_secret);
	}

}
