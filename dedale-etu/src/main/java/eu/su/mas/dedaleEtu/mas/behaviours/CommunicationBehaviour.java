package eu.su.mas.dedaleEtu.mas.behaviours;

import eu.su.mas.dedale.mas.AbstractDedaleAgent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.List;
import java.util.Random;

public class CommunicationBehaviour extends CyclicBehaviour {

    private Random random = new Random();

    public CommunicationBehaviour(AbstractDedaleAgent agent) {
        super(agent);
    }

    @Override
    public void action() {
        // Listening for incoming messages
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage receivedMessage = myAgent.receive(mt);

        if (receivedMessage != null) {
            String content = receivedMessage.getContent();
            if (content.startsWith("TreasureFound:")) {
                // Handle received treasure information
                String location = content.substring("TreasureFound:".length());
                System.out.println(myAgent.getLocalName() + " received treasure info at " + location);
                // Additional logic for handling treasure
            } else if (content.startsWith("ObstacleDetected:")) {
                // Handle received obstacle information
                String location = content.substring("ObstacleDetected:".length());
                System.out.println(myAgent.getLocalName() + " received obstacle info at " + location);
                // Additional logic for handling obstacle
            }
        } else {
            block(); // No message received, block the behaviour
        }

        // Simulate discovery of treasure or obstacle
        if (random.nextInt(100) < 10) { // 10% chance to discover something
            boolean foundTreasure = random.nextBoolean();
            ACLMessage message = new ACLMessage(ACLMessage.INFORM);
            List<AID> receiverAIDs = getOtherAgentsAIDs();
            for (AID aid : receiverAIDs) {
                message.addReceiver(aid);
            }            if (foundTreasure) {
                message.setContent("TreasureFound: NodeXYZ"); // Replace NodeXYZ with actual location
                System.out.println(myAgent.getLocalName() + " sending treasure info");
            } else {
                message.setContent("ObstacleDetected: NodeABC"); // Replace NodeABC with actual location
                System.out.println(myAgent.getLocalName() + " sending obstacle info");
            }
            ((AbstractDedaleAgent) myAgent).sendMessage(message); // Send the message
        }

    }
    private List<AID> getOtherAgentsAIDs() {
        //hardcoded?
        return null;
    }

}
