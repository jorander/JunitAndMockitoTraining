package com.capgemini.jorander.jamt.exerciseLegacy;

import com.capgemini.jorander.jamt.base.Ticker;

/**
 * Class used to execute the LegacyHeatMeasurementCollector to see its output.
 */
public class RunLegacyHeatMeasurementCollector {

    public static void main(String[] args) {
        System.out.println("Start LegacySensor");
        Ticker ticker = new Ticker(new LegacyHeatMeasurementCollector("LegacySensor"));
        ticker.tick(10);
        System.out.println("End LegacySensor");
    }
}