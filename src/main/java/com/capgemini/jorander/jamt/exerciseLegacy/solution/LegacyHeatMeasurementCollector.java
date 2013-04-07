package com.capgemini.jorander.jamt.exerciseLegacy.solution;

import com.capgemini.jorander.jamt.base.HeatSensor;
import com.capgemini.jorander.jamt.base.MeasurementLogger;
import com.capgemini.jorander.jamt.base.Tickable;

/**
 * Reads the sensor with the supplied name when action is taken. Action is taken
 * every third tick.
 *
 * This is a solution to the exercise. Don't look unless you really want to.
 */
public class LegacyHeatMeasurementCollector implements Tickable {
    private static final double FIVE_NINETHS = 0.555555556;

    private final String heatSensorName;
    private int ticksWithNoAction = 0;

    public LegacyHeatMeasurementCollector(String heatSensorName) {
        this.heatSensorName = heatSensorName;
    }

    @Override
    public boolean tick() {
        if (ticksWithNoAction == 2) {
            final int fahrenheit = getHeatSensor().measure(heatSensorName);
            final double celsius = (fahrenheit - 32) * FIVE_NINETHS;
            logMeasurement(fahrenheit, celsius);
            ticksWithNoAction = 0;
            return true;
        } else {
            ticksWithNoAction++;
            return false;
        }
    }

    protected HeatSensor getHeatSensor() {
        return new HeatSensor();
    }

    protected void logMeasurement(final int fahrenheit, final double celsius) {
        MeasurementLogger.logMeasurement(heatSensorName, fahrenheit, celsius);
    }
}