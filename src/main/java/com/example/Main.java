package com.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> first = new LinkedList<>(Arrays.asList(2, 4, 3));
        List<Integer> second = new LinkedList<>(Arrays.asList(5, 6, 4));

        Iterator<Integer> firstIterator = first.iterator();
        Iterator<Integer> secondIterator = second.iterator();

        List<Integer> finalNumber = new LinkedList<>();

        boolean hasCarryOverHappenedInPrevStep = false;

        while (firstIterator.hasNext()) {
            int newNumber = 0;

            if (hasCarryOverHappenedInPrevStep) {
                newNumber += finalNumber.removeLast();
                hasCarryOverHappenedInPrevStep = false;
            }

            newNumber += firstIterator.next() + secondIterator.next();
            if (newNumber > 9) {
                finalNumber.add(newNumber - 10);
                finalNumber.add(newNumber / 10);
                hasCarryOverHappenedInPrevStep = true;
                continue;
            }
            finalNumber.add(newNumber);
        }

        System.out.println("Sum: " + finalNumber);
    }
}
