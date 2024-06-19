package eu.su.mas.dedaleEtu.mas.behaviours;

import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import eu.su.mas.dedale.env.Observation;
import dataStructures.tuple.Couple;
import jade.core.behaviours.TickerBehaviour;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class ExplorationBehaviour extends TickerBehaviour {
    private Set<String> visitedNodes;
    private Random random;

    public ExplorationBehaviour(AbstractDedaleAgent agent) {
        super(agent, 1000); // Adjust time for tick
        this.visitedNodes = new HashSet<>();
        this.random = new Random();
    }

    @Override
    protected void onTick() {
        String currentPosition = ((AbstractDedaleAgent) this.myAgent).getCurrentPosition();
        if (currentPosition != null) {
            this.visitedNodes.add(currentPosition);

            List<Couple<String, List<Couple<Observation, Integer>>>> observableNodes =
                    ((AbstractDedaleAgent) this.myAgent).observe();

            String nextMove = null;
            for (Couple<String, List<Couple<Observation, Integer>>> node : observableNodes) {
                if (!this.visitedNodes.contains(node.getLeft())) {
                    nextMove = node.getLeft();
                    break;
                }
            }

            if (nextMove == null) {
                // If no unvisited nodes are found, choose a random adjacent node
                nextMove = observableNodes.get(random.nextInt(observableNodes.size())).getLeft();
            }

            ((AbstractDedaleAgent) this.myAgent).moveTo(nextMove);
        }
    }
}
