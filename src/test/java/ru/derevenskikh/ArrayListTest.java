package ru.derevenskikh;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTest {

    private ArrayList<Integer> testIntegerList;
    private ArrayList<String> testStringList;

    @BeforeEach
    public void setUp() {
        testIntegerList = new ArrayList<>();
        testStringList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        testStringList = null;
        testIntegerList = null;
    }


    @DisplayName("Test add to list")
    @ParameterizedTest
    @CsvSource(value = {
            "7; '[1, 2, 3, 4, 5, 6, 7]'; '1,2,3,4,5,6,7'",
            "4; '[4, 3, 2, 1]'; '4,3,2,1'"
    }, delimiter = ';'
    )
    void addTest(int expectedCount, String expectedToString, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
            testIntegerList.add(Integer.parseInt(value));
        }

        Assertions.assertAll("Add in loop test",
                () -> assertEquals(expectedCount, testStringList.size()),
                () -> assertEquals(expectedToString, testStringList.toString()),
                () -> assertEquals(expectedCount, testIntegerList.size()),
                () -> assertEquals(expectedToString, testIntegerList.toString())
        );

    }

    @DisplayName("Add a lot of elements to List in Loop")
    @ParameterizedTest
    @CsvSource(value = {
            "300",
            "100500"
    })
    void addInLoopTest(int expectedCount) {
        StringJoiner sjExpected = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < expectedCount; i++) {
            testStringList.add(Integer.toString(i));
            testIntegerList.add(i);
            sjExpected.add(Integer.toString(i));
        }

        Assertions.assertAll("Add in loop test",
                () -> assertEquals(expectedCount, testStringList.size()),
                () -> assertEquals(sjExpected.toString(), testStringList.toString()),
                () -> assertEquals(expectedCount, testIntegerList.size()),
                () -> assertEquals(sjExpected.toString(), testIntegerList.toString())
        );
    }

    @DisplayName("Insert elements to List")
    @ParameterizedTest
    @CsvSource(value = {
            "4; '[0, 1, 2, 3]';    0; 0; '1,2,3'", // at start
            "4; '[1, 2, 0, 3]';    2; 0; '1,2,3'", // into middle
            "5; '[4, 3, 2, 1, 0]'; 4; 0; '4,3,2,1'" // into end
    }, delimiter = ';'
    )
    void insertTest(int expectedCount, String expectedToString, int index, String element, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
            testIntegerList.add(Integer.parseInt(value));
        }
        testStringList.insert(index, element);
        testIntegerList.insert(index, Integer.parseInt(element));

        Assertions.assertAll("Insert test",
                () -> assertEquals(expectedCount, testStringList.size()),
                () -> assertEquals(expectedToString, testStringList.toString()),
                () -> assertEquals(expectedCount, testIntegerList.size()),
                () -> assertEquals(expectedToString, testIntegerList.toString())
        );
    }

    @DisplayName("Insert elements to List in Loop")
    @ParameterizedTest
    @CsvSource(value = {
            "300",
            "100500"
    })
    void insertInLoopTest(int expectedCount) {
        StringJoiner sjExpected = new StringJoiner(", ", "[", "]");
        testStringList.add("a");
        testStringList.add("b");
        sjExpected.add("a");
        for (int i = 0; i < expectedCount - 2; i++) {
            testStringList.insert(1, "x");
            sjExpected.add("x");
        }
        sjExpected.add("b");

        Assertions.assertAll("Insert in loop test test",
                () -> assertEquals(expectedCount, testStringList.size()),
                () -> assertEquals(sjExpected.toString(), testStringList.toString())
        );

    }

    @DisplayName("Remove elements from List by index")
    @ParameterizedTest
    @CsvSource(value = {
            "2; 2; '[1, 3]'; 1; '1,2,3'",
            "3; 3; '[4, 2, 1]'; 1; '4,3,2,1'"
    }, delimiter = ';'
    )
    void removeTest(int expectedCount, String expectedElement, String expectedToString, int index, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
        }
        Object removedElement = testStringList.remove(index);

        Assertions.assertAll("Remove test",
                () -> assertEquals(expectedCount, testStringList.size()),
                () -> assertEquals(expectedToString, testStringList.toString()),
                () -> assertEquals(expectedElement, removedElement)
        );
    }

    @DisplayName("Remove elements from List by index")
    @ParameterizedTest
    @CsvSource(value = {
            "0; '[]'; '1,2,3'",
            "0; '[]'; '4,3,2,1'"
    }, delimiter = ';'
    )
    void clearTest(int expectedCount, String expectedToString, String values) {
        for (String value : values.split(",")) {
            testStringList.add(value);
        }
        testStringList.clear();

        Assertions.assertAll("Clear test",
                () -> assertEquals(expectedCount, testStringList.size()),
                () -> assertEquals(expectedToString, testStringList.toString())
        );
    }
}
