package com.hyperpublic.domain;

/**
 * This is a value object that contains the auth tokens.
 * See this page to get your own: http://hyperpublic.com/registerapi
 *
 * @author @peetersn
 */
public class Auth {

    //Default API Keys == I used some of which I found on the website!
    public static final String DEFAULT_CLIENT_ID = "8UufhI6bCKQXKMBn7AUWO67Yq6C8RkfD0BGouTke";
    public static final String DEFAULT_CLIENT_SECRET = "zdoROY5XRN0clIWsEJyKzHedSK4irYee8jpnOXaP";

    public String userClientID;
    public String userClientSecret;

    public Auth(String userClientID, String userClientSecret) {
        this.userClientID = userClientID;
        this.userClientSecret = userClientSecret;
    }

    public String getUserClientSecret() {
        return userClientSecret;
    }

    public void setUserClientSecret(String userClientSecret) {
        this.userClientSecret = userClientSecret;
    }

    public String getUserClientID() {
        return userClientID;
    }

    public void setUserClientID(String userClientID) {
        this.userClientID = userClientID;
    }
}
