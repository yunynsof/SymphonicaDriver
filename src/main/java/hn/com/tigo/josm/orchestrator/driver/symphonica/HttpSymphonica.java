package hn.com.tigo.josm.orchestrator.driver.symphonica;

import java.util.Map;

import hn.com.tigo.josm.common.http.Buildable;
import hn.com.tigo.josm.common.http.PoolingBuilder;
import hn.com.tigo.josm.common.http.PostMethod;

import javax.xml.soap.SOAPException;

/**
 * HttpSymphonica Class in charge of instantiating the Post http method, through the use of the common project.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:13:48 AM 2022
 */
public class HttpSymphonica extends PostMethod<String> {
	
	/** The Constant HTTP_RESPONSE_CODE_OK. */
	private static final String CONFIG_JSON = "Synphonica";

	/** Attribute that determine buildable. */
	private static Buildable buildable = PoolingBuilder.getInstance(CONFIG_JSON);
	
	/** Attribute that determine responseCode. */
	private int responseCode;
	

	/**
	 * Instantiates a new http symphonica.
	 *
	 * @param url the url
	 * @param properties the properties
	 * @throws SOAPException the SOAP exception
	 */
	public HttpSymphonica(final String url, final Map<String, String> properties) throws SOAPException {
		super(url, url, buildable, properties);
	}

	
	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.common.http.ServiceInvoker#getResponse(java.lang.String, int, java.lang.String)
	 */
	public String getResponse(final String response, final int responseCode, final String responseMessage){
		this.responseCode = responseCode;	
		return response;

	}


	/**
	 * Gets the response code.
	 *
	 * @return the response code
	 */
	public final int getResponseCode() {
		return responseCode;
	}

	
}
