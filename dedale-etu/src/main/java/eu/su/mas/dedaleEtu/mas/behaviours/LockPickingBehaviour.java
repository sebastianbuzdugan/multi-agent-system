package eu.su.mas.dedaleEtu.mas.behaviours;

import eu.su.mas.dedale.env.Observation;
import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import jade.core.behaviours.TickerBehaviour;

import java.util.List;
import dataStructures.tuple.Couple;

public class LockPickingBehaviour extends TickerBehaviour {

    public LockPickingBehaviour(AbstractDedaleAgent agent) {
        super(agent, 1000); // Adjust the time interval for ticking as needed
    }

    @Override
    protected void onTick() {
        String myPosition = ((AbstractDedaleAgent) this.myAgent).getCurrentPosition();
        if (myPosition != null) {
            List<Couple<String, List<Couple<Observation, Integer>>>> observations =
                    ((AbstractDedaleAgent) this.myAgent).observe();

            for (Couple<String, List<Couple<Observation, Integer>>> obsNode : observations) {
                List<Couple<Observation, Integer>> obs = obsNode.getRight();
                for (Couple<Observation, Integer> o : obs) {
                    if (o.getLeft() == Observation.GOLD || o.getLeft() == Observation.DIAMOND) {
                        boolean unlocked = ((AbstractDedaleAgent) this.myAgent).openLock(o.getLeft());
                        if (unlocked) {
                            // Handle logic post successful unlocking
                            // e.g., notify other agents, update internal state, etc.
                        }
                    }
                }
            }
        }
    }
}
