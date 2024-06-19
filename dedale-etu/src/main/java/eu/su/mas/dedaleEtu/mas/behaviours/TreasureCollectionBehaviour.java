package eu.su.mas.dedaleEtu.mas.behaviours;

import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import jade.core.behaviours.SimpleBehaviour;
import eu.su.mas.dedale.env.Observation;
import dataStructures.tuple.Couple;

import java.util.List;

public class TreasureCollectionBehaviour extends SimpleBehaviour {

    private boolean finished = false;

    public TreasureCollectionBehaviour(AbstractDedaleAgent myAgent) {
        super(myAgent);
    }

    @Override
    public void action() {
        String myPosition = ((AbstractDedaleAgent) this.myAgent).getCurrentPosition();

        if (myPosition != null) {
            // Observe the environment
            List<Couple<String, List<Couple<Observation, Integer>>>> observations = ((AbstractDedaleAgent) this.myAgent).observe();

            for (Couple<String, List<Couple<Observation, Integer>>> obs : observations) {
                for (Couple<Observation, Integer> detail : obs.getRight()) {
                    if (detail.getLeft().equals(Observation.GOLD) || detail.getLeft().equals(Observation.DIAMOND)) {
                        // Check if the treasure type matches the agent's collecting type
                        // Unlock and collect the treasure if it matches
                        // Update the agent's internal state and map
                    }
                }
            }
            // Additional logic for moving towards and collecting treasures
        }
    }

    @Override
    public boolean done() {
        return finished;
    }
}
