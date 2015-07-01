package com.kodgemisi.webapps.inventory.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by sedat on 30.06.2015.
 */

public class ItemAddForm {
    @NotEmpty
    @Size(min=2, max=50)
    private String itemType;

    @NotNull
    private int amount = 1; //default

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
