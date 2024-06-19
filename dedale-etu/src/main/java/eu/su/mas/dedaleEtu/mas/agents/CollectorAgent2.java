package eu.su.mas.dedaleEtu.mas.agents;

import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import eu.su.mas.dedale.mas.agent.behaviours.startMyBehaviours;
import eu.su.mas.dedaleEtu.mas.behaviours.CommunicationBehaviour;
import eu.su.mas.dedaleEtu.mas.behaviours.DecisionMakingBehaviour;
import eu.su.mas.dedaleEtu.mas.behaviours.NavigationBehaviour;
import eu.su.mas.dedaleEtu.mas.behaviours.TreasureCollectionBehaviour;
import jade.core.behaviours.Behaviour;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CollectorAgent2 extends AbstractDedaleAgent {
    private static final long serialVersionUID = -123456789L;
    private String currentTreasureType;
    private int backpackCapacity;

    protected void setup() {
        super.setup();
        // Initialize attributes here. Example:


        List<Behaviour> lb = new ArrayList<Behaviour>();

        // Adding behaviours
        lb.add(new TreasureCollectionBehaviour(this));
        lb.add(new CommunicationBehaviour(this));
        lb.add(new NavigationBehaviour(this));
        lb.add(new DecisionMakingBehaviour(this));

        addBehaviour(new startMyBehaviours(this, lb));
    }



    // Other methods as required
}
