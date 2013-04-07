package com.capgemini.jorander.jamt.base;

import java.util.Date;

/**
 * Class that facilitates getting measurements of a sensor.
 * 
 * For the sake of the exercises pretend you do not have access to this code.
 */
public class HeatSensor {
    
   /**
    * @param sensorName The name of the sensor to get a measurement from.
    * @return The heat measurement in Fahrenheit.
    */
    public int measure(String sensorName){
        try {
            Thread.sleep(getSleepTimeInMilliSeconds());
        } catch (InterruptedException ex) {
            /*No action here*/
        }
        return new Date(System.currentTimeMillis()).getSeconds();
    }
    
    protected final long getSleepTimeInMilliSeconds(){
        return 1000 * new Date(System.currentTimeMillis()).getSeconds() / 6;
    }
}