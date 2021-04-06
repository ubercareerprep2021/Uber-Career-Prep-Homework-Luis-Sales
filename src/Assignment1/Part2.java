package Assignment1;

import java.util.*;

public class Part2 {

    // O(nlog(n) time, O(1) space
    // Assumes an unlimited ammount of characters
    public static boolean isStringPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char [] arr1 = s1.toCharArray();
        char [] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    static List<int[]> pairsThatEqualSum(List<Integer> inputArray, int targetSum) {
        List<int[]> returnList = new ArrayList<>();

        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < inputArray.size(); i++) {
            int current = inputArray.get(i);
            int complement = targetSum - current;
            if (hash.containsKey(complement)) {
                returnList.add(new int[] {inputArray.get(hash.get(complement)), current});
            }
            hash.put(current, i);
        }

        return returnList;
    }

    public static void main(String[] args) {
        System.out.println("Testing isStringPermutation: ");
        String s1 = "aab";
        String s2 = "aba";
        System.out.println(isStringPermutation(s1, s2));


        System.out.println("Testing pairsThatEqualSum: ");
        int [] inputArray = new int[] {1, 2, 3, 4, 5};
        List<Integer> inputList = new ArrayList<>();
        for (int x : inputArray) {
            inputList.add(x);
        }

        System.out.println("Case 1:");
        List<int[]> result = pairsThatEqualSum(inputList, 5);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }

        System.out.println("Case 2:");
        result = pairsThatEqualSum(inputList, 1);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }

        System.out.println("Case 3:");
        result = pairsThatEqualSum(inputList, 7);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }

}
