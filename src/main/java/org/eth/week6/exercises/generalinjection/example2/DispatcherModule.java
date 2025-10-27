package org.eth.week6.exercises.generalinjection.example2;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class DispatcherModule extends AbstractModule {
	private final String dispatcherType;

	public DispatcherModule(String dispatcherType) {
		this.dispatcherType = dispatcherType;
	}
    
	protected void configure() {
		bind(String.class).annotatedWith(Names.named("dispatcherType")).toInstance(this.dispatcherType);
		bind(Dispatcher.class).toProvider(DispatcherProvider.class);
	}
}