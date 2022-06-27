package pets;

import entity.store.Store;
import pets.service.ServiceGson;
import pets.service.ServiceHttp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestsStore {
    private static final String URL = "https://petstore.swagger.io/v2/store";

    public HttpResponse<String> createOrderPets(Store store) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/order"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonStore(store)))
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> findOrderById(Store store) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/order/" + store.getId()))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> deleteOrderById(Store store) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/order/" + store.getId()))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> getInventory() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/inventory"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }
}
