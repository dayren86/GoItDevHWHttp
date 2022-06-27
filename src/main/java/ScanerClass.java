import pets.RequestsPets;
import pets.data.TestDataPet;

import java.io.IOException;
import java.util.Scanner;

public class ScanerClass {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("choose from: 1.Pets, 2.Store, 3.User");
        String next = scanner.next();
        switch (next) {
            case "1":
                System.out.println("1.CreatePet, 2.GetPetById, 3.getPetByStatus, 4.updatePet, 5.updatePetStoreData");
                String next1 = scanner.next();
            case "2":

            case "3":
//            default:
//                System.out.println("unknown");
        }


    }
}
