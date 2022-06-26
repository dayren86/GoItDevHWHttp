import entity.pet.ApiResponse;
import entity.pet.Category;
import entity.pet.Pet;
import entity.pet.Tag;
import pets.RequestsPets;
import pets.service.ServiceGson;
import pets.service.ServiceHttp;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class App {
    private final static String URL = "https://petstore.swagger.io/v2/pet";

    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("testPetPhotoUrl");

        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(1,"testTag"));

        Pet pet = new Pet(10,
                new Category(2, "testCategory"),
                "testPet",
                photoUrls,
                tags,
                Pet.Status.available);

        Pet pet2 = new Pet(10,
                new Category(2, "testCategorysssssssss"),
                "testPetssssssss",
                photoUrls,
                tags,
                Pet.Status.available);


        File file = new File("src/Screenshot_23.png");
        ApiResponse apiResponse = new ApiResponse(10, file.getAbsoluteFile());

        RequestsPets requestsPets = new RequestsPets();
//    System.out.println(requestsPets.createPet(pet).body());
//        System.out.println(requestsPets.getPetById(10).body());
//        System.out.println(requestsPets.getPetByStatus(Pet.Status.available));
//        System.out.println(requestsPets.updatePet(pet2));
//        System.out.println(requestsPets.getPetById(10).body());
        System.out.println(requestsPets.updatePetUploadImage(apiResponse));
    }

}

