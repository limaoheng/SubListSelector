package au.project.lib;

import java.util.HashMap;

public class SubListSelector {

    public static int calculateSubListSum(int[] inputArray, int outputArrayLength) {
        if (inputArray.length < outputArrayLength) {
            throw new RuntimeException("Given output array length is larger than the length of the input array.");
        }

        if (inputArray.length == 0) {
            throw new RuntimeException("The input array is empty.");
        }

        if (outputArrayLength <= 0) {
            throw new RuntimeException("The output array length must be larger than 0.");
        }

        if (inputArray.length == outputArrayLength) {
            return 0;
        }

        int sum = 0;
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

        for (int i = 0; i + outputArrayLength <= inputArray.length ; i++) {

            // When i equals 0, we will need to fully calculate the sum.
            if (i == 0) {
                for (int j = i; j < outputArrayLength; j++) {
                    sum += inputArray[j];
                }
            } else {
                sum -= inputArray[i - 1];
                sum += inputArray[i + outputArrayLength - 1];
            }

            if (sum == 0) {
                return i;
            } else {
                int absSum = Math.abs(sum);
                if (sumIndexMap.containsKey(absSum)) {

                    // We are only recording the first occurrence of same distance to 0.
                    continue;
                } else {
                    sumIndexMap.put(absSum, i);
                }
            }
        }

        // If we are here, this means that we don't have any sub list is a result of 0.

        Integer finalResultIndex = null;
        for (Integer integer: sumIndexMap.keySet()) {
            if (finalResultIndex == null) {
                finalResultIndex = integer;
            } else {
                if (finalResultIndex > integer) {
                    finalResultIndex = integer;
                }
            }
        }
        return sumIndexMap.get(finalResultIndex);
    }
}
