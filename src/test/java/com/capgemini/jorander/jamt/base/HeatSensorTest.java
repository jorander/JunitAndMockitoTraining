package com.capgemini.jorander.jamt.base;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HeatSensor.class)
public class HeatSensorTest {

    private final int SECONDS = 48;

    @Before
    public void setUp() {
        PowerMockito.mockStatic(System.class);
        final Date dateWithExpectedSeconds = new Date(System.currentTimeMillis());
        dateWithExpectedSeconds.setSeconds(SECONDS);
        when(System.currentTimeMillis()).thenReturn(dateWithExpectedSeconds.getTime());
    }

    @Test
    public void returnsNoFSecondsFromSystemTimeAsFarenheit() {
        assertEquals(SECONDS, new HeatSensor().measure("Sensorname"));
    }

    @Test
    public void sleepsFor1000msTimesNoFSecondsFromSystemTimeDividedBy6() {
        assertEquals(8000, new HeatSensor().getSleepTimeInMilliSeconds());
    }
}