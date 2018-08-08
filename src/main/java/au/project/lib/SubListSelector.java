package au.project.lib;

public class SubListSelector {

    public static int calculateSubListSum(int[] inputArray, int outputArrayLength) {
        if (inputArray.length < outputArrayLength) {
            throw new RuntimeException("Given output array length is larger than the length of the input array.");
        }

        for (int i = 0; i + outputArrayLength <= inputArray.length ; i++) {

        }

        return 0;
    }
}
