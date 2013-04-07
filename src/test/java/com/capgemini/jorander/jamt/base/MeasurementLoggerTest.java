package com.capgemini.jorander.jamt.base;

import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

public class MeasurementLoggerTest {

    @Mock
    private PrintStream mockedPrintStream;
    private PrintStream originalPrintStream;

    @Before
    public void setUp() {
        originalPrintStream = System.out;
        MockitoAnnotations.initMocks(this);

        System.setOut(mockedPrintStream);
    }

    @After
    public void tearDown() {
        System.setOut(originalPrintStream);
    }

    @Test
    public void logsToSystemOut() {
        final String SENSOR = "En sensor";
        final int FAHRENHEIT = 34;
        final double CELSIUS = 5.67886;
        
        MeasurementLogger.logMeasurement(SENSOR, FAHRENHEIT, CELSIUS);
        
        verify(mockedPrintStream).println("Measurement: Sensor=" + SENSOR + ", Fahrenheit=" + FAHRENHEIT + ", Celsius=" + CELSIUS);
    }
}