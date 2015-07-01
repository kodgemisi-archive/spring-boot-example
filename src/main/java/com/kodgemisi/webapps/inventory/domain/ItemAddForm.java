package com.kodgemisi.webapps.inventory.domain;

/**
 * Created by sedat on 30.06.2015.
 */
public class ItemAddForm {
    private String itemType;
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
