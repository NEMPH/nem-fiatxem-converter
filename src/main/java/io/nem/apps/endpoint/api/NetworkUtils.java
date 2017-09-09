package io.nem.apps.endpoint.api;
import java.util.concurrent.CompletableFuture;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

/**
 * The Class NetworkUtils.
 */
public class NetworkUtils {

	public static CompletableFuture<Response> getAsync(EndPoints endpoint, String query) {
		AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
		return asyncHttpClient.prepareGet(endpoint + query).execute().toCompletableFuture();
	}

}
