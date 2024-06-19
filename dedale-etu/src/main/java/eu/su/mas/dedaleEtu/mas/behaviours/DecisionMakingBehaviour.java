package eu.su.mas.dedaleEtu.mas.behaviours;

import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import jade.core.behaviours.OneShotBehaviour;
import eu.su.mas.dedale.env.Observation;

/**
 * This behaviour represents the decision-making process of the ExplorerAgent.
 */
public class DecisionMakingBehaviour extends OneShotBehaviour {

    public DecisionMakingBehaviour(AbstractDedaleAgent agent) {
        super(agent);
    }

    @Override
    public void action() {
        // Retrieve the agent's current position
        String myPosition = ((AbstractDedaleAgent) this.myAgent).getCurrentPosition();

        if (myPosition != null) {
            // Implement decision-making logic here
            // Example: Determine if the agent should open a lock, pick a treasure, or move to a new location

            // Check for treasures and attempt to open locks if the agent has the necessary skills
            if (((AbstractDedaleAgent) this.myAgent).openLock(Observation.GOLD) || ((AbstractDedaleAgent) this.myAgent).openLock(Observation.DIAMOND)) {
                System.out.println("Lock opened at position: " + myPosition);
            }

            // Pick up any available treasures
            int pickedTreasure = ((AbstractDedaleAgent) this.myAgent).pick();
            if (pickedTreasure > 0) {
                System.out.println("Picked up treasure at position: " + myPosition);
            }

            // Additional decision logic based on the agent's goals and environment state
            // ...
        }
    }
}
