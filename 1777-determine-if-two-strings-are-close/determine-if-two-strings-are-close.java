import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m != n) {
            return false; 
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (char ch : word1.toCharArray()) {
            arr1[ch - 'a']++; 
            a1[ch - 'a'] = 1;
        }

        for (char ch : word2.toCharArray()) {
            arr2[ch - 'a']++; 
            a2[ch - 'a'] = 1; 
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

      
        return Arrays.equals(arr1, arr2) && Arrays.equals(a1, a2);
    }
}
