package entity.pet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;

@Data
@AllArgsConstructor
public class ApiResponse {
    private int petId;
    //private String additionalMetadata;
    private File file;
}
