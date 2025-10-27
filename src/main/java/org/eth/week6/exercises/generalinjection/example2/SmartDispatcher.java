package org.eth.week6.exercises.generalinjection.example2;

import com.google.inject.Inject;

public class SmartDispatcher implements Dispatcher {
	
    @Inject
	public SmartDispatcher() {
	}
	@Override
	public void dispatch() {
		// do something really smart here
		// but not necessarily fast
		System.out.println("We are doing something smart!");
	}
}