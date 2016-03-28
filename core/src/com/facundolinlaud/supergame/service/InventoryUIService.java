package com.facundolinlaud.supergame.service;

import com.badlogic.ashley.core.Entity;
import com.facundolinlaud.supergame.components.BagComponent;
import com.facundolinlaud.supergame.utils.observer.Observer;
import com.facundolinlaud.supergame.utils.observer.events.ItemDroppedEvent;

/**
 * Created by facundo on 3/27/16.
 */
public interface InventoryUIService extends Observer<ItemDroppedEvent> {

    void update(Entity entity, BagComponent bag);

    void setGatherer(Entity player);
}