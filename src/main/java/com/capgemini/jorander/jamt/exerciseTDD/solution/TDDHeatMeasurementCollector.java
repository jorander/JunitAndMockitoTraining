package com.capgemini.jorander.jamt.exerciseTDD.solution;

import com.capgemini.jorander.jamt.base.HeatSensor;
import com.capgemini.jorander.jamt.base.Tickable;

/**
 * This is a solution to the exercise. Don't look unless you really want to.
 * 
 * Action is taken every third tick.
 * When action is taken this object 
 *  - reads the HeatSensor with the supplied name,
 *  - converts from Fahrenheit to Celsius (C = (F-32)*5/9), and
 *  - logs the result to MeasurmentLogger.
 * 
 */
class TDDHeatMeasurementCollector implements Tickable {
    private int ticksWithNoAction = 0;
    private final String sensorName;
    private final HeatSensor heatSensor;
    private final MeasurementLoggerObject measurementLoggerObject;

    TDDHeatMeasurementCollector(String sensorName, HeatSensor heatSensor, MeasurementLoggerObject measurementLoggerObject) {
        this.sensorName = sensorName;
        this.heatSensor = heatSensor;
        this.measurementLoggerObject = measurementLoggerObject;
    }

    @Override
    public boolean tick() {
        if (ticksWithNoAction == 2) {
            ticksWithNoAction = 0;
            final int fahrenheit = heatSensor.measure(sensorName);
            final double celsius = (fahrenheit - 32) * 5/9;
            measurementLoggerObject.logMeasurement(sensorName, fahrenheit, celsius);
            return true;
        } else {
            ticksWithNoAction++;
            return false;
        }
    }
}
