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

    public Store store = new Store(1,3, 455, "2022-06-26", Store.Status.placed, true);

    public HttpResponse<String> createOrderPets() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/order"))
                .header("accept", "application/json")
                .header("Content-Type",  "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonStore(store)))
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> findOrderById() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/order/" + store.getId()))
                .header("accept", "application/json")
                .header("Content-Type",  "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> deleteOrderById() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/order/" + store.getId()))
                .header("accept", "application/json")
                .header("Content-Type",  "application/json")
                .DELETE()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> getInventory() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/inventory"))
                .header("accept", "application/json")
                .header("Content-Type",  "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        RequestsStore requestsStore = new RequestsStore();
        System.out.println(requestsStore.createOrderPets());
        System.out.println(requestsStore.findOrderById());
        System.out.println(requestsStore.deleteOrderById());
        System.out.println(requestsStore.getInventory().body());
    }
}
