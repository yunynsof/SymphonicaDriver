package hn.com.tigo.josm.orchestrator.driver.symphonica.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.soap.SOAPException;
import com.google.gson.Gson;
import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.HttpClientException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.orchestrator.driver.symphonica.AbstractDriver;
import hn.com.tigo.josm.orchestrator.driver.symphonica.model.LoginEventBrokerModel;
import hn.com.tigo.josm.orchestrator.driver.symphonica.model.ResponseEB;
import hn.com.tigo.josm.orchestrator.driver.symphonica.utils.SymphonicaConstantsDriver;


/**
 * EventBrokerNotificationOperation Class in charge of instantiating and carrying out the processes related to the EventBrokerNotification task.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 09:22:47 AM 2022
 */
public class EventBrokerNotificationOperation extends AbstractDriver<String> {

	/** Attribute that determine request. */
	private final String request;

	/**
	 * Instantiates a new event broker notification operation.
	 *
	 * @param request the request
	 */
	public EventBrokerNotificationOperation(final String request) {
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
			validateToken();
			ResponseEB responseEB = NotificationEB();

			parameterArray.getParameter()
					.add(buildNewParameter(SymphonicaConstantsDriver.HTTP_CODE, String.valueOf(responseEB.getCode())));
			parameterArray.getParameter()
					.add(buildNewParameter(SymphonicaConstantsDriver.JSON_RESPONSE, responseEB.getResponse()));

			responseDriver = createDriverToAdapterResponse(String.valueOf(SymphonicaConstantsDriver.CODE_SUCCESSFUL),
					SymphonicaConstantsDriver.TITLE_SUCCESSFUL, parameterArray);
		} catch (HttpClientException | SOAPException | KeyManagementException | NoSuchAlgorithmException
				| IOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.COMMUNICATION_ERROR, SymphonicaConstantsDriver.ERROR_MESSAGE);

		}
		validateResponse(responseDriver);
		return responseDriver;
	}

	/**
	 * Validate token.
	 *
	 * @throws AdapterException the adapter exception
	 * @throws SOAPException the SOAP exception
	 * @throws KeyManagementException the key management exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("static-access")
	public void validateToken()
			throws AdapterException, SOAPException, KeyManagementException, NoSuchAlgorithmException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		if (this.getGetLastExecEventBroker() == null) {

			getToken();
			LOGGER.info("Date of expiration expired: " + dateFormat.format(Calendar.getInstance().getTime()));
			LOGGER.info("Token created: " + this.getTokenEventBroker());
		} else {
			Date fechaActual = Calendar.getInstance().getTime();
			Calendar fechaUltima = Calendar.getInstance();
			fechaUltima.setTime(this.getGetLastExecEventBroker());
			fechaUltima.add(Calendar.SECOND, Integer.parseInt(String.valueOf(this.getExpTimeEventBroker())));
			LOGGER.info("Current date before validating renewal: " + dateFormat.format(fechaActual.getTime()));
			LOGGER.info("Date of last execution plus time of configuration file: "
					+ dateFormat.format(fechaUltima.getTime()));

			if (fechaActual.after(fechaUltima.getTime())) {

				getToken();
				LOGGER.info("Date of expiration expired: " + dateFormat.format(Calendar.getInstance().getTime()));
				LOGGER.info("Token created: " + this.getTokenEventBroker());
			}
		}
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyManagementException the key management exception
	 */
	@SuppressWarnings("static-access")
	private void getToken() throws IOException, NoSuchAlgorithmException, KeyManagementException {

		StringBuilder resultado = new StringBuilder();
		HttpsURLConnection conexion = connection(endpointEventBrokLogin);
		conexion.setRequestProperty(SymphonicaConstantsDriver.CONTENT_TYPE, SymphonicaConstantsDriver.CONTENT_TYPE_XML);

		String data = URLEncoder.encode(SymphonicaConstantsDriver.CLIENT_ID, "UTF-8") + "="
				+ URLEncoder.encode(clientId, "UTF-8");

		data += "&" + URLEncoder.encode(SymphonicaConstantsDriver.CLIENT_SECRET, "UTF-8") + "="
				+ URLEncoder.encode(clientSecret, "UTF-8");

		conexion.connect();

		OutputStreamWriter wr = new OutputStreamWriter(conexion.getOutputStream());
		wr.write(data);
		wr.flush();

		final int responseCode = conexion.getResponseCode();
		if (responseCode == HttpsURLConnection.HTTP_OK) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;
			while ((linea = rd.readLine()) != null) {
				resultado.append(linea);
			}
			rd.close();
			LoginEventBrokerModel loginEventBrokerModel = new LoginEventBrokerModel();
			Gson gson = new Gson();
			loginEventBrokerModel = gson.fromJson(resultado.toString(), LoginEventBrokerModel.class);
			LOGGER.info(resultado.toString());

			this.setExpTimeEventBroker(Long.valueOf(loginEventBrokerModel.getExpires_in()));
			this.setGetLastExecEventBroker(Calendar.getInstance().getTime());
			this.setTokenEventBroker(loginEventBrokerModel.getAccess_token());

		} else {
			BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getErrorStream()));
			String linea;

			while ((linea = rd.readLine()) != null) {
				resultado.append(linea);
			}
			rd.close();
			LOGGER.info(resultado.toString());
			this.setTokenEventBroker(null);
		}
	}

	/**
	 * Connection.
	 *
	 * @param endpoint the endpoint
	 * @return the https URL connection
	 * @throws MalformedURLException the malformed URL exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyManagementException the key management exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ProtocolException the protocol exception
	 */
	@SuppressWarnings("restriction")
	private HttpsURLConnection connection(String endpoint) throws MalformedURLException, NoSuchAlgorithmException,
			KeyManagementException, IOException, ProtocolException {
		SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		URL url = new URL(null, endpoint, new sun.net.www.protocol.https.Handler());
		SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
		sslContext.init(null, null, new SecureRandom());

		// SSLSocket socket = (SSLSocket) sslsocketfactory.createSocket();
		// String pickedCipher[] =
		// {"ECDHE-ECDSA-AES256-GCM-SHA384","ECDHE-ECDSA-AES128-SHA","ECDHE-ECDSA-AES256-SHA","ECDHE-ECDSA-AES128-SHA256","ECDHE-ECDSA-AES256-SHA384","ECDHE-RSA-AES128-GCM-SHA256","ECDHE-RSA-AES256-GCM-SHA384","ECDHE-RSA-AES128-SHA","ECDHE-RSA-AES256-SHA","ECDHE-RSA-AES128-SHA256","ECDHE-RSA-AES256-SHA384","DHE-RSA-AES128-GCM-SHA256","DHE-RSA-AES256-GCM-SHA384","DHE-RSA-AES128-SHA","DHE-RSA-AES256-SHA","DHE-RSA-AES128-SHA256","DHE-RSA-AES256-SHA256"};
		// socket.setEnabledCipherSuites(pickedCipher);
		HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
		conexion.setSSLSocketFactory(sslsocketfactory);
		conexion.setSSLSocketFactory(sslContext.getSocketFactory());
		conexion.setRequestMethod("POST");
		conexion.setDoOutput(true);
		return conexion;
	}

	/**
	 * Notification EB.
	 *
	 * @return the response EB
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyManagementException the key management exception
	 */
	@SuppressWarnings("static-access")
	private ResponseEB NotificationEB() throws IOException, NoSuchAlgorithmException, KeyManagementException {

		StringBuilder resultado = new StringBuilder();
		HttpsURLConnection conexion = connection(endpointEventBrokProv);
		conexion.setRequestProperty(SymphonicaConstantsDriver.CONTENT_TYPE,
				SymphonicaConstantsDriver.CONTENT_TYPE_JSON);
		conexion.setRequestProperty(SymphonicaConstantsDriver.AUTHORIZATION, "Bearer " + this.getTokenEventBroker());

		conexion.connect();

		OutputStreamWriter wr = new OutputStreamWriter(conexion.getOutputStream());
		wr.write(request);
		wr.flush();

		ResponseEB responseEB = new ResponseEB();
		final int responseCode = conexion.getResponseCode();
		responseEB.setCode(responseCode);
		if (responseCode == HttpsURLConnection.HTTP_OK) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;
			while ((linea = rd.readLine()) != null) {
				resultado.append(linea);
			}
			rd.close();
			LOGGER.info(resultado.toString());
			responseEB.setResponse(resultado.toString());
			return responseEB;

		} else {
			BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getErrorStream()));
			String linea;

			while ((linea = rd.readLine()) != null) {
				resultado.append(linea);
			}
			rd.close();
			LOGGER.info(resultado.toString());
			responseEB.setResponse(resultado.toString());
			return responseEB;
		}
	}

}
