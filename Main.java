import java.util.*;
// Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

// Example 1:

// Input: [1, 2, 5, 3, 7, 10, 9, 12]
// Output: 5
// Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
// Example 2:

// Input: [1, 3, 2, 0, -1, 7, 10]
// Output: 5
// Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
// Example 3:

// Input: [1, 2, 3]
// Output: 0
// Explanation: The array is already sorted
// Example 4:

// Input: [3, 2, 1]
// Output: 3
// Explanation: The whole array needs to be sorted.

class Main {
    public static int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

  
  public static void main(String[] args) {
    System.out.println(Main.findUnsortedSubarray(new int[] {1, 2, 5, 3, 7, 10, 9, 12}));
  }
}