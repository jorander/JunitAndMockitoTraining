package com.capgemini.jorander.jamt.base;

/**
 * A class that can tick a Tickable object and write about it. This is a base
 * class used for executing code written in exercises and observe the result.
 */
public class Ticker {
    private final Tickable tickable;

    public Ticker(Tickable tickable) {
        this.tickable = tickable;
    }
    
    public void tick(int numberOfTicks){
        for(int i=0; i < numberOfTicks; i++){
            final Long startTime = System.currentTimeMillis();
            final boolean tickResult = tickable.tick();
            final Long duration = System.currentTimeMillis() - startTime;
            System.out.println("Ticked: ActionTaken=" + tickResult + ", Duration(ms)=" + duration);
        }        
    }    
}