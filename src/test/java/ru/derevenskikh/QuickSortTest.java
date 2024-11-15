package ru.derevenskikh;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class QuickSortTest {
    private ArrayList<Integer> testIntegerList;

    @BeforeEach
    public void setUp(){
        testIntegerList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        testIntegerList = null;
    }

    @DisplayName("Remove elements from List by index")
    @ParameterizedTest
    @CsvSource(value = {
            "'[1, 2, 4, 8, 11, 56]'; '4,2,8,11,1,56'",
            "'[12, 45, 68]'; '68,45,12'"
    }, delimiter = ';'
    )
    void sortTest(String expectedToString, String values){
        for (String value : values.split(",")) {
            testIntegerList.add(Integer.parseInt(value));
        }
        QuickSort.sort(testIntegerList);

        Assertions.assertEquals(expectedToString, testIntegerList.toString());
    }
}
