package com.facundolinlaud.supergame.ui.view.equipment;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.facundolinlaud.supergame.ui.model.Item;
import com.facundolinlaud.supergame.ui.view.utils.Themes;
import com.facundolinlaud.supergame.utils.WearType;

import java.util.Map;

/**
 * Created by facundo on 4/2/16.
 */
public class EquipmentWindow extends Window {

    public static final String TITLE = "Equipment";

    private Grid grid;

    public EquipmentWindow(Skin skin, DragAndDrop dragAndDrop) {
        super(TITLE, skin, Themes.CLASSIC.toString());

        setVisible(true);
        adjustTitlePosition();
        setSize(265, 265);
        initializeGrid(skin);
    }

    private void adjustTitlePosition() {
        getTitleTable().center().top().padLeft(55);
    }

    private void initializeGrid(Skin skin) {
        this.grid = new Grid(skin);
        add(this.grid);
    }

    public void update(Map<WearType, Item> items){
        if(isVisible()){
            grid.update(items);
        }
    }
}
