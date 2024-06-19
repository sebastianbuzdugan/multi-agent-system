package eu.su.mas.dedaleEtu.mas.agents;

import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import eu.su.mas.dedaleEtu.mas.behaviours.ExplorationBehaviour;
import eu.su.mas.dedaleEtu.mas.behaviours.CommunicationBehaviour;
import eu.su.mas.dedaleEtu.mas.behaviours.LockPickingBehaviour;
import eu.su.mas.dedaleEtu.mas.behaviours.DecisionMakingBehaviour;

import eu.su.mas.dedale.mas.agent.behaviours.startMyBehaviours;
import jade.core.behaviours.Behaviour;
import java.util.*;

// Other necessary imports

/**
 * ExplorerAgent class.
 * This agent explores the environment, shares map data, and unlocks treasures.
 */
public class ExplorerAgent extends AbstractDedaleAgent {

    private static final long serialVersionUID = -123456789L; // Unique ID

    protected void setup() {
        super.setup();

        // Agent-specific initialization code
        // Retrieve and process any arguments passed to the agent
        // ...

        System.out.println("Explorer agent " + this.getLocalName() + " is started.");

        List<Behaviour> lb = new ArrayList<Behaviour>();

// Add the ExplorationBehaviour.java
        lb.add(new ExplorationBehaviour(this));

// Add the CommunicationBehaviour
        lb.add(new CommunicationBehaviour(this));

// Add the Lock-Picking Behaviour
        lb.add(new LockPickingBehaviour(this));

// Add the Decision-Making Behaviour
        lb.add(new DecisionMakingBehaviour(this));

// Start all the behaviours
        addBehaviour(new startMyBehaviours(this, lb));

        // Other initializations if needed
    }

    // Other necessary methods and inner classes
}
