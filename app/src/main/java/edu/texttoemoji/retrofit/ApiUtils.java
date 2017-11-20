package edu.texttoemoji.retrofit;

/**
 * Created by Ankit on 02/11/17.
 */
public class ApiUtils {

    public static final String BASE_URL = "https://raw.githubusercontent.com";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
