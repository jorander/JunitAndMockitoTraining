package com.capgemini.jorander.jamt.base;

/**
 * Class with method used to log a measurement in Fahrenheit and Celsius.
 * 
 * For the sake of the exercises pretend you do not have access to this code.
 */
public class MeasurementLogger {

    public static void logMeasurement(String sensor, int farhenheit, double celsius) {
        System.out.println("Measurement: Sensor=" + sensor + ", Fahrenheit=" + farhenheit + ", Celsius=" + celsius);
    }
}