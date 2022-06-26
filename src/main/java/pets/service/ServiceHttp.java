package pets.service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServiceHttp {

    public HttpResponse<String> serviceHttpClient(HttpRequest request) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder().build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
