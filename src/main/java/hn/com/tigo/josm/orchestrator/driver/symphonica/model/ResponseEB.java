package hn.com.tigo.josm.orchestrator.driver.symphonica.model;


/**
 * ResponseEB Class in charge of instantiating an object type, necessary for the DADriver process.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:21:18 AM 2022
 */
public class ResponseEB {

	/** Attribute that determine code. */
	private int code;
	
	/** Attribute that determine response. */
	private String response;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(String response) {
		this.response = response;
	}

}
