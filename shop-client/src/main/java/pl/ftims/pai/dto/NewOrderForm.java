package pl.ftims.pai.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Alebazi on 2018-01-16.
 */
public class NewOrderForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
