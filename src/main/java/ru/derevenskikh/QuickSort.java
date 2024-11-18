package ru.derevenskikh;

import java.util.Comparator;

public class QuickSort {

    /**
     * Static method for sort elements
     * @param list - object of class "MyArrayList", elements of which implements Comparable interface
     */
    public static void sort(NewArrayList<? extends Comparable> list) {
        quickSort(0, list.size() - 1, list);
    }

    public static void sort(NewArrayList list, Comparator comparator) {
        quickSort(0, list.size() - 1, list, comparator);
    }

    /**
     * Realisation of QuickSort with Comparator
     *
     * @param low        - bound of array
     * @param high       - bound of array
     */
    private static void quickSort(int low, int high, NewArrayList<Object> list, Comparator comparator){
        Object[] elementData = list.getElementData();
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        Object opor = elementData[middle];

        int leftBound = low;
        int rightBound = high;
        while (leftBound <= rightBound) {
            while (comparator.compare(elementData[leftBound], opor) < 0) {
                leftBound++;
            }
            while (comparator.compare(elementData[rightBound], opor) > 0) {
                rightBound--;
            }
            if (leftBound <= rightBound) {
                Object temp = elementData[leftBound];
                elementData[leftBound] = elementData[rightBound];
                elementData[rightBound] = temp;
                leftBound++;
                rightBound--;
            }
        }
        if (low < rightBound) {
            quickSort(low, rightBound, list, comparator);
        }
        if (high > leftBound) {
            quickSort(leftBound, high, list, comparator);
        }
    }

    /**
     * Realisation of QuickSort with Comparable
     *
     * @param low        - bound of array
     * @param high       - bound of array
     */
    private static void quickSort(int low, int high, NewArrayList<? extends Comparable> list) {
        Object[] elementData = list.getElementData();

        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        Object opor = elementData[middle];

        int leftBound = low;
        int rightBound = high;
        while (leftBound <= rightBound) {
            while ((((Comparable)elementData[leftBound]).compareTo(opor)) < 0) {
                leftBound++;
            }
            while ((((Comparable)elementData[rightBound]).compareTo(opor)) > 0) {
                rightBound--;
            }
            if (leftBound <= rightBound) {
                Object temp = elementData[leftBound];
                elementData[leftBound] = elementData[rightBound];
                elementData[rightBound] = temp;
                leftBound++;
                rightBound--;
            }
        }
        if (low < rightBound) {
            quickSort(low, rightBound, list);
        }
        if (high > leftBound) {
            quickSort(leftBound, high, list);
        }
    }
}

