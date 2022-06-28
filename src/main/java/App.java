import menu.ScannerClass;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        ScannerClass scannerClass = new ScannerClass();
        scannerClass.mainMenu();

//        RequestsPets requestsPets = new RequestsPets();
//        TestDataPet testDataPet = new TestDataPet();
//        System.out.println(requestsPets.createPet(testDataPet.pet).body());
//        System.out.println(requestsPets.getPetById(10).body());
//        System.out.println(requestsPets.getPetByStatus(Pet.Status.available));
//        System.out.println(requestsPets.updatePet(testDataPet.pet2));
//        System.out.println(requestsPets.getPetById(10).body());
//        System.out.println("1231231" + requestsPets.updatePetStoreData(testDataPet.apiResponse));
////        requestsPets.updatePetUploadImage(apiResponse);
//
//        RequestsStore requestsStore = new RequestsStore();
//        TestDataStore testDataStore = new TestDataStore();
//        System.out.println(requestsStore.createOrderPets(testDataStore.store));
//        System.out.println(requestsStore.findOrderById(testDataStore.store));
//        System.out.println(requestsStore.deleteOrderById(testDataStore.store));
//        System.out.println(requestsStore.getInventory().body());
//
//        RequestsUser requestsUser = new RequestsUser();
//        TestDataUser testDataUser = new TestDataUser();
//        System.out.println(requestsUser.createUser(testDataUser.user1));
//        System.out.println(requestsUser.createUserArray(testDataUser.userArray).body());
//        System.out.println(requestsUser.createUserList(testDataUser.list).body());
//        System.out.println(requestsUser.getUserByUserName("string"));
//        System.out.println(requestsUser.updateUser(testDataUser.user5));
//        System.out.println(requestsUser.deleteUser("string"));
//        System.out.println(requestsUser.logsUser("testLogin", 12345));
//        System.out.println(requestsUser.logoutUser());
    }

}

