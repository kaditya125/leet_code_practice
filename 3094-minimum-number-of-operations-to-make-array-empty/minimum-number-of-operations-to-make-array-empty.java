class Solution {
  public int minOperations(int[] nums) {
    int ans = 0;
    Map<Integer, Integer> count = new HashMap<>();

    for ( int num : nums)
    {
        count.put(num,count.getOrDefault(num,0)+1);
    }
     // count.merge(num, 1, Integer::sum);

    for (int freq : count.values()) {
      // If freq == 3k, need k operations.
      // If freq == 3k + 1 = 3*(k - 1) + 2*2, need k + 1 operations.
      // If freq == 3k + 2, need k + 1 operations.
      if (freq == 1)
        return -1;
      ans += (freq + 2) / 3;
    }

    return ans;
  }
}