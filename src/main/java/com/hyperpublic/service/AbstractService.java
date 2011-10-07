package com.hyperpublic.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author npeeters
 */
public abstract class AbstractService {

          /**
     * Reads the inputstream as a buffered.
     *
     * @param is input stream (Response from the Google Service)
     * @return
     * @throws java.io.IOException
     */
    protected String readResponseAsStream(InputStream is) throws IOException {
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
