package pets;

import entity.user.User;
import pets.service.ServiceGson;
import pets.service.ServiceHttp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RequestsUser {
    private static final String URL = "https://petstore.swagger.io/v2";

    User user1 = new User(1, "userTest1", "firstNameTest1", "lastNameTest1", "test1@test.com", "sdffas1", "2342234", 1);
    User user2 = new User(2, "userTest2", "firstNameTest2", "lastNameTest2", "test2@test.com", "sdffas2", "2342234", 2);
    User user3 = new User(3, "userTest3", "firstNameTest3", "lastNameTest3", "test3@test.com", "sdffas3", "2342234", 3);

    User[] userArray = {user1, user2, user3};
    //List<User> listUser = new ArrayList<>().add(user1);

    public HttpResponse<String> createUser() throws IOException, InterruptedException {
        
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/user"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonUser(user1)))
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> createUserArray() throws IOException, InterruptedException {
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


    public static void main(String[] args) throws IOException, InterruptedException {
        RequestsUser requestsUser = new RequestsUser();
        System.out.println(requestsUser.createUser());
        System.out.println(requestsUser.createUserArray().body());

    }


}
