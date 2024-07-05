class Solution {
     public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        // Count the number of zeros to be duplicated
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }

        // Traverse the array from the end
        for (int i = n - 1; i >= 0; i--) {
            if (i + zeros < n) {
                arr[i + zeros] = arr[i];
            }
            if (arr[i] == 0) {
                zeros--;
                if (i + zeros < n) {
                    arr[i + zeros] = 0;
                }
            }  
    }
     }
     }