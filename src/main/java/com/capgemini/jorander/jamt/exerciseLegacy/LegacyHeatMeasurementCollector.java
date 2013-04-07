package com.capgemini.jorander.jamt.exerciseLegacy;

import com.capgemini.jorander.jamt.base.HeatSensor;
import com.capgemini.jorander.jamt.base.MeasurementLogger;
import com.capgemini.jorander.jamt.base.Tickable;

/**
 * Reads the sensor with the supplied name when action is taken. Action is taken
 * every third tick.
 *
 * This is a legacy implementation that has some challenges to get into a test
 * harness.
 */
public class LegacyHeatMeasurementCollector implements Tickable {

    private final String heatSensorName;
    private int ticksWithNoAction = 0;

    public LegacyHeatMeasurementCollector(String heatSensorName) {
        this.heatSensorName = heatSensorName;
    }

    @Override
    public boolean tick() {
        if (ticksWithNoAction == 2) {
            final int fahrenheit = new HeatSensor().measure(heatSensorName);
            MeasurementLogger.logMeasurement(heatSensorName, fahrenheit, (fahrenheit - 32) * 5 / 9);
            ticksWithNoAction = 0;
            return true;
        } else {
            ticksWithNoAction++;
            return false;
        }
    }
}