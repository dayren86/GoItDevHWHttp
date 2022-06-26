package pets;

import entity.pet.ApiResponse;
import entity.pet.Pet;

import pets.service.ServiceGson;
import pets.service.ServiceHttp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

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

//    public HttpResponse<String> updatePetStoreData(int id, String name, Pet.Status status) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest
//                .newBuilder()
//                .uri(URI.create(URL+ "/" + id))
//                .header("accept", "application/json")
//                .header("Content-Type", "application/json")
//                .POST()
//                .build();
//
//        return new ServiceHttp().serviceHttpClient(request);
//    }

    public  String createPost(File file) throws IOException {

         String attachmentName = "sjkhds";
         String attachmentFileName = "src/Screenshot_23.png";
         String crlf = "\r\n";
         String twoHyphens = "--";
         String boundary = "*****";

        HttpURLConnection httpUrlConnection = null;
        URL url = new URL(URL + "/" + 1 + "/uploadImage");
        httpUrlConnection = (HttpURLConnection) url.openConnection();
        httpUrlConnection.setUseCaches(false);
        httpUrlConnection.setDoOutput(true);

        httpUrlConnection.setRequestMethod("POST");
        httpUrlConnection.setRequestProperty("Content-Type", "multipart/form-data;");
        DataOutputStream request = new DataOutputStream(httpUrlConnection.getOutputStream());

        request.writeBytes(twoHyphens + boundary + crlf);
        request.writeBytes("Content-Disposition: form-data; name=\"" + attachmentName + "\";filename=\""
                + attachmentFileName + "\"" + crlf);
        request.writeBytes(crlf);

        request.write(createArrayFromFile(file));

        request.writeBytes(crlf);
        request.writeBytes(twoHyphens + boundary + twoHyphens + crlf);
        request.flush();
        request.close();
        String result = httpUrlConnection.getResponseMessage();

        httpUrlConnection.disconnect();
        return result;

    }

    public static byte[] createArrayFromFile(File file) throws IOException {

        // Creating an object of FileInputStream to
        // read from a file
        FileInputStream fl = new FileInputStream(file);

        // Now creating byte array of same length as file
        byte[] arr = new byte[(int) file.length()];

        // Reading file content to byte array
        // using standard read() method
        fl.read(arr);

        // lastly closing an instance of file input stream
        // to avoid memory leakage
        fl.close();

        // Returning above byte array
        return arr;
    }

    public String updatePetUploadImage(ApiResponse apiResponse) throws IOException, InterruptedException {



        File file = new File("src/Screenshot_23.png");
       return createPost(file);



    }
//    {
//        "code": 200,
//            "type": "unknown",
//            "message": "additionalMetadata: fghdhg\nFile uploaded to ./Screenshot_23.png, 308 bytes"
//    }
}
