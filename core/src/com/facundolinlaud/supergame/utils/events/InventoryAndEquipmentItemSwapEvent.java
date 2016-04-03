package com.facundolinlaud.supergame.utils.events;

import com.facundolinlaud.supergame.ui.model.Item;

/**
 * Created by facundo on 4/2/16.
 */
public class InventoryAndEquipmentItemSwapEvent extends Event {
    private Item equippedItem;
    private Item inventedItem;

    public InventoryAndEquipmentItemSwapEvent(Item equippedItem, Item inventedItem) {
        this.equippedItem = equippedItem;
        this.inventedItem = inventedItem;
    }

    public Item getEquippedItem() {
        return equippedItem;
    }

    public Item getInventedItem() {
        return inventedItem;
    }
}
