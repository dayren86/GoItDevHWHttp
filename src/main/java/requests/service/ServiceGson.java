package requests.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.pet.ApiResponse;
import entity.pet.Pet;
import entity.store.Store;
import entity.user.User;

import java.lang.reflect.Type;
import java.util.List;

public class ServiceGson {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String toJsonPet(Pet pet) {
        return gson.toJson(pet);
    }
    public String toJsonStore(Store store) {
        return gson.toJson(store);
    }
    public String toJsonUser(User user) {
        return gson.toJson(user);
    }
    public String stringJson(String s) {
        return gson.toJson(s);
    }
    public String toJsonApiResponse(ApiResponse apiResponse) {
        return gson.toJson(apiResponse);
    }

    public Pet fromJsonPet(String json) {
        Type typeToken = TypeToken.getParameterized(List.class, Pet.class).getType();
        return gson.fromJson(json, typeToken);
    }
}
