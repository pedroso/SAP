package br.com.felipepedroso.consumidor;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 * 
 * Classe respons�vel por fazer a comunica��o HTTP com o Web Service
 * 
 * @author Douglas Costa <douglas.cst90@gmail.com.br>
 * @since 14/06/2013 17:20:17
 * @version 1.0
 */
public class HttpClientSingleton {

	private static final int JSON_CONNECTION_TIMEOUT = 3000;
	private static final int JSON_SOCKET_TIMEOUT = 5000;

	private static HttpClientSingleton instance;
	private HttpParams httpParameters;
	private DefaultHttpClient httpclient;

	private void setTimeOut(HttpParams params) {
		HttpConnectionParams.setConnectionTimeout(params,
				JSON_CONNECTION_TIMEOUT);

		HttpConnectionParams.setSoTimeout(params, JSON_SOCKET_TIMEOUT);
	}

	private HttpClientSingleton() {
		httpParameters = new BasicHttpParams();
		setTimeOut(httpParameters);
	}

	public static HttpClientSingleton getInstace() {
		if (instance == null)
			instance = new HttpClientSingleton();
		return instance;
	}

	public DefaultHttpClient getHttpClient() {
		httpclient = new DefaultHttpClient(httpParameters);
		return httpclient;
	}

}
