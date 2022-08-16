package hn.com.tigo.josm.orchestrator.driver.symphonica.model;

import java.util.List;

/**
 * LoginEventBrokerModel Class in charge of instantiating an object type, necessary for the DADriver process.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:20:59 AM 2022
 */
public class LoginEventBrokerModel {

	/** Attribute that determine refresh_token_expires_in. */
	private String refresh_token_expires_in;

	/** Attribute that determine api_product_list. */
	private String api_product_list;

	/** Attribute that determine api_product_list_json. */
	private List<String> api_product_list_json;

	/** Attribute that determine organization_name. */
	private String organization_name;

	/** Attribute that determine developerEmail. */
	private String developerEmail;

	/** Attribute that determine token_type. */
	private String token_type;

	/** Attribute that determine issued_at. */
	private String issued_at;

	/** Attribute that determine client_id. */
	private String client_id;

	/** Attribute that determine access_token. */
	private String access_token;

	/** Attribute that determine application_name. */
	private String application_name;

	/** Attribute that determine scope. */
	private String scope;

	/** Attribute that determine expires_in. */
	private String expires_in;

	/** Attribute that determine refresh_count. */
	private String refresh_count;

	/** Attribute that determine email. */
	private String email;

	/** Attribute that determine status. */
	private String status;

	/**
	 * Sets the refresh token expires in.
	 *
	 * @param refresh_token_expires_in the new refresh token expires in
	 */
	public void setRefresh_token_expires_in(String refresh_token_expires_in) {
		this.refresh_token_expires_in = refresh_token_expires_in;
	}

	/**
	 * Gets the refresh token expires in.
	 *
	 * @return the refresh token expires in
	 */
	public String getRefresh_token_expires_in() {
		return this.refresh_token_expires_in;
	}

	/**
	 * Sets the api product list.
	 *
	 * @param api_product_list the new api product list
	 */
	public void setApi_product_list(String api_product_list) {
		this.api_product_list = api_product_list;
	}

	/**
	 * Gets the api product list.
	 *
	 * @return the api product list
	 */
	public String getApi_product_list() {
		return this.api_product_list;
	}

	/**
	 * Sets the api product list json.
	 *
	 * @param api_product_list_json the new api product list json
	 */
	public void setApi_product_list_json(List<String> api_product_list_json) {
		this.api_product_list_json = api_product_list_json;
	}

	/**
	 * Gets the api product list json.
	 *
	 * @return the api product list json
	 */
	public List<String> getApi_product_list_json() {
		return this.api_product_list_json;
	}

	/**
	 * Sets the organization name.
	 *
	 * @param organization_name the new organization name
	 */
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	/**
	 * Gets the organization name.
	 *
	 * @return the organization name
	 */
	public String getOrganization_name() {
		return this.organization_name;
	}

	/**
	 * Sets the developer email.
	 *
	 * @param developerEmail the new developer email
	 */
	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}

	/**
	 * Gets the developer email.
	 *
	 * @return the developer email
	 */
	public String getDeveloperEmail() {
		return this.developerEmail;
	}

	/**
	 * Sets the token type.
	 *
	 * @param token_type the new token type
	 */
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	/**
	 * Gets the token type.
	 *
	 * @return the token type
	 */
	public String getToken_type() {
		return this.token_type;
	}

	/**
	 * Sets the issued at.
	 *
	 * @param issued_at the new issued at
	 */
	public void setIssued_at(String issued_at) {
		this.issued_at = issued_at;
	}

	/**
	 * Gets the issued at.
	 *
	 * @return the issued at
	 */
	public String getIssued_at() {
		return this.issued_at;
	}

	/**
	 * Sets the client id.
	 *
	 * @param client_id the new client id
	 */
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	/**
	 * Gets the client id.
	 *
	 * @return the client id
	 */
	public String getClient_id() {
		return this.client_id;
	}

	/**
	 * Sets the access token.
	 *
	 * @param access_token the new access token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * Gets the access token.
	 *
	 * @return the access token
	 */
	public String getAccess_token() {
		return this.access_token;
	}

	/**
	 * Sets the application name.
	 *
	 * @param application_name the new application name
	 */
	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}

	/**
	 * Gets the application name.
	 *
	 * @return the application name
	 */
	public String getApplication_name() {
		return this.application_name;
	}

	/**
	 * Sets the scope.
	 *
	 * @param scope the new scope
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * Gets the scope.
	 *
	 * @return the scope
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * Sets the expires in.
	 *
	 * @param expires_in the new expires in
	 */
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * Gets the expires in.
	 *
	 * @return the expires in
	 */
	public String getExpires_in() {
		return this.expires_in;
	}

	/**
	 * Sets the refresh count.
	 *
	 * @param refresh_count the new refresh count
	 */
	public void setRefresh_count(String refresh_count) {
		this.refresh_count = refresh_count;
	}

	/**
	 * Gets the refresh count.
	 *
	 * @return the refresh count
	 */
	public String getRefresh_count() {
		return this.refresh_count;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}
}
