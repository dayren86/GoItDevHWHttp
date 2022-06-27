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
                System.out.println("fdssdfa");
                String next1 = scanner.next();
                RequestsPets requestsPets = new RequestsPets();
                TestDataPet testDataPet = new TestDataPet();
                System.out.println(requestsPets.createPet(testDataPet.pet).body());
            case "2":

            case "3":
//            default:
//                System.out.println("unknown");
        }


    }
}
