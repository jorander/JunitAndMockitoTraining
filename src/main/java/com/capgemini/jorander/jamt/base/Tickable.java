package com.capgemini.jorander.jamt.base;

/**
 * An interface representing a Tickable object, whatever that is...
 * @author jorgen
 */
public interface Tickable {
    /**
     * The object could take some action every time it's ticked.
     * @return <code>true</code> if some action was taken.
     */
    public boolean tick();    
}