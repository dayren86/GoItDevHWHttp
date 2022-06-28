package requests;

import entity.pet.ApiResponse;
import entity.pet.Pet;
import requests.service.ServiceGson;
import requests.service.ServiceHttp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestsPets {

    private final static String URL = "https://petstore.swagger.io/v2/pet";

    public HttpResponse<String> createPet(Pet pet) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonPet(pet)))
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> getPetById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/" + id))
                .header("accept", "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> getPetByStatus(Pet.Status status) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/findByStatus?status=" + status))
                .header("accept", "application/json")
                .GET()
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> updatePet(Pet pet) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonPet(pet)))
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

    public HttpResponse<String> updatePetStoreData(ApiResponse apiResponse) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + "/" + apiResponse.getPetId()))
                .header("accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(new ServiceGson().toJsonApiResponse(apiResponse)))
                .build();

        return new ServiceHttp().serviceHttpClient(request);
    }

//TODO так и не рабобрался
//    public void updatePetUploadImage(ApiResponse apiResponse) throws IOException, InterruptedException {
//
//        Document post = Jsoup
//                .connect(URL + "/" + apiResponse.getPetId() + "/uploadImage")
//                .header("Content-Type", "multipart/form-data")
//                .data("file", "Screenshot_23.jpeg")
//                //.data("type", "image/jpeg")
//                .ignoreHttpErrors(true)
//                .post();
//
//
//
//        System.out.println(post.text());
//        HttpRequest request = HttpRequest
//                .newBuilder()
//                .uri(URI.create(URL+ "/" + apiResponse.getPetId() + "/uploadImage"))
//                .header("accept", "application/json")
//                .header("Content-Type", "multipart/form-data")
//                //.header("Content-Disposition", "form-data;additionalMetadata=thgj")
////                .header("Content-Disposition", " file="+ apiResponse.getFile() +";type=image/jpg")
//                .
//                .POST(HttpRequest.BodyPublishers.ofString("file=/src/Screenshot_23.jpeg;type=image/jpeg"))
//                .build();
//
//        HttpClient client = HttpClient.newBuilder().build();
//
//        return client.send(request, HttpResponse.BodyHandlers.ofFile());
//    }

}
