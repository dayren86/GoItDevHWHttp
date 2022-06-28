package requests;

import entity.user.User;
import requests.service.ServiceGson;
import requests.service.ServiceHttp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RequestsUser {
    private static final String URL = "https://petstore.swagger.io/v2";

    public HttpResponse<String> createUser(User user) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/user"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonUser(user)))
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> createUserArray(User[] userArray) throws IOException, InterruptedException {
        HttpRequest request = null;
        for (int i = 0; i < userArray.length; i++) {
            request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(URL + "/user"))
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonUser(userArray[i])))
                    .build();
        }

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> createUserList(List<User> userList) throws IOException, InterruptedException {
        HttpRequest request = null;

        for (User user : userList) {
            request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(URL + "/user"))
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonUser(user)))
                    .build();
        }

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> getUserByUserName(String name) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/user/" + name))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> updateUser(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/user/" + user.getUserName()))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonUser(user)))
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> deleteUser(String name) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/user/" + name))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> logsUser(String login, int password) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/user/login?username=" + login + "&password=" + password))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> logoutUser() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/user/logout"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }
}
