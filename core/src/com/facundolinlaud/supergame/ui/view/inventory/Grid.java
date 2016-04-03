package com.facundolinlaud.supergame.ui.view.inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.Align;
import com.facundolinlaud.supergame.ui.model.Item;
import com.facundolinlaud.supergame.ui.view.cross.SlotSource;
import com.facundolinlaud.supergame.ui.view.cross.SlotType;
import com.facundolinlaud.supergame.utils.mediator.Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by facundo on 3/29/16.
 */
public class Grid extends Table {
    public final static int ITEMS_PER_ROW = 5;

    private List<InventorySlot> slots;

    public Grid(Skin skin, int itemsAmount, Mediator uiMediator, DragAndDrop dragAndDrop) {
        super(skin);
        align(Align.topLeft);

        this.slots = new ArrayList<>();

        for(int i = 1; i <= itemsAmount; i++){
            InventorySlot slot = new InventorySlot(skin);

            add(slot);
            slots.add(slot);
            dragAndDrop.addSource(new SlotSource(slot, skin, SlotType.INVENTORY_SLOT));
            dragAndDrop.addTarget(new InventorySlotTarget(slot, uiMediator));

            if(i > 0 && i % 5 == 0) row();
        }
    }

    public void update(List<Item> items){
        slots.stream().forEach(slot -> slot.clearItem());

        for(int i = 0; i < items.size(); i++){
            if(i < slots.size()){
                slots.get(i).setItem(items.get(i));
            }else{
                System.out.println("No space in inventory UI");
            }
        }
    }
}
