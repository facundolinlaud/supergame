package com.facundolinlaud.supergame.ui.view.overlay.skillsbar;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.facundolinlaud.supergame.model.skill.Skill;

import java.util.Map;

public class Skillbar extends Table {
    private static final int SIZE = 10;

    private Array<SkillbarSlot> slots;

    public Skillbar(Skin skin, Map<Integer, Skill> skills) {
        super(skin);
        this.setBackground("spellbar");
        this.slots = new Array<>(false, SIZE);
        this.align(Align.left);
        this.padLeft(3);

        for(int i = 0; i < SIZE; i++){
            SkillbarSlot slot = new SkillbarSlot(skin, String.valueOf(i + 1));
            this.slots.add(slot);
            this.add(slot).width(32).height(32).padRight(4).left();

            if(skills.containsKey(i)){
                slot.setContent(skills.get(i));
            }
        }
    }

    public void beginCooldown(Skill skill){
        float cooldown = skill.getCooldown();
        for(SkillbarSlot s : slots){
            if(skill == s.getContent()){
                s.beginCooldown(cooldown);
            }
        }
    }
}