package com.medelp.backend;

/**
 * API Keys, Client Ids and Audience Ids for accessing APIs and configuring
 * Cloud Endpoints.
 * When you deploy your solution, you need to use your own API Keys and IDs.
 * Please refer to the documentation for this sample for more details.
 */
public final class Constants {
    // User: Update keys

    /**
     * Google Cloud Messaging API key.
     */
    public static final String GCM_API_KEY = "YOUR-GCM-API-KEY";
    
    public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";

    /**
     * Android client ID from Google Cloud console.
     */
    public static final String ANDROID_CLIENT_ID = "812425071703-33caiunhihk607m8vfjpigp2kq3d0cg2.apps.googleusercontent.com";

    /**
     * iOS client ID from Google Cloud console.
     */
    public static final String IOS_CLIENT_ID = "897163707242-ihfd1clspg95t8f044e21op97aaimrdn.apps.googleusercontent.com";

    /**
     * Web client ID from Google Cloud console.
     */
    public static final String WEB_CLIENT_ID = "255790116154-nash7gcvb7lrpei5mcs6pnbmrchedn32.apps.googleusercontent.com";
    
    public static final String ANDROID_WEB_CLIENT_ID = "812425071703-f0ua6vp39alfqah2n69ggvn8j4isg5v2.apps.googleusercontent.com";

    /**
     * Audience ID used to limit access to some client to the API.
     */
    public static final String AUDIENCE_ID = WEB_CLIENT_ID;
    
    public static final String ANDROID_AUDIENCE_ID = ANDROID_WEB_CLIENT_ID;

    /**
     * API package name.
     */
    public static final String API_OWNER =
            "backend.medelp.com";

    /**
     * API package path.
     */
    public static final String API_PACKAGE_PATH = "";

    public static final String API_EXPLORER_CLIENT_ID = com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID;

    /**
     * Default constrictor, never called.
     */
    private Constants() { }
}