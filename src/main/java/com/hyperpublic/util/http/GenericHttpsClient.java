package com.hyperpublic.util.http;

import com.hyperpublic.util.security.WebClientHttpsWrapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This is a generic HTTPS client that can be used to call a REST service.
 *
 * @author @peetersn
 */
public class GenericHttpsClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericHttpsClient.class);

    private static final int DEFAULT_CONN_TIMEOUT = 3000;
    private static final int SOCKET_TIMEOUT = 10000;

    public String call(String url) {

        String jsonResponse = null;

        HttpClient client = new DefaultHttpClient();
        HttpParams params = client.getParams();
        HttpConnectionParams.setConnectionTimeout(params, DEFAULT_CONN_TIMEOUT);
        HttpConnectionParams.setSoTimeout(params, SOCKET_TIMEOUT);

        client = WebClientHttpsWrapper.wrapClient(client);

        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse httpResponse = client.execute(httpGet);

            if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                LOGGER.warn("Method failed, invalid URL: {}", httpResponse.getStatusLine().getReasonPhrase());
            }

            if (httpResponse.getEntity() != null) {
                jsonResponse = readResponseAsStream(httpResponse.getEntity().getContent());
            }
        } catch (IOException e) {
            LOGGER.error("Fatal transport error: {}", e.getMessage(), e);
        } finally {
            client.getConnectionManager().shutdown();
        }

        return jsonResponse;
    }

    /**
     * Reads the inputstream as a buffered.
     *
     * @param is input stream (Response from the Google Service)
     * @return
     * @throws IOException
     */
    private String readResponseAsStream(InputStream is) throws IOException {
        StringBuilder sb = null;
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return sb.toString();
    }
}
