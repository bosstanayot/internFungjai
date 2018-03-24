package fungjai.intern.bosstanayot.internfungjaiapp.serviceTest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by barjord on 23/3/2018 AD.
 */

public class RestServiceTestHelper {
    public static <T> T createRetrofitService(String host, Class<T> classTarget) throws Exception {

        OkHttpClient client = new OkHttpClient.Builder().build();
        return new Retrofit
                .Builder()
                .client(client)
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(classTarget);

    }
}
