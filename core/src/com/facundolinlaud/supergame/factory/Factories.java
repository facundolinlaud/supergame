package com.facundolinlaud.supergame.factory;

import com.badlogic.ashley.core.Engine;
import com.facundolinlaud.supergame.managers.world.ParticleManager;

public class Factories {
    private AnimationsFactory animationsFactory;
    private QuestsFactory questsFactory;
    private SkillsFactory skillsFactory;
    private ParticleFactory particleFactory;
    private ItemFactory itemFactory;
    private AgentFactory agentFactory;
    private BehaviorFactory behaviorFactory;

    public Factories(Engine engine) {
        this.animationsFactory = new AnimationsFactory();
        this.questsFactory = new QuestsFactory();
        this.skillsFactory = new SkillsFactory();
        this.particleFactory = new ParticleFactory(new ParticleManager());
        this.itemFactory = new ItemFactory();
        this.behaviorFactory = new BehaviorFactory();
        this.agentFactory = new AgentFactory(engine, this);
    }

    public AnimationsFactory getAnimationsFactory() {
        return animationsFactory;
    }

    public QuestsFactory getQuestsFactory() {
        return questsFactory;
    }

    public SkillsFactory getSkillsFactory() {
        return skillsFactory;
    }

    public ParticleFactory getParticleFactory() {
        return particleFactory;
    }

    public ItemFactory getItemFactory() {
        return itemFactory;
    }

    public AgentFactory getAgentFactory() {
        return agentFactory;
    }

    public BehaviorFactory getBehaviorFactory() {
        return behaviorFactory;
    }
}
