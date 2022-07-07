
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final String SCHEME = "https";
        final String HOST = "api.weather.yandex.ru";
        final String APIVERSION = "v2";
        final String SERVICE = "forecast";
        final String LAT = "59.936711";
        final String LON = "30.322501";
        final String LANGUAGE = "en_US";
        final String LIMIT = "5"; // 5 days
        final String YANDEXKEY = "X-Yandex-API-Key";
        final String YANDEXKEYVALUE = "154d97f0-613d-4497-b9d9-02259cb4980b"; // api key

        HttpUrl url = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(APIVERSION)
                .addPathSegment(SERVICE)
                .addQueryParameter("lat", LAT)
                .addQueryParameter("lon", LON)
                .addQueryParameter("lang", LANGUAGE)
                .addQueryParameter("limit", LIMIT)
                .build();

        System.out.println(url);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .addHeader(YANDEXKEY, YANDEXKEYVALUE)
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(LIMIT + " days forecast is: " + response.body().string());

    }
}