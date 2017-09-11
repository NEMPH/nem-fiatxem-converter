package io.nem.apps.endpoint.api;
import java.util.concurrent.CompletableFuture;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

/**
 * The Class NetworkUtils.
 */
public class NetworkUtils {
	private static AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
	public static CompletableFuture<Response> getAsync(EndPoints endpoint, String query) {
		return asyncHttpClient.prepareGet(endpoint + query).execute().toCompletableFuture();
	}

}
