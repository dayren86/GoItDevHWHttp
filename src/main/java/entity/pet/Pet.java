package entity.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class Pet {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Status status;


    public enum Status {
        available,
        pending,
        sold
    }
}
