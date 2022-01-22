package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NextGreaterElementTest {

    private NextGreaterElement nextGreaterElement;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        nextGreaterElement = new NextGreaterElement();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testWhenElementsIsEmptyThenReturnEmptyList(){
        int[] numbers = {};
        List<PairValue> result = nextGreaterElement.getNextGreaterElements(numbers);
        assertEquals(0, result.size());
    }

    @Test
    public void testElementsHaveNextGreater() {
        List<PairValue> resultExpected = new ArrayList<>();
        nextGreaterElement.addNextGreaterElement(resultExpected, 11,13);
        nextGreaterElement.addNextGreaterElement(resultExpected, 13,21);
        nextGreaterElement.addNextGreaterElement(resultExpected, 21,-1);
        nextGreaterElement.addNextGreaterElement(resultExpected, 3,-1);

        int[] numbers = {11, 13, 21, 3};
        List<PairValue> result = nextGreaterElement.getNextGreaterElements(numbers);

        assertEquals(4, result.size());
        assertEquals(resultExpected, result);
    }

    @Test
    public void testPrintResult_withElementsHaveNextGreater() {
        int[] numbers = {11, 13};
        List<PairValue> result = nextGreaterElement.getNextGreaterElements(numbers);
        nextGreaterElement.printResult(result);

        assertEquals("11 --> 13"+System.lineSeparator()+"13 --> -1", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testAddNextGreaterElement() {
        List<PairValue> resultExpected = new ArrayList<>();
        nextGreaterElement.addNextGreaterElement(resultExpected, 11,13);

        assertEquals(1, resultExpected.size());
    }
}
