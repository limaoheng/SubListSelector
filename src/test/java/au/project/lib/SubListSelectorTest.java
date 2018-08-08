package au.project.lib;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubListSelectorTest {

    @Test(expected = RuntimeException.class)
    public void testGivenArrayLengthZero() {
        int[] arr = {};
        SubListSelector.calculateSubListSum(arr, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testGivenOutputLengthLargerThanArrayLength() {
        int[] arr = {};
        SubListSelector.calculateSubListSum(arr, 1);
    }

    @Test
    public void testGivenArrayLengthOne() {
        int[] arr = {5};
        assertEquals(0, SubListSelector.calculateSubListSum(arr, 1));
    }

    // All right, let's do some serious tests


    @Test
    public void testAgainstTestData() {
        TestData[] testDataArray = TestData.getTestDataArray();
        for (TestData testData : testDataArray) {
            assertEquals(testData.getMessage(), testData.getAnswer(), SubListSelector.calculateSubListSum(testData.getTestData(), testData.getOutputLength()));
        }

    }
}