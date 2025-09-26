package org.eth.week2.exercises;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Leg;
import org.matsim.api.core.v01.population.Person;
import org.matsim.api.core.v01.population.Plan;
import org.matsim.api.core.v01.population.Population;
import org.matsim.api.core.v01.population.PopulationFactory;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.geometry.CoordUtils;


public class RunMatsimUtils {
    public static void main(String[] args){

        /*
        * We would modify the input plan files using some MATSim utils. We create a new agent and add this new agent to the Population data
        * The steps include:
        * 1 - Use the Person class to create a person
        * 2 - Add person attributes and a travel plan to this person
        * 3 - Get the Population data from the scenario
        * 4 - Add the new agent to the population file
        * 5 - Run scenario
        * 6 - view the output plan file to see the new agent
        * */

        //Aim: Creating a person and then adding the person to the population file

        //First load the Siouxfalls scenario
        String configPath = args[0];
        Config config = ConfigUtils.loadConfig(configPath);
        config.controller().setOutputDirectory("output1");

        Scenario scenario = ScenarioUtils.loadScenario(config);

        //Get the population from the scenario

        //Use population factory to create a person

        //To create person we need the person ID, create Id of type person

        //Create person

        //A person needs a plan so we create a plan container to take the activities and legs of a person

        
        //what are the things needed in a plans file?

        //Create person activities
        //There are many ways to create activity, either from facility id, coordinates, or network link

        //First create Coordinate object for the first activity, ensure the coordinates are within the simulated region
  
        //Create activities

         
         //coordinates can also be created using the Coord class as below        

        //Create person leg

        //Add activities and leg to plan

        //Add plan to person


        //We can add some person attributes too. Maybe age, etc
       

        //Add person to population



        //Let's run the modified scenario

        Controler controller = new Controler(scenario);


        controller.getConfig().controller().setLastIteration(1);


        controller.run();


    }

}