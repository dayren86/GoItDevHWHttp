package pets.data;

import entity.pet.ApiResponse;
import entity.pet.Category;
import entity.pet.Pet;
import entity.pet.Tag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestDataPet {
    List<String> photoUrls;
    List<Tag> tags;

    public TestDataPet() {
        photoUrls = new ArrayList<>();
        photoUrls.add("testPetPhotoUrl");

        tags = new ArrayList<>();
        tags.add(new Tag(1,"testTag"));
    }

    public Pet pet = new Pet(10,
            new Category(2, "testCategory"),
            "testPet",
            photoUrls,
            tags,
            Pet.Status.available);

    public Pet pet2 = new Pet(10,
            new Category(2, "testCategorysssssssss"),
            "testPetssssssss",
            photoUrls,
            tags,
            Pet.Status.available);

    File file = new File("src/Screenshot_23.jpg");
    public ApiResponse apiResponse = new ApiResponse(1, "fsdf", "dsffsd");
}
