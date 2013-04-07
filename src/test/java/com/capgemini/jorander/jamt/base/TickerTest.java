package com.capgemini.jorander.jamt.base;

import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test that uses PowerMock to mock System.currentTimeMillis() and replaces
 * System.out with a mock.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Ticker.class)
public class TickerTest {

    @Mock
    private Tickable mockedTickable;
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
    public void ticksTheTickableCorrectNumberOfTimesAndPrintsTheResult() {
        PowerMockito.mockStatic(System.class);
        when(System.currentTimeMillis()).thenAnswer(new Answer<Long>() {
            private Long timeCounter = 0L;

            @Override
            public Long answer(InvocationOnMock invocation) throws Throwable {
                return timeCounter++;
            }
        });

        when(mockedTickable.tick()).thenReturn(true);

        Ticker instance = new Ticker(mockedTickable);
        final int numberOfTicks = 5;
        instance.tick(numberOfTicks);

        PowerMockito.verifyStatic(times(numberOfTicks * 2));
        System.currentTimeMillis();

        verify(mockedTickable, times(numberOfTicks)).tick();
        verify(mockedPrintStream, times(numberOfTicks)).println("Ticked: ActionTaken=true, Duration(ms)=1");
    }
}