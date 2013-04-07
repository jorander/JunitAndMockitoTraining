package com.capgemini.jorander.jamt.exerciseTDD.solution;

import com.capgemini.jorander.jamt.base.HeatSensor;
import com.capgemini.jorander.jamt.base.Ticker;

/**
 * Class used to execute the TDDHeatMeasurementCollector to see its output.
 */
public class RunTDDHeatMeasurementCollector {

    public static void main(String[] args) {
        System.out.println("Start TDDSensor");
        Ticker ticker = new Ticker(new TDDHeatMeasurementCollector("TDDSensor", new HeatSensor(), new MeasurementLoggerObject()));
        ticker.tick(10);
        System.out.println("End TDDSensor");
    }
}