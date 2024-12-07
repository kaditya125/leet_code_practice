class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
     int left = 1, right = Arrays.stream(nums).max().getAsInt();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                right = mid; // Try smaller penalty
            } else {
                left = mid + 1; // Try larger penalty
            }
        }
        return left;
    }

    private boolean canDivide(int[] nums, int maxOperations, int maxPenalty) {
        int operations = 0;
        for (int balls : nums) {
            // Calculate number of splits needed for each bag
            operations += (balls - 1) / maxPenalty;
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}