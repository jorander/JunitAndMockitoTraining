package com.capgemini.jorander.jamt.exerciseLegacy.solution;

import com.capgemini.jorander.jamt.base.HeatSensor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyString;

/**
 * This is a solution for tests for LecgacyHeatMeasurementCollector.
 * 
 * This is a solution to the exercise. Don't look unless you really want to.
 */
public class LegacyHeatMeasurementCollectorTest {

    @Mock
    private HeatSensor mockedHeatSensor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void takesActionEveryThirdTickAndContinuesToTryWithEveryTickUponFailure() {
        LegacyHeatMeasurementCollector instance = new LegacyHeatMeasurementCollector("A sensor") {
            @Override
            protected HeatSensor getHeatSensor() {
                return null;
            }

            @Override
            protected void logMeasurement(int fahrenheit, double celsius) {
                /*Not interesting in this test*/
            }
        };

        assertFalse(instance.tick());
        assertFalse(instance.tick());
        try {
            instance.tick();
            fail("NullPointerException expected");
        } catch (NullPointerException expected) {
        }

        try {
            instance.tick();
            fail("NullPointerException expected");
        } catch (NullPointerException expected) {
        }
    }

    @Test
    public void callsHeatSensorForMeasurementAndLogsInBothFahrenheitAndCelsius() {
        final int EXPECTED_FAHRENHEIT = 8;
        final String SENSOR_NAME = "A sensor";
        LegacyHeatMeasurementCollector instance = new LegacyHeatMeasurementCollector(SENSOR_NAME) {
            @Override
            protected HeatSensor getHeatSensor() {
                return mockedHeatSensor;
            }

            @Override
            protected void logMeasurement(int fahrenheit, double celsius) {
                assertEquals("Fahrenheit value should be same as read from sensor", EXPECTED_FAHRENHEIT, fahrenheit);
                assertEquals("Celsius value should be correctly converted", -13.33, celsius, 0.005);
            }
        };
        
        when(mockedHeatSensor.measure(anyString())).thenReturn(EXPECTED_FAHRENHEIT);
        instance.tick();
        instance.tick();
        assertTrue(instance.tick());
        verify(mockedHeatSensor, times(1)).measure(SENSOR_NAME);
    }
}