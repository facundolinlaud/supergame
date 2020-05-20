package com.facundolinlaud.supergame.skills.leaves;

import com.badlogic.ashley.core.Entity;
import com.facundolinlaud.supergame.behaviortree.Task;
import com.facundolinlaud.supergame.services.CombatService;
import com.facundolinlaud.supergame.skills.SkillBlackboard;

/**
 * Pops: an agent entity-value
 * Pushes: nothing
 */
public class AffectAgentHealthTask extends Task<SkillBlackboard> {
    private CombatService combatService;

    private float amount;

    public AffectAgentHealthTask(float amount) {
        this.amount = amount;
    }

    @Override
    protected void onBlackboardAvailable(SkillBlackboard blackboard) {
        combatService = blackboard.getCombatService();
    }

    @Override
    public void activate() {
        System.out.println("Activating AffectAgentHealth");

        SkillBlackboard blackboard = getBlackboard();
        Entity target = stack.pop().getEntity();
        Entity caster = blackboard.getCaster();

        combatService.affectAgent(caster, target, amount);
        completed();
    }

    @Override
    public void completed() {
        System.out.println("Completing AffectAgentHealth");
        super.completed();
    }
}