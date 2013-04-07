package com.capgemini.jorander.jamt.exerciseTDD;

import com.capgemini.jorander.jamt.base.Tickable;

/**
 * Action is taken every third tick.
 * When action is taken this object 
 *  - reads the HeatSensor with the supplied name,
 *  - converts from Fahrenheit to Celsius (C = (F-32)*5/9), and
 *  - logs the result to MeasurmentLogger.
 * 
 * Implement this object using TDD (Test-first).
 */
class TDDHeatMeasurementCollector implements Tickable {

    public TDDHeatMeasurementCollector(String sensorName) {
    }

    @Override
    public boolean tick() {
        throw new UnsupportedOperationException("To implement this method using TDD is an exercise.");
    }

}
