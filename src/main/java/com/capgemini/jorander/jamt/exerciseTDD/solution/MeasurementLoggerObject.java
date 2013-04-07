package com.capgemini.jorander.jamt.exerciseTDD.solution;

import com.capgemini.jorander.jamt.base.MeasurementLogger;

/**
 * This is part of a solution to the exercise. Don't look unless you really want to.
 * 
 * A wrapper object around the static MeasurmentLogger.
 */
public class MeasurementLoggerObject {
    
    public void logMeasurement(String sensor, int farhenheit, double celsius){
        MeasurementLogger.logMeasurement(sensor, farhenheit, celsius);
    }
}
