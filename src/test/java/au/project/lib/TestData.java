package au.project.lib;

public class TestData {
    private int[] testData;
    private int outputLength;
    private int answer;
    private String message;

    public TestData(int[] testData, int outputLength, int answer, String message) {
        this.testData = testData;
        this.outputLength = outputLength;
        this.answer = answer;
    }

    public int[] getTestData() {
        return testData;
    }

    public int getOutputLength() {
        return outputLength;
    }

    public int getAnswer() {
        return answer;
    }

    public String getMessage() {
        return this.message;
    }

    public static TestData[] getTestDataArray() {
        TestData[] testData = {
            new TestData(new int[]{-1, 0, 1}, 3, 0, "Test case 1"),
            new TestData(new int[]{-1, -1, 0, 1}, 3, 1, "Test case 2"),
            new TestData(new int[]{-1, 0, 1}, 2, 0, "Test case 3"),
            new TestData(new int[]{-1, -1, -1, -1, -1}, 2, 0, "Test case 4"),
            new TestData(new int[]{2, 2, -3, 0, 2}, 2, 1, "Test case 5"),
            new TestData(new int[]{2, 2, -3, 0, 2}, 3, 0, "Test case 6"),
            new TestData(new int[]{100, -2000, 0, 1234, 7777, -900}, 3, 1, "Test case 7"),
            new TestData(new int[]{100, -2000, 0, 0, 0, -900}, 3, 2, "Test case 8"),
        };
        return testData;
    }

}
