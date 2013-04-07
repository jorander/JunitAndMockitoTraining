package com.capgemini.jorander.jamt.exerciseTDD;

import com.capgemini.jorander.jamt.base.Ticker;

/**
 * Class used to execute the TDDHeatMeasurementCollector to see its output.
 */
public class RunTDDHeatMeasurementCollector {

    public static void main(String[] args) {
        System.out.println("Start TDDSensor");
        Ticker ticker = new Ticker(new TDDHeatMeasurementCollector("TDDSensor"));
        ticker.tick(10);
        System.out.println("End TDDSensor");
    }
}