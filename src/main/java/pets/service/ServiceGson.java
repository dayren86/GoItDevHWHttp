package pets.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.pet.ApiResponse;
import entity.pet.Pet;

import java.lang.reflect.Type;
import java.util.List;

public class ServiceGson {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String toJsonPet(Pet pet) {
        return gson.toJson(pet);
    }

    public Pet fromJsonPet(String json) {
        Type typeToken = TypeToken.getParameterized(List.class, Pet.class).getType();
        return gson.fromJson(json, typeToken);
    }

    public String toJsonApiResponse(ApiResponse apiResponse) {
        return gson.toJson(apiResponse);
    }
}
