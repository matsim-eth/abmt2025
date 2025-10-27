package org.eth.week6.exercises.matsiminjection;

import java.io.BufferedWriter;
import java.io.IOException;

import org.eth.week5.exercises.example.CounterEventHandler;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.controler.events.IterationEndsEvent;
import org.matsim.core.controler.listener.IterationEndsListener;
import org.matsim.core.utils.io.IOUtils;

import com.google.inject.Inject;

public class ControllerListenerInjectionV1 implements IterationEndsListener{

	private final CounterEventHandler eventHandler;
	private final int[] enterEvents;
	private final int[] leaveEvents;
	private final Scenario scenario;
	
	@Inject
	public ControllerListenerInjectionV1(Scenario scenario, CounterEventHandler eventHandler) {
		enterEvents = new int[scenario.getConfig().controller().getLastIteration() + 1];
		leaveEvents = new int[scenario.getConfig().controller().getLastIteration() + 1];
		this.scenario = scenario;
		this.eventHandler = eventHandler;

	}
	
	public void notifyIterationEnds(IterationEndsEvent event) {
	
		this.enterEvents[event.getIteration()] = this.eventHandler.getCounterEnter();
		this.leaveEvents[event.getIteration()] = this.eventHandler.getCounterLeave();	
		
		if (event.getIteration() == scenario.getConfig().controller().getLastIteration()) {
			// write all data gathered in csv files
			String path = event.getServices().getControlerIO().getOutputPath() + "/events.csv";
			try {
				//Because we want to write to CSV we would use the generic bufferred writer and specify the csv file name
		        BufferedWriter writer = IOUtils.getBufferedWriter(path);
				writer.write("iteration,numlinkenter,numlinkleave\n");
				for (int i = 0; i <= event.getIteration();i++) {
					writer.write(i + "," + this.enterEvents[i] + "," + this.leaveEvents[i] + "\n");
				}
				// flush() tells the Writer to output the stream
				writer.flush();
				
				// it is good practice to close the stream when no more output is expected
				writer.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}			
		}
	}

	public int[] getEnterEvents() {
		return enterEvents;
	}

	public int[] getLeaveEvents() {
		return leaveEvents;
	}

}