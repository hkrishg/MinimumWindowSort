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
    public static int findUnsortedSubarray(int[] arr) {
      int n = arr.length;
      int s = 0, e = n-1, i, max, min;   
        
      // step 1(a) of above algo
      for (s = 0; s < n-1; s++)
      {
        if (arr[s] > arr[s+1])
          break;
      }
      if (s == n-1)
      {
        System.out.println("The complete array is sorted");
        return 0;
      }
        
      // step 1(b) of above algo
      for(e = n - 1; e > 0; e--)
      {
        if(arr[e] < arr[e-1])
          break;
      }
        
      // step 2(a) of above algo
      max = arr[s]; min = arr[s];
      for(i = s + 1; i <= e; i++)
      {
        if(arr[i] > max)
          max = arr[i];
        if(arr[i] < min)
          min = arr[i];
      }
        
      // step 2(b) of above algo
      for( i = 0; i < s; i++)
      {
        if(arr[i] > min)
        {  
          s = i;
          break;
        }      
      } 
        
      // step 2(c) of above algo
      for( i = n -1; i >= e+1; i--)
      {
        if(arr[i] < max)
        {
          e = i;
          break;
        } 
      }  
        return e - s + 1;
    }

  
  public static void main(String[] args) {
    System.out.println(Main.findUnsortedSubarray(new int[] {1, 2, 5, 3, 7, 10, 9, 12}));
  }
}