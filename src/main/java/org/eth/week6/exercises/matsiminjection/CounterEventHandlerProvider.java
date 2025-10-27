package org.eth.week6.exercises.matsiminjection;

import org.eth.week5.exercises.example.CounterEventHandler;
import org.matsim.api.core.v01.Scenario;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class CounterEventHandlerProvider implements Provider<CounterEventHandler> {

	private final Scenario scenario;
	// we are providing one constructor annotated with inject 
	// to tell the Guice framework which constructor should be used
	
	// you will notice that we do not inject a Scenario object anywhere in our code
	// this is because MATSim injects certain objects by default
	// and a Scenario is one of them
	@Inject
	public CounterEventHandlerProvider(Scenario scenario) {
		this.scenario = scenario;
	}
	// get() method creates an instance of the MyEventHandler
	
	public CounterEventHandler get() {
		return new CounterEventHandler();
	}

}