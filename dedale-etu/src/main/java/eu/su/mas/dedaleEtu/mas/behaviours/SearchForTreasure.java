package eu.su.mas.dedaleEtu.mas.behaviours;

import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import jade.core.behaviours.OneShotBehaviour;

import java.util.Random;

public class SearchForTreasure extends OneShotBehaviour {

    public SearchForTreasure(AbstractDedaleAgent agent) {
        super(agent);
    }

    @Override
    public void action() {
        String treasureLocation = findTreasure();
        if (treasureLocation != null) {
            System.out.println(myAgent.getLocalName() + " found treasure at " + treasureLocation);
        } else {
            System.out.println(myAgent.getLocalName() + " did not find any treasure.");
        }
    }

    private String findTreasure() {
// Simulate searching for treasure in the environment
        Random random = new Random();
        boolean treasureFound = random.nextInt(100) < 20; // 20% chance to find a treasure
        if (treasureFound) {
            // Simulate a location for the found treasure
            int x = random.nextInt(10); // Random X coordinate
            int y = random.nextInt(10); // Random Y coordinate
            return "Location[" + x + "," + y + "]";
        } else {
            return null; // No treasure found
        }
    }
}
