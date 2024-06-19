package eu.su.mas.dedaleEtu.mas.behaviours;

import eu.su.mas.dedale.env.Observation;
import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import jade.core.behaviours.TickerBehaviour;
import java.util.List;
import java.util.stream.Collectors;
import dataStructures.tuple.Couple;

public class NavigationBehaviour extends TickerBehaviour {

    public NavigationBehaviour(AbstractDedaleAgent agent) {
        super(agent, 1000); // Interval in ms
    }

    @Override
    protected void onTick() {
        AbstractDedaleAgent myAgent = (AbstractDedaleAgent) this.myAgent;

        // Get the current position of the agent
        String currentPosition = myAgent.getCurrentPosition();
        if (currentPosition == null) {
            System.out.println("Warning: Current position not found!");
            return;
        }

        // Observe the surroundings to find treasures
        List<Couple<String, List<Couple<Observation, Integer>>>> observations = myAgent.observe();
        List<String> treasureLocations = observations.stream()
                .filter(couple -> couple.getRight().stream()
                        .anyMatch(obs -> obs.getLeft().equals(Observation.GOLD) || obs.getLeft().equals(Observation.DIAMOND)))
                .map(Couple::getLeft)
                .collect(Collectors.toList());

        if (!treasureLocations.isEmpty()) {
            // Move towards the first detected treasure
            String nextNode = treasureLocations.get(0);
            boolean moved = myAgent.moveTo(nextNode);
            if (!moved) {
                System.out.println("Movement to treasure location " + nextNode + " failed.");
            }
        } else {
            // No treasure detected, implement additional exploration logic if needed
        }
    }
}
