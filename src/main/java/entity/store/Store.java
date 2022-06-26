package entity.store;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Store {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private Status status;
    private boolean complete;


    public enum Status {
        placed,
        approved,
        delivered
    }
}
