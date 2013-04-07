package com.capgemini.jorander.jamt.exerciseTDD.solution;

import com.capgemini.jorander.jamt.base.HeatSensor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * This is a solution to the exercise. Don't look unless you really want to.
 * 
 * Requirements (repeated here for convenience):
 * Action is taken every third tick.
 * When action is taken this object 
 *  - reads the HeatSensor with the supplied name,
 *  - converts from Fahrenheit to Celsius (C = (F-32)*5/9), and
 *  - logs the result to MeasurmentLogger.
 */
public class TDDHeatMeasurementCollectorTest {
    private static final String SENSOR_NAME = "Sensor name";
    
    @Mock
    private MeasurementLoggerObject mockMeasurementLoggerObject;
    @Mock
    private HeatSensor mockHeatSensor;
    
    private TDDHeatMeasurementCollector instance;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        instance = new TDDHeatMeasurementCollector(SENSOR_NAME, mockHeatSensor, mockMeasurementLoggerObject);
    }
    
    @Test
    public void takesActionEveryThirdTick() {
        assertFalse("No action taken on first call", instance.tick());
        assertFalse("No action taken on second call", instance.tick());
        assertTrue("Action taken on third call", instance.tick());
        
        assertFalse("No action taken on forth call", instance.tick());
        assertFalse("No action taken on fith call", instance.tick());
        assertTrue("Action taken on sixth call", instance.tick());
    }
    
    @Test
    public void callsHeatSensorForMeasurementAndLogsInBothFahrenheitAndCelsius() {
        final int EXPECTED_FAHRENHEIT = 8;
        final double EXPECTED_CELSIUS = -13;
        
        when(mockHeatSensor.measure(SENSOR_NAME)).thenReturn(EXPECTED_FAHRENHEIT);
                
        instance.tick();
        instance.tick();
        instance.tick();
        verify(mockMeasurementLoggerObject, times(1)).logMeasurement(SENSOR_NAME, EXPECTED_FAHRENHEIT, EXPECTED_CELSIUS);
        verify(mockHeatSensor, times(1)).measure(SENSOR_NAME);
    }
}