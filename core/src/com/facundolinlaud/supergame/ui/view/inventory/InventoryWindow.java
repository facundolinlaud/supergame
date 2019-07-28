package com.facundolinlaud.supergame.ui.view.inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.facundolinlaud.supergame.ui.model.Item;
import com.facundolinlaud.supergame.ui.view.cross.GothicWindow;
import com.facundolinlaud.supergame.ui.view.utils.Themes;

import java.util.List;

/**
 * Created by facundo on 3/30/16.
 */
public class InventoryWindow extends GothicWindow {
    private static final String TITLE = "Inventory";
    private static final int ITEMS_PER_ROW = 8;

    private InventoryGrid grid;

    public InventoryWindow(Skin skin, int maxItemsAmount, DragAndDrop dragAndDrop) {
        super(TITLE, skin, Themes.Background.DARK);
        setVisible(false);
        adjustSize(maxItemsAmount);
        initializeGrid(skin, maxItemsAmount, dragAndDrop);
    }

    private void adjustSize(int itemCount){
        float width = ITEMS_PER_ROW * (InventoryGrid.SLOT_SIZE + InventoryGrid.SLOT_PADDING * 2)
                + getPadLeft() + getPadRight() + 2 * InventoryGrid.GRID_PADDING;
        float height = (float) (Math.ceil((double) itemCount / ITEMS_PER_ROW) *
                (InventoryGrid.SLOT_SIZE + InventoryGrid.SLOT_PADDING * 2)) + getPadTop() + getPadBottom()
                + 2 * InventoryGrid.GRID_PADDING;

        setSize(width, height);
    }

    private void initializeGrid(Skin skin, int maxItemsAmount, DragAndDrop dragAndDrop) {
        this.grid = new InventoryGrid(skin, ITEMS_PER_ROW, maxItemsAmount, dragAndDrop);
        this.add(grid);
    }

    public void update(List<Item> items){
        this.grid.update(items);
    }
}
