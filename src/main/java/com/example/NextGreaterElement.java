package com.example;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElement {

    public List<PairValue> getNextGreaterElements(int[] numbers) {
        List<PairValue> nextGreaterElements = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            for (int j = i; j < numbers.length; j++) {
                if(currentNumber < numbers[j]) {
                    addNextGreaterElement(nextGreaterElements, currentNumber, numbers[j]);
                    break;
                }
                if(numbers.length - 1 == j) {
                    addNextGreaterElement(nextGreaterElements, currentNumber, -1);
                }
            }
        }

        return nextGreaterElements;
    }

    public void printResult(List<PairValue> nextGreaterElements) {
        nextGreaterElements.forEach(result -> System.out.println(result.getValue() + " --> " + result.getNextGreaterValue()));
    }

    public void addNextGreaterElement(List<PairValue> nextGreaterElements, int currentNumber, int nextGreaterValue) {
        nextGreaterElements.add(PairValue.builder()
                .nextGreaterValue(nextGreaterValue)
                .value(currentNumber)
                .build());
    }

}
