# Welcome to the Dedale project.

This project is developed at Sorbonne University, Paris, France. It is used in both research and teaching activities. Considering the later, during the FoSyMa course (from the French “Fondement des Systèmes Multi-Agents”) as a practical application of Multi-Agents Systems (MAS). 
It allows Master's students to obtain a first-hand experience of some of the nice (and sometimes difficult) characteristics that comes with agents and distributed systems :
 - distribution and asynchronism (system and communication),
 - autonomy, decision and coordination in uncertain and partially observable environments

**Your goal here is "simple", you have to conceive and implement the behaviours of a team of heterogeneous agents that have to explore an unknown environment and coordinate themselves to reach a given goal** :
 - To collect the maximum amount of treasure in a given time frame.
 - To hunt the Golem(s)
 - To patrol an area
 - To pick and deliver packages
 
while facing, or not, other teams.

This game is initally inspired by the famous "Hunt the Wumpus"  of [Gregory Yob](https://en.wikipedia.org/wiki/Gregory_Yob).

For more details, see Dedale's website : https://dedale.gitlab.io/


## Requirements and Execution Instructions

To run this project, ensure you have the following installed:

JDK version 18 or higher.
Maven version 3 or higher.

### Running the Simulation
Navigate to the Project Directory: Ensure you are in the dedale-etu directory before executing the Maven goals.

Maven Goals Execution: To run the simulation, open the 'Run Anything' command line in your IDE (shortcut: ctrl + ctrl in IntelliJ). Execute the following Maven goals:

mvn install exec:java 

If the simulation doesn't start on the first try, use the mvn clean install command before mvn exec:java to ensure all components are correctly set up.