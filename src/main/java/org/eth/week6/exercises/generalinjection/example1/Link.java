package org.eth.week6.exercises.generalinjection.example1;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Link {
	private final String name;
	
	@Inject
    public Link(String name) {
		this.name = name;
	}
	
//	@Inject
//    public Link(@Named("StreetName") String name) {
//		this.name = name;
//	}
	
    public String getName() {
		return name;
	}
}