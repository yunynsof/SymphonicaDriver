package hn.com.tigo.josm.orchestrator.driver.symphonica.operation;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.xml.soap.SOAPException;
import com.google.gson.Gson;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.HttpClientException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.orchestrator.driver.symphonica.AbstractDriver;
import hn.com.tigo.josm.orchestrator.driver.symphonica.HttpSymphonica;
import hn.com.tigo.josm.orchestrator.driver.symphonica.model.LoginModel;
import hn.com.tigo.josm.orchestrator.driver.symphonica.utils.SymphonicaConstantsDriver;

/**
 * SymphonicaServiceOrderTaskOperation Class in charge of instantiating and carrying out the processes related to the SymphonicaServiceOrder task.
 *
 * @author Laurent G Cáceres
 * @version 1.0.0
 * @since 08-05-2022 07:58:32 AM 2022
 */
public class SymphonicaServiceOrderTaskOperation extends AbstractDriver<String> {

	/** Attribute that determine request. */
	private final String request;

	/**
	 * Instantiates a new symphonica service order task operation.
	 *
	 * @param request the request
	 */
	public SymphonicaServiceOrderTaskOperation(final String request) {
		this.request = request;
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.orchestrator.driver.symphonica.AbstractDriver#execute()
	 */
	@Override
	public TaskResponseType execute() throws AdapterException {
		TaskResponseType responseDriver = null;
		final ParameterArray parameterArray = new ParameterArray();
		try {
			validSession();
			LOGGER.info(request);
			String result = httpSymServiceProv.invoke(request, StandardCharsets.UTF_8);
			boolean retry = false;

			if (result.contains("Access Denied")) {
				Calendar current = Calendar.getInstance();
				current.add(Calendar.MINUTE, -1);
				this.setGetLastExec(current.getTime());
				validSession();
				retry = true;
			}
			if (retry) {
				result = httpSymServiceProv.invoke(request, StandardCharsets.UTF_8);
			}
			parameterArray.getParameter().add(buildNewParameter(SymphonicaConstantsDriver.HTTP_CODE,
					String.valueOf(httpSymServiceProv.getResponseCode())));
			parameterArray.getParameter().add(buildNewParameter(SymphonicaConstantsDriver.JSON_RESPONSE, result));
			responseDriver = createDriverToAdapterResponse(String.valueOf(SymphonicaConstantsDriver.CODE_SUCCESSFUL),
					SymphonicaConstantsDriver.TITLE_SUCCESSFUL, parameterArray);
		} catch (HttpClientException | SOAPException e) {
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.COMMUNICATION_ERROR, SymphonicaConstantsDriver.ERROR_MESSAGE);

		}
		validateResponse(responseDriver);
		return responseDriver;
	}

	/**
	 * Valid session.
	 *
	 * @throws AdapterException the adapter exception
	 * @throws SOAPException the SOAP exception
	 */
	@SuppressWarnings("static-access")
	public void validSession() throws AdapterException, SOAPException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		if (this.getGetLastExec() == null) {
			LOGGER.info("Date of creation by null value: " + dateFormat.format(Calendar.getInstance().getTime()));
			tokenServiceOrder = getSessionLGI();
			getHttpServProv();
			LOGGER.info("Session created with Session Id: " + tokenServiceOrder);

		} else {
			Date fechaActual = Calendar.getInstance().getTime();
			Calendar fechaUltima = Calendar.getInstance();
			fechaUltima.setTime(this.getGetLastExec());
			fechaUltima.add(Calendar.SECOND, Integer.parseInt(String.valueOf(this.getExpTime())));
			LOGGER.info("Current date before validating renewal: " + dateFormat.format(fechaActual.getTime()));
			LOGGER.info("Date of last execution plus time of configuration file: "
					+ dateFormat.format(fechaUltima.getTime()));

			if (fechaActual.after(fechaUltima.getTime())) {
				tokenServiceOrder = getSessionLGI();
				getHttpServProv();
				httpSymProv = null;
				LOGGER.info("Date of expiration expired: " + dateFormat.format(Calendar.getInstance().getTime()));
				LOGGER.info("Session created with Session Id: " + tokenServiceOrder);
			} else if (httpSymServiceProv == null) {
				getHttpServProv();
			}
		}
	}

	/**
	 * Gets the http serv prov.
	 *
	 * @return the http serv prov
	 * @throws SOAPException the SOAP exception
	 */
	private void getHttpServProv() throws SOAPException {
		final Map<String, String> httpPropertiesServProv = new HashMap<String, String>();
		httpPropertiesServProv.put("Content-Type", "application/iway-service-order-post-v1-hal+json");
		httpPropertiesServProv.put("X-Organization-Code", "TIGOHN");
		httpPropertiesServProv.put("X-Authorization", tokenServiceOrder);
		httpPropertiesServProv.put("X-Language", "en");
		httpSymServiceProv = new HttpSymphonica(this.getEndponintServiceProv(), httpPropertiesServProv);
	}

	/**
	 * Gets the session LGI.
	 *
	 * @return the session LGI
	 * @throws AdapterException the adapter exception
	 */
	@SuppressWarnings("static-access")
	private String getSessionLGI() throws AdapterException {
		try {
			String soap = httpSymServiceProvLogin.invoke("", StandardCharsets.UTF_8);
			LoginModel json = new Gson().fromJson(soap, LoginModel.class);

			if (soap == null) {
				return null;
			} else {

				this.setExpTime(Long.valueOf(json.getEmbedded().getSession().getTtl()));
				this.setGetLastExec(Calendar.getInstance().getTime());
				return json.getEmbedded().getSession().getToken();
			}
		} catch (Exception e) {
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR, e.getMessage());
		}
	}

}
