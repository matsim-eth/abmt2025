package org.eth.week6.exercises.generalinjection.example1;

import com.google.inject.AbstractModule;

public class LinkModule extends AbstractModule{

    private int number;

    public LinkModule(int number) {
        this.number = number;
    }


    protected void configure() {

       // 1. 
       // bind(Link.class).asEagerSingleton(); // in this case the name object in the Link object will be an empty String

       // 2.
       bind(Link.class).toInstance(new Link("Wehntalerstrasse"));


       // 3.

      // bind(String.class).annotatedWith(Names.named("StreetName")).toInstance(new String("Birchstrasse"));


       // 4.


       // bind(Link.class).toProvider(new LinkProvider(number));

    }

}