package menu;

import entity.pet.Pet;
import requests.RequestsPets;
import requests.RequestsStore;
import requests.RequestsUser;
import requests.data.TestDataPet;
import requests.data.TestDataStore;
import requests.data.TestDataUser;

import java.io.IOException;
import java.util.Scanner;

public class ScannerClass {
    public Scanner scanner = new Scanner(System.in);

    public void mainMenu() throws IOException, InterruptedException {
        System.out.println("choose from: 1.Pets, 2.Store, 3.User");
        String next = scanner.next();
        switch (next) {
            case "1":
                petMenu();
                break;
            case "2":
                storeMenu();
                break;
            case "3":
                userMenu();
                break;
            default:
                System.out.println("unknown");
                mainMenu();
                break;
        }
    }

    public void userMenu() throws IOException, InterruptedException {
        RequestsUser requestsUser = new RequestsUser();
        TestDataUser testDataUser = new TestDataUser();
//        System.out.println(requestsUser.createUser(testDataUser.user1));
//        System.out.println(requestsUser.createUserArray(testDataUser.userArray).body());
//        System.out.println(requestsUser.createUserList(testDataUser.list).body());
//        System.out.println(requestsUser.getUserByUserName("string"));
//        System.out.println(requestsUser.updateUser(testDataUser.user5));
//        System.out.println(requestsUser.deleteUser("string"));
//        System.out.println(requestsUser.logsUser("testLogin", 12345));
//        System.out.println(requestsUser.logoutUser());

        System.out.println("1.CreateUser, 2.createUserArray, 3.CreateUserList, 4.GetUserByUserName, 5.updateUser, 6.deleteUser, 7.logsUser, 8.logoutUser, 9.Exit");
        String next = scanner.next();
        switch (next) {
            case "1":
                System.out.println(requestsUser.createUser(testDataUser.user1));
                userMenu();
                break;
            case "2":
                System.out.println(requestsUser.createUserArray(testDataUser.userArray));
                userMenu();
                break;
            case "3":
                System.out.println(requestsUser.createUserList(testDataUser.list));
                userMenu();
                break;
            case "4":
                System.out.println(requestsUser.getUserByUserName("string"));
                userMenu();
                break;
            case "5":
                System.out.println(requestsUser.updateUser(testDataUser.user5));
                userMenu();
                break;
            case "6":
                System.out.println(requestsUser.deleteUser("string"));
                userMenu();
                break;
            case "7":
                System.out.println(requestsUser.logsUser("testLogin", 12345));
                userMenu();
                break;
            case "8":
                System.out.println(requestsUser.logoutUser());
                userMenu();
                break;
            case "9":
                mainMenu();
                break;
        }
    }


    public void storeMenu() throws IOException, InterruptedException {
        RequestsStore requestsStore = new RequestsStore();
        TestDataStore testDataStore = new TestDataStore();
//        System.out.println(requestsStore.createOrderPets(testDataStore.store));
//        System.out.println(requestsStore.findOrderById(testDataStore.store));
//        System.out.println(requestsStore.deleteOrderById(testDataStore.store));
//        System.out.println(requestsStore.getInventory().body());

        System.out.println("1.createOrderPets, 2.findOrderById, 3.deleteOrderById, 4.getInventory, 5.Exit");
        String next = scanner.next();
        switch (next) {
            case "1":
                System.out.println(requestsStore.createOrderPets(testDataStore.store));
                storeMenu();
                break;
            case "2":
                System.out.println(requestsStore.findOrderById(testDataStore.store));
                storeMenu();;
                break;
            case "3":
                System.out.println(requestsStore.deleteOrderById(testDataStore.store));
                storeMenu();
                break;
            case "4":
                System.out.println(requestsStore.getInventory().body());
                storeMenu();
                break;
            case "5":
                mainMenu();
                break;
        }
    }

    public void petMenu() throws IOException, InterruptedException {
        RequestsPets requestsPets = new RequestsPets();
        TestDataPet testDataPet = new TestDataPet();
//        System.out.println(requestsPets.createPet(testDataPet.pet).body());
//        System.out.println(requestsPets.getPetById(10).body());
//        System.out.println(requestsPets.getPetByStatus(Pet.Status.available));
//        System.out.println(requestsPets.updatePet(testDataPet.pet2));
//        System.out.println("1231231" + requestsPets.updatePetStoreData(testDataPet.apiResponse));
        System.out.println("1.CreatePet, 2.GetPetById, 3.getPetByStatus, 4.updatePet, 5.updatePetStoreData, 6.Exit");
        String next = scanner.next();
        switch (next) {
            case "1":
                System.out.println(requestsPets.createPet(testDataPet.pet).body());
                petMenu();
                break;
            case "2":
                System.out.println(requestsPets.getPetById(10).body());
                petMenu();
                break;
            case "3":
                System.out.println(requestsPets.getPetByStatus(Pet.Status.available));
                petMenu();
                break;
            case "4":
                System.out.println(requestsPets.updatePet(testDataPet.pet2));
                petMenu();
                break;
            case "5":
                System.out.println(requestsPets.updatePetStoreData(testDataPet.apiResponse));
                petMenu();
                break;
            case "6":
                mainMenu();
                break;
        }
    }
}
